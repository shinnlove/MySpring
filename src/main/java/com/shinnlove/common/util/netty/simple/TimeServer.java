/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.shinnlove.common.util.netty.simple;

import java.util.Date;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * Netty时间服务器服务端TimeServer。
 *
 * @author shinnlove.jinsheng
 * @version $Id: TimeServer.java, v 0.1 2018-05-12 上午10:13 shinnlove.jinsheng Exp $$
 */
public class TimeServer {

    public void bind(int port) throws Exception {
        // Reactor线程组

        // 服务端处理客户端
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        // 客户端读写
        EventLoopGroup workGroup = new NioEventLoopGroup();

        try {
            // ServerBootstrap是Netty用于启动NIO服务端的启动辅助类
            ServerBootstrap b = new ServerBootstrap();

            // group设置父子线程组
            // channel设置处理通道类，NioServerSocketChannel类似JDO NIO 的ServerSocketChannel
            // option配置TCP参数
            // childHandler配置IO事件处理器(记录日志、消息编解码)
            b.group(bossGroup, workGroup).channel(NioServerSocketChannel.class)
                .option(ChannelOption.SO_BACKLOG, 1024).childHandler(new ChildChannelHandler());

            // 绑定端口，sync同步等待成功，netty服务端是bind().sync()
            // ChannelFuture类似JDK的Future
            ChannelFuture f = b.bind(port).sync();

            // 等待服务端关闭main函数才推出
            f.channel().closeFuture().sync();
        } finally {
            // 优雅退出，释放线程池资源
            bossGroup.shutdownGracefully();
            workGroup.shutdownGracefully();
        }
    }

    private class ChildChannelHandler extends ChannelInitializer<SocketChannel> {

        @Override
        protected void initChannel(SocketChannel ch) throws Exception {

            // 一个channel打开的时候就会有一个pipeline管道，里边存放了所有ChannelHandler
            // ChannelHandler支持的注解有：Sharable->多个pipeline共用一个ChannelHandler；Skip->透传事件，不会调用(简化代码)
            // 管道可以持有1-N的处理器，addLast是添加最后一个(因为要发送出去了)
            ch.pipeline().addLast(new ChannelHandlerAdapter() {

                /**
                 * 当通道从对端(客户端)读完一条消息时。
                 *
                 * @param ctx           通道处理上下文
                 * @param msg           从对端(客户端)读入的消息
                 * @throws Exception
                 */
                @Override
                public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
                    ByteBuf buf = (ByteBuf) msg;
                    byte[] req = new byte[buf.readableBytes()];
                    buf.readBytes(req);
                    String body = new String(req, "UTF-8");

                    System.out.println("The time server receive order:" + body);

                    String currentTime = "QUERY TIME ORDER".equalsIgnoreCase(body) ? new Date(
                        System.currentTimeMillis()).toString() : "BAD ORDER";

                    ByteBuf resp = Unpooled.copiedBuffer(currentTime.getBytes());

                    // 防止频繁唤醒selector进行消息发送，write方法不直接将消息写入SocketChannel中，放到缓冲数组中
                    ctx.write(resp);
                }

                /**
                 * 通道读入最后一条消息完成时
                 * 
                 * @param ctx
                 * @throws Exception
                 */
                @Override
                public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
                    // flush会把缓冲区消息写到SocketChannel中
                    ctx.flush();
                }

                /**
                 * 通道读写发生错误时
                 *
                 * @param ctx
                 * @param cause
                 */
                @Override
                public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
                    ctx.close();
                }

            });
        }
    }

    public static void main(String[] args) throws Exception {
        int port = 8080;
        if (args != null && args.length > 0) {
            try {
                port = Integer.valueOf(args[0]);
            } catch (NumberFormatException e) {

            }
        }
        new TimeServer().bind(port);
    }

}
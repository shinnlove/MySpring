/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.shinnlove.common.util.netty.simple;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * Netty时间服务器例子的客户端。
 *
 * @author shinnlove.jinsheng
 * @version $Id: TimeClient.java, v 0.1 2018-05-12 上午11:07 shinnlove.jinsheng Exp $$
 */
public class TimeClient {

    public void connect(int port, String host) throws Exception {

        // 客户端netty线程组
        EventLoopGroup group = new NioEventLoopGroup();

        try {
            // netty启动类
            Bootstrap b = new Bootstrap();

            // 客户端是SocketChannel、服务端是ServerSocketChannel
            b.group(group).channel(NioSocketChannel.class).option(ChannelOption.TCP_NODELAY, true)
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception {
                        ch.pipeline().addLast(new ChannelHandlerAdapter() {

                            /**
                             * 当客户端和服务端TCP链路建立成功之后，Netty的NIO线程会调用channelActive方法。
                             *
                             * @param ctx
                             */
                            @Override
                            public void channelActive(ChannelHandlerContext ctx) {
                                // 这里链接建立成功直接发送请求
                                byte[] req = "QUERY TIME ORDER".getBytes();
                                ByteBuf firstMessage = Unpooled.buffer(req.length);
                                // write写到缓冲区、flush写入通道中
                                ctx.writeAndFlush(firstMessage);
                            }

                            /**
                             * 客户端通道可读：当从服务端接收到消息后调用。
                             *
                             * @param ctx
                             * @param msg
                             * @throws Exception
                             */
                            @Override
                            public void channelRead(ChannelHandlerContext ctx, Object msg)
                                                                                          throws Exception {
                                ByteBuf buf = (ByteBuf) msg;
                                byte[] req = new byte[buf.readableBytes()];
                                buf.readBytes(req);

                                String body = new String(req, "UTF-8");
                                System.out.println("Now is : " + body);
                            }

                            /**
                             * 通道连接出错。
                             * 
                             * @param ctx
                             * @param cause
                             */
                            @Override
                            public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
                                // 可以打个日志
                                ctx.close();
                            }

                        });
                    }
                });

            // 发起异步连接操作
            ChannelFuture f = b.connect(host, port).sync();

            // 等待客户端链接关闭
            f.channel().closeFuture().sync();
        } finally {
            // 优雅退出，释放NIO线程组
            group.shutdownGracefully();
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
        new TimeClient().connect(port, "127.0.0.1");
    }

}
/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.shinnlove.common.util.netty.http.file;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpRequestDecoder;
import io.netty.handler.codec.http.HttpResponseEncoder;
import io.netty.handler.stream.ChunkedWriteHandler;

/**
 * Netty的HttpFileServer文件服务器。
 *
 * @author shinnlove.jinsheng
 * @version $Id: HttpFileServer.java, v 0.1 2018-05-12 下午5:47 shinnlove.jinsheng Exp $$
 */
public class HttpFileServer {

    private static final String IP_ADDRESS  = "192.168.1.102";

    private static final String DEFAULT_URL = "/src/com/phei/netty/";

    public void run(final int port, final String url) throws Exception {
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        try {
            ServerBootstrap b = new ServerBootstrap();
            b.group(bossGroup, workerGroup).channel(NioServerSocketChannel.class)
                .childHandler(new ChannelInitializer<SocketChannel>() {

                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception {
                        ch.pipeline().addLast("http-decoder", new HttpRequestDecoder());
                        ch.pipeline().addLast("http-aggregator", new HttpObjectAggregator(65536));
                        ch.pipeline().addLast("http-encoder", new HttpResponseEncoder());
                        ch.pipeline().addLast("http-chunked", new ChunkedWriteHandler());
                        ch.pipeline().addLast("fileServerHandler",
                            new SimpleChannelInboundHandler<FullHttpRequest>() {

                                @Override
                                protected void messageReceived(ChannelHandlerContext ctx,
                                                               FullHttpRequest msg)
                                                                                   throws Exception {

                                }

                            });
                    }

                });

            ChannelFuture future = b.bind(IP_ADDRESS, port).sync();

            System.out.println("HTTP文件目录服务器启动，网址是：" + IP_ADDRESS + port + url);

            future.channel().closeFuture().sync();

        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }

    }

}
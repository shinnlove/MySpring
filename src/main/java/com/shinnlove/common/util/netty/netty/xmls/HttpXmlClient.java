/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.shinnlove.common.util.netty.netty.xmls;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpResponseDecoder;

/**
 * HTTP+XML客户端启动类。
 *
 * @author shinnlove.jinsheng
 * @version $Id: HttpXmlClient.java, v 0.1 2018-05-12 下午10:00 shinnlove.jinsheng Exp $$
 */
public class HttpXmlClient {

    public void connect(int port) throws Exception {
        // 客户端NIO线程组
        EventLoopGroup group = new NioEventLoopGroup();

        // 配置启动类
        Bootstrap b = new Bootstrap();
        b.group(group).channel(NioSocketChannel.class).option(ChannelOption.TCP_NODELAY, true)
            .handler(new ChannelInitializer<SocketChannel>() {

                @Override
                protected void initChannel(SocketChannel ch) throws Exception {
                    ch.pipeline().addLast("http-decoder", new HttpResponseDecoder());
                    ch.pipeline().addLast("http-aggregator", new HttpObjectAggregator(65536));
                    // XML解码器
                    //                    ch.pipeline().addLast("xml-decoder", new httpxml)
                }
            });

    }

}
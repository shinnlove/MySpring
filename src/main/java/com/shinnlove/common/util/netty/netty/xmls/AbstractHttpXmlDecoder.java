/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.shinnlove.common.util.netty.netty.xmls;

import java.io.StringWriter;
import java.nio.charset.Charset;

import org.jibx.runtime.BindingDirectory;
import org.jibx.runtime.IBindingFactory;
import org.jibx.runtime.IMarshallingContext;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageDecoder;

/**
 * 抽象HTTP-XML消息解码抽象类，继承自{@link MessageToMessageDecoder}。
 *
 * @author shinnlove.jinsheng
 * @version $Id: AbstractHttpXmlDecoder.java, v 0.1 2018-05-12 下午10:07 shinnlove.jinsheng Exp $$
 */
public abstract class AbstractHttpXmlDecoder<T> extends MessageToMessageDecoder<T> {

    IBindingFactory      factory      = null;
    StringWriter         writer       = null;
    final static String  CHARSET_NAME = "UTF-8";
    final static Charset UTF_8        = Charset.forName(CHARSET_NAME);

    /**
     * 初始化解码，将消息转成XML并且写成二进制。
     *
     * @param ctx
     * @param body          具体业务类实例，准备转化为XML再到二进制码流!!!
     * @return
     * @throws Exception
     */
    protected ByteBuf encode0(ChannelHandlerContext ctx, Object body) throws Exception {
        factory = BindingDirectory.getFactory(body.getClass());
        writer = new StringWriter();
        IMarshallingContext mctx = factory.createMarshallingContext();

        // 以UTF-8方式缩进2格生成XML
        mctx.setIndent(2);
        mctx.marshalDocument(body, CHARSET_NAME, null, writer);
        String xmlStr = writer.toString();
        writer.close();
        writer = null;

        // 将XML转成二进制流
        ByteBuf encodeBuf = Unpooled.copiedBuffer(xmlStr, UTF_8);
        return encodeBuf;
    }

    /**
     * 发生错误的时候关闭writer。
     *
     * @param ctx
     * @param cause
     * @throws Exception
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        if (writer != null) {
            writer.close();
            writer = null;
        }
    }

}
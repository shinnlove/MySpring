/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.shinnlove.common.util.netty.netty.xmls;

import java.util.List;

import io.netty.channel.ChannelHandlerContext;

/**
 * 应答消息XML编码类的实现。
 *
 * @author shinnlove.jinsheng
 * @version $Id: HttpXmlResponseEncoder.java, v 0.1 2018-05-12 下午10:05 shinnlove.jinsheng Exp $$
 */
public class HttpXmlResponseEncoder extends AbstractHttpXmlDecoder<HttpXmlRequest> {

    @Override
    protected void decode(ChannelHandlerContext ctx, HttpXmlRequest msg, List<Object> out)
                                                                                          throws Exception {

    }

}
/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.shinnlove.common.util.netty.netty.xmls;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import io.netty.handler.codec.http.FullHttpRequest;

/**
 * HTTP+XML请求消息。
 *
 * @author shinnlove.jinsheng
 * @version $Id: HttpXmlRequest.java, v 0.1 2018-05-12 下午11:16 shinnlove.jinsheng Exp $$
 */
public class HttpXmlRequest {

    private FullHttpRequest request;
    private Object          body;

    public HttpXmlRequest() {
    }

    public HttpXmlRequest(FullHttpRequest request, Object body) {
        this.request = request;
        this.body = body;
    }

    /**
     * Getter method for property request.
     *
     * @return property value of request
     */
    public final FullHttpRequest getRequest() {
        return request;
    }

    /**
     * Setter method for property request.
     *
     * @param request value to be assigned to property request
     */
    public final void setRequest(FullHttpRequest request) {
        this.request = request;
    }

    /**
     * Getter method for property body.
     *
     * @return property value of body
     */
    public final Object getBody() {
        return body;
    }

    /**
     * Setter method for property body.
     *
     * @param body value to be assigned to property body
     */
    public final void setBody(Object body) {
        this.body = body;
    }

    /**
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

}
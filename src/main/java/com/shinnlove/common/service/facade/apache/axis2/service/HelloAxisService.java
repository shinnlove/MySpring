/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.shinnlove.common.service.facade.apache.axis2.service;

/**
 * 使用axis2发布WebService服务接口。
 *
 * @author shinnlove.jinsheng
 * @version $Id: HelloAxisService.java, v 0.1 2018-01-06 上午11:01 shinnlove.jinsheng Exp $$
 */
public interface HelloAxisService {

    /**
     * WebService请求服务接口。
     *
     * @param content 请求进来的内容
     * @return
     */
    String getResponse(String content);

}

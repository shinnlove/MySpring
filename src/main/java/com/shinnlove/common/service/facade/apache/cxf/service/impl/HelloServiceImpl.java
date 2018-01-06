/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package com.shinnlove.common.service.facade.apache.cxf.service.impl;

import com.shinnlove.common.service.facade.apache.cxf.service.HelloService;

import javax.jws.WebService;

/**
 * CXF发布的WebService服务实现类。
 *
 * @author shinnlove.jinsheng
 * @version $Id: HelloServiceImpl.java, v 0.1 2017-11-29 下午9:37 shinnlove.jinsheng Exp $$
 */
@WebService(endpointInterface = "com.shinnlove.common.service.facade.apache.cxf.service.HelloService")
public class HelloServiceImpl implements HelloService {

    /**
     * @see com.shinnlove.common.service.facade.apache.cxf.service.HelloService#sayHello(String)
     */
    @Override
    public String sayHello(String content) {
        return "hello, " + content;
    }

}
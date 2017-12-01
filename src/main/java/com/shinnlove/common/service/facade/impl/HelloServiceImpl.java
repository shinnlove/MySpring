/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package com.shinnlove.common.service.facade.impl;

import com.shinnlove.common.service.facade.HelloService;

import javax.jws.WebService;

/**
 * 服务实现类
 *
 * @author shinnlove.jinsheng
 * @version $Id: HelloServiceImpl.java, v 0.1 2017-11-29 下午9:37 shinnlove.jinsheng Exp $$
 */
@WebService(endpointInterface = "com.shinnlove.common.service.facade.HelloService")
public class HelloServiceImpl implements HelloService {

    @Override
    public String sayHello(String content) {
        return "hello, " + content;
    }

}
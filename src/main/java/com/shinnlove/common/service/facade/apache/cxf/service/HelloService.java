/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package com.shinnlove.common.service.facade.apache.cxf.service;

import javax.jws.WebService;

/**
 * CXF发布的WebService服务接口。
 *
 * @author shinnlove.jinsheng
 * @version $Id: HelloService.java, v 0.1 2017-11-29 下午9:36 shinnlove.jinsheng Exp $$
 */
@WebService
public interface HelloService {

    /**
     * ws发布的WebService服务。
     *
     * @param content
     * @return
     */
    String sayHello(String content);

}

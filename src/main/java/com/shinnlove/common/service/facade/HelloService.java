/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package com.shinnlove.common.service.facade;

import javax.jws.WebService;

/**
 * 服务接口
 *
 * @author shinnlove.jinsheng
 * @version $Id: HelloService.java, v 0.1 2017-11-29 下午9:36 shinnlove.jinsheng Exp $$
 */
@WebService
public interface HelloService {

    String sayHello(String content);

}

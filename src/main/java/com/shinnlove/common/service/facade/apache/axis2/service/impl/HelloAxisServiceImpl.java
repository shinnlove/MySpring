/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.shinnlove.common.service.facade.apache.axis2.service.impl;

import com.shinnlove.common.service.facade.apache.axis2.service.HelloAxisService;

/**
 * axis服务的实现类。
 *
 * @author shinnlove.jinsheng
 * @version $Id: HelloAxisServiceImpl.java, v 0.1 2018-01-06 上午11:08 shinnlove.jinsheng Exp $$
 */
public class HelloAxisServiceImpl implements HelloAxisService {

    /**
     * @see com.shinnlove.common.service.facade.apache.axis2.service.HelloAxisService#getResponse(String)
     */
    @Override
    public String getResponse(String content) {
        return "得到请求" + content + "，产生回复：收到！";
    }

}
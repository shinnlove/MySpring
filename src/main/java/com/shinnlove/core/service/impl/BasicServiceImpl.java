/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package com.shinnlove.core.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.shinnlove.common.model.User;
import com.shinnlove.core.service.BasicService;

/**
 * @author shinnlove.jinsheng
 * @version $Id: BasicServiceImpl.java, v 0.1 2017-12-01 上午11:48 shinnlove.jinsheng Exp $$
 */
public class BasicServiceImpl implements BasicService {

    /**
     * @see com.shinnlove.core.service.BasicService#UserToJson(com.shinnlove.common.model.User)
     */
    @Override
    public String UserToJson(User user) {
        JSONObject object = new JSONObject();
        object.put("id", user.getId());
        object.put("name", user.getName());
        object.put("password", user.getPassword());
        object.put("age", user.getAge());
        return object.toJSONString();
    }

}
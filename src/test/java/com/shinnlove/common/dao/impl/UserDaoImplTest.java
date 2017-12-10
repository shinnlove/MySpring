/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package com.shinnlove.common.dao.impl;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.shinnlove.common.dao.UserDao;
import com.shinnlove.common.model.User;

/**
 * 用户仓储测试类
 *
 * @author shinnlove.jinsheng
 * @version $Id: UserDaoImplTest.java, v 0.1 2017-11-25 下午10:50 shinnlove.jinsheng Exp $$
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= "classpath:/META-INF/spring/*.xml")
public class UserDaoImplTest {

    @Autowired
    private UserDao userDao;

    @Test
    public void getUserById() {
        User user = userDao.getUserById(8);
        Assert.assertEquals("evelyn", user.getName());
    }

}
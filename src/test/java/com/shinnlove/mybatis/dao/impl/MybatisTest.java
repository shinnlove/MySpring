/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package com.shinnlove.mybatis.dao.impl;

import com.shinnlove.common.dao.mybatis.UserDao;
import com.shinnlove.common.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 测试mybatis接入。
 *
 * @author shinnlove.jinsheng
 * @version $Id: MybatisTest.java, v 0.1 2017-12-31 下午6:46 shinnlove.jinsheng Exp $$
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/META-INF/spring/*.xml")
public class MybatisTest {

    @Autowired
    private UserDao userDao;

    @Test
    public void test_mybatis() {
        User user = userDao.getUserById(3);
        System.out.println(user);
    }

}
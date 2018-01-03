/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.shinnlove.groovy;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.shinnlove.common.service.integration.HelloWorldService;

/**
 * groovy测试类。
 *
 * @author shinnlove.jinsheng
 * @version $Id: GroovyLoadTest.java, v 0.1 2018-01-03 下午2:25 shinnlove.jinsheng Exp $$
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/META-INF/spring/*.xml")
public class GroovyLoadTest {

    @Autowired
    protected ApplicationContext ctx;

    @Test
    public void test_groovy() {
        // 特别注意：动态注入的时候一定要判断下上下文环境中是否有相关bean的id！！！
        HelloWorldService service = (HelloWorldService) ctx.getBean("helloWorldService");
        System.out.println(service.sayHello());
    }

}
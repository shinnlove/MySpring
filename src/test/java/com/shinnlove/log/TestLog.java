/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package com.shinnlove.log;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Log4jConfigurer;

/**
 * @author shinnlove.jinsheng
 * @version $Id: TestLog.java, v 0.1 2017-12-10 下午1:06 shinnlove.jinsheng Exp $$
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/META-INF/spring/*.xml")
public class TestLog {

    /** 日志 */
    private static Logger logger = Logger.getLogger(TestLog.class);

    @Before
    public void init() {
        try {
            Log4jConfigurer.initLogging("classpath:META-INF/log/log4j.xml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void 测试日志输出() {
        //        logger.info("hello，你好");
        logger.warn("警告");
        logger.error("错误");
    }

}
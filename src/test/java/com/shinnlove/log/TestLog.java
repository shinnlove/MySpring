/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package com.shinnlove.log;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Log4jConfigurer;

import com.shinnlove.common.util.log.ExceptionUtil;
import com.shinnlove.common.util.log.LoggerUtil;

/**
 * 日志的单元测试类。
 *
 * @author shinnlove.jinsheng
 * @version $Id: TestLog.java, v 0.1 2017-12-10 下午1:06 shinnlove.jinsheng Exp $$
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/META-INF/spring/*.xml")
public class TestLog {

    /** 日志 */
    private static final Logger logger = LoggerFactory.getLogger(TestLog.class);

    @Before
    public void init() {
        try {
            Log4jConfigurer.initLogging("classpath:META-INF/log/log4j.properties");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void 测试日志输出() {
        LoggerUtil.info(logger, "信息");
        LoggerUtil.warn(logger, "警告");
        ExceptionUtil.error(new RuntimeException("自定义错误"), "错误");
    }

}
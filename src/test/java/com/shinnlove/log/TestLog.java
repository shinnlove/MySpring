/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package com.shinnlove.log;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author shinnlove.jinsheng
 * @version $Id: TestLog.java, v 0.1 2017-12-10 下午1:06 shinnlove.jinsheng Exp $$
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/META-INF/spring/*.xml")
public class TestLog {

    /** 日志 */
    private static Logger logger = Logger.getLogger(TestLog.class);

    @Test
    public void 测试日志输出() {
        logger.warn("你好");
    }

}
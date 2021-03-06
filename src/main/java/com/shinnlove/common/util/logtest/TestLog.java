/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package com.shinnlove.common.util.logtest;

import java.io.FileNotFoundException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Log4jConfigurer;

/**
 * 测试日志打印
 *
 * @author shinnlove.jinsheng
 * @version $Id: TestLog.java, v 0.1 2017-12-21 下午5:04 shinnlove.jinsheng Exp $$
 */
public class TestLog {

    private static Logger logger = LoggerFactory.getLogger(TestLog.class);

    static {
        try {
            Log4jConfigurer.initLogging("classpath:META-INF/log/log4j.properties");
        } catch (FileNotFoundException ex) {
            System.err.println("Cannot Initialize log4j");
        }
    }

    public static void main(String[] args) {
        logger.info("测试slf4j打印log4j类型日志");
    }

}
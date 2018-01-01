/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.shinnlove.core.service.interval.task;

import org.springframework.scheduling.annotation.Scheduled;

/**
 * 验证被注解扫描的定时任务。
 *
 * @author shinnlove.jinsheng
 * @version $Id: MyAnnotationTask.java, v 0.1 2018-01-01 上午11:18 shinnlove.jinsheng Exp $$
 */
public class MyAnnotationTask {

    @Scheduled(cron = "0 * * * * ?")
    public void annotationShowTask() {
        System.out.println("这是被注解扫描到的任务！");
    }

}
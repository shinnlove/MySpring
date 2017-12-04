/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package com.shinnlove.biz.service.interval.job;

import java.util.concurrent.TimeUnit;

/**
 * 我的定时任务。
 *
 * @author shinnlove.jinsheng
 * @version $Id: MyIntervalJob.java, v 0.1 2017-12-04 下午3:25 shinnlove.jinsheng Exp $$
 */
public class MyIntervalJob {

    /**
     * 具体的调度逻辑。
     *
     * @return
     */
    public String queryWeChatPayBill(){
        System.out.println("spring框架呼唤定时任务执行中.....");
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "定时调度查询执行完成";
    }

}
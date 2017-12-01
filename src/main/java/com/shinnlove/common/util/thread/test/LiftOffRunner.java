/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package com.shinnlove.common.util.thread.test;

import java.util.concurrent.BlockingQueue;

/**
 * @author shinnlove.jinsheng
 * @version $Id: LiftOffRunner.java, v 0.1 2017-11-21 下午8:51 shinnlove.jinsheng Exp $$
 */
public class LiftOffRunner implements Runnable {

    private BlockingQueue<LiftOff> rockets;

    public LiftOffRunner(BlockingQueue<LiftOff> rockets) {
        this.rockets = rockets;
    }

    public void add(LiftOff lo) {
        try {
            System.out.println("add准备放入");
            rockets.put(lo);
            System.out.println("add放入结束");
        } catch (InterruptedException e) {
            // 阻塞队列放入会有可能产生线程中断
            System.out.println("Interrupted during put()");
        }
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                System.out.println("run准备取出");
                LiftOff rocket = rockets.take();
                System.out.println("run已经取出");
                rocket.run();
            }
        } catch (InterruptedException e) {
            // 阻塞队列拿出会有可能产生线程中断
            System.out.println("Waking from take()");
        }
        System.out.println("Exiting LiftOffRunner");
    }

}
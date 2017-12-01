/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package com.shinnlove.common.util.thread.test;

/**
 * @author shinnlove.jinsheng
 * @version $Id: LiftOff.java, v 0.1 2017-11-21 下午8:51 shinnlove.jinsheng Exp $$
 */
public class LiftOff implements Runnable {

    protected int      countDown = 10;
    private static int taskCount = 0;
    private final int  id        = taskCount++;

    public LiftOff(int countDown) {
        this.countDown = countDown;
    }

    public String status() {
        return "Thread#id=" + id + "(" + (countDown > 0 ? countDown : "LiftOff") + ").";
    }

    @Override
    public void run() {

        while (countDown-- > 0) {
            System.out.println(status());
            Thread.yield();
        }

    }
}
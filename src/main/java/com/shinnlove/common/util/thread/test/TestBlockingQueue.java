/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package com.shinnlove.common.util.thread.test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;

/**
 * @author shinnlove.jinsheng
 * @version $Id: TestBlockingQueue.java, v 0.1 2017-11-21 下午8:51 shinnlove.jinsheng Exp $$
 */
public class TestBlockingQueue {

    static void test(String msg, BlockingQueue<LiftOff> queue) {
        System.out.println(msg);
        LiftOffRunner runner = new LiftOffRunner(queue);
        Thread t = new Thread(runner);
        t.start();
        for (int i = 0; i < 5; i++) {
            runner.add(new LiftOff(5));
        }

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("press Enter " + msg);
        t.interrupt();
        System.out.println("Finished " + msg + " test");
    }

    public static void main(String[] args) {
        runLinkedBlockingQueue();

        runArrayBlockingQueue();

        runLinkedBlockingDeque();
    }

    private static void runLinkedBlockingQueue() {
        // 无限尺寸，可以做到Integer.MAX_VALUE
        test("LinkedBlockingQueue", new LinkedBlockingQueue<LiftOff>());
    }

    private static void runArrayBlockingQueue() {
        // 尺寸固定，一开始内存就分配好，做有界队列
        test("ArrayBlockingQueue", new ArrayBlockingQueue<LiftOff>(3));
    }

    private static void runLinkedBlockingDeque() {
        // Size只有1，每次只能放入1个，等取走了才能放入新的
        test("SynchronousQueue", new SynchronousQueue<LiftOff>());
    }

}
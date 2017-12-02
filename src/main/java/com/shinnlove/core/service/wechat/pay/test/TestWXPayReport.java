/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package com.shinnlove.core.service.wechat.pay.test;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author shinnlove.jinsheng
 * @version $Id: TestWXPayReport.java, v 0.1 2017-12-02 下午12:20 shinnlove.jinsheng Exp $$
 */
public class TestWXPayReport {

    public static void testLinkedBlockingQueue() throws Exception{
        LinkedBlockingQueue<String> queue = new LinkedBlockingQueue<String>(2);
        for (int i=0; i<10; ++i) {
            // queue.put("aa");  // 阻塞
            System.out.println( queue.offer("aa") ); // 非阻塞
        }
        System.out.println(queue);
        for (int i=0; i<10; ++i) {
            // System.out.println( queue.remove() );  // 非阻塞，空时抛出异常
            // System.out.println( queue.poll() ); // 非阻塞，空时返回空
            System.out.println( queue.take() ); // 若为空则阻塞
        }
        System.out.println(queue);

    }

    public static void main(String[] args) throws Exception {
        testLinkedBlockingQueue();
    }

}
/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.shinnlove.common.util.jstack;

/**
 * 使用jstack分析线程堆栈。
 *
 * @author shinnlove.jinsheng
 * @version $Id: MyTest.java, v 0.1 2018-05-13 下午10:14 shinnlove.jinsheng Exp $$
 */
public class MyTest {

    Object obj1 = new Object();
    Object obj2 = new Object();

    public void fun1() {
        synchronized (obj1) {
            fun2();
        }
    }

    public void fun2() {
        synchronized (obj2) {
            while (true) {
                System.out.println("hello world");
            }
        }
    }

    public static void main(String[] args) {
        MyTest aa = new MyTest();
        aa.fun1();
    }

}
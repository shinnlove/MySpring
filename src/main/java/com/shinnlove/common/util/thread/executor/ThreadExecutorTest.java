/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package com.shinnlove.common.util.thread.executor;

import java.util.concurrent.*;

/**
 * 测试java线程池。
 *
 * @author shinnlove.jinsheng
 * @version $Id: ThreadExecutorTest.java, v 0.1 2017-11-25 下午5:00 shinnlove.jinsheng Exp $$
 */
public class ThreadExecutorTest {

    private ExecutorService threadTaskExecutor;

    public ThreadExecutorTest() {

        threadTaskExecutor = new ThreadPoolExecutor(5, 5, 0L, TimeUnit.MILLISECONDS,
            new ArrayBlockingQueue<Runnable>(20), Executors.defaultThreadFactory(),
            new RejectedExecutionHandler() {
                @Override
                public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                    System.out.println("discard");
                }
            }) {

            @Override
            public void execute(Runnable task) {
                super.execute(wrapRunnable(task, clientTrace(), Thread.currentThread().getName()));
            }

            @Override
            public Future<?> submit(Runnable task) {
                return super.submit(wrapRunnable(task, clientTrace(), Thread.currentThread()
                    .getName()));
            }

            @Override
            public <T> Future<T> submit(Callable<T> task) {
                return super.submit(wrapCallable(task, clientTrace(), Thread.currentThread()
                    .getName()));
            }

            private Exception clientTrace() {
                return new Exception("Submit Thread Task's Client Stack Trace");
            }

            private Runnable wrapRunnable(final Runnable task, final Exception clientStack,
                                          String clientThreadName) {
                return new Runnable() {
                    @Override
                    public void run() {
                        try {
                            task.run(); // 显式调用run方法
                        } catch (Exception e) {
                            clientStack.printStackTrace();
                            // 特别注意这个地方，jdk至少1.7，1.6是不行的！
                            throw e;
                        }
                    }
                };
            }

            private Callable wrapCallable(final Callable task, final Exception clientStack,
                                          String clientThreadName) {
                return new Callable() {
                    @Override
                    public Object call() throws Exception {
                        try {
                            return task.call(); // 显式调用call方法
                        } catch (Exception e) {
                            clientStack.printStackTrace();
                            throw e;
                        }
                    }
                };
            }

        };

    }

    public static void main(String[] args) {

        ThreadExecutorTest t = new ThreadExecutorTest();

        System.out.println(Thread.currentThread().getId() + "hello");

        Future<String> f = t.getThreadTaskExecutor().submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println(Thread.currentThread().getId() + "我是其他Callable线程");
                //                int a = 0, b = 0;
                //                int c = a / b;
                return "我是异步任务返回的字符串";
            }
        });

        String result = "";
        try {
            result = f.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            // 注意执行错误会从这里抛出
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getId() + result);
        //        t.getThreadTaskExecutor().execute(new Runnable() {
        //            @Override
        //            public void run() {
        //                System.out.println("开启线程");
        //                throw new RuntimeException("线程执行发生错误");
        //            }
        //        });

        // 不shutdown线程池一直不会释放
        t.getThreadTaskExecutor().shutdown();

    }

    /**
     * Getter method for property threadTaskExecutor.
     *
     * @return property value of threadTaskExecutor
     */
    public ExecutorService getThreadTaskExecutor() {
        return threadTaskExecutor;
    }

}
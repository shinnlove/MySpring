/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package com.shinnlove.common.util.thread.executor.task;

/**
 * 使用其他线程开启异步能力的Runnable任务。
 *
 * @author shinnlove.jinsheng
 * @version $Id: AsyncTaskWithoutResult.java, v 0.1 2017-11-25 下午5:07 shinnlove.jinsheng Exp $$
 */
public abstract class AsyncTaskWithoutResult implements Runnable {

    /**
     * @see Runnable#run()
     */
    @Override
    public void run() {
        startAsyncTask();
    }

    /**
     * 离开主线程开启一个异步任务动作。
     */
    public abstract void startAsyncTask();

}
/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package com.shinnlove.common.util.thread.executor.task;

import java.util.concurrent.Callable;

/**
 * 异步有返回结果的多线程能力。
 * 特别注意，这样子写会错误堆栈会逃逸。
 *
 * @author shinnlove.jinsheng
 * @version $Id: AsyncTaskWithResult.java, v 0.1 2017-11-25 下午5:05 shinnlove.jinsheng Exp $$
 */
public abstract class AsyncTaskWithResult<T> implements Callable<T> {

    /**
     * @see Callable#call()
     */
    @Override
    public T call() throws Exception {
        return null;
    }

    /**
     * 提供一种异步有返回结果的多线程能力。
     *
     * @return
     */
    public abstract T doAsyncTask() throws Exception;

}
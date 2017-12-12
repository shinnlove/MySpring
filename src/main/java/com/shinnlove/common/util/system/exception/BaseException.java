/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package com.shinnlove.common.util.system.exception;

/**
 * 基础错误信息。
 *
 * @author shinnlove.jinsheng
 * @version $Id: BaseException.java, v 0.1 2017-12-10 下午4:10 shinnlove.jinsheng Exp $$
 */
public interface BaseException {

    /**
     * 获取异常信息
     *
     * @return
     */
    Exception getException();

    /**
     * 获取自定义错误码的String类型code
     *
     * @return
     */
    String getResultCodeStr();

    /**
     * 获取异常场景信息，若没有异常场景直接返回空字符串
     *
     * <P>返回场景集合Map的string格式
     *
     * @return
     */
    String getScene();

    /**
     * 添加异常场景信息，以错误码=>错误信息的K/V值塞入Map
     *
     * @param key
     * @param value
     */
    void addScene(String key, String value);

}

/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package com.shinnlove.common.util.system.exception;

import java.util.HashMap;
import java.util.Map;

import com.shinnlove.common.util.system.code.SystemResultCode;

/**
 * 本系统基础类错误，建议extends之后再做具体的错误。
 *
 * @author shinnlove.jinsheng
 * @version $Id: SystemException.java, v 0.1 2017-12-10 下午4:11 shinnlove.jinsheng Exp $$
 */
public class SystemException extends RuntimeException implements BaseException {

    /** 系统异常错误码 */
    private final SystemResultCode    resultCode;

    /** 异常场景信息：错误码=>错误信息 */
    private final Map<String, String> sceneMap = new HashMap<String, String>();

    /**
     * 带参数的构造函数。
     *
     * @param resultCode
     */
    public SystemException(SystemResultCode resultCode) {
        super(resultCode.getCode() + ":" + resultCode.getMessage());
        this.resultCode = resultCode;
    }

    /**
     * 构造函数
     * @param resultCode
     * @param message
     */
    public SystemException(SystemResultCode resultCode, String message) {
        super(resultCode.getCode() + ":" + message);
        this.resultCode = resultCode;
    }

    /**
     * 构造函数
     *
     * @param message
     */
    public SystemException(String message) {
        super(message);
        this.resultCode = SystemResultCode.SYSTEM_ERROR;
    }

    /**
     * 构造函数
     *
     * @param message
     * @param throwable
     */
    public SystemException(String message, Throwable throwable) {
        super(message, throwable);
        this.resultCode = SystemResultCode.SYSTEM_ERROR;
    }

    /**
     * 构造函数
     *
     * @param resultCode
     * @param throwable
     */
    public SystemException(SystemResultCode resultCode, Throwable throwable) {
        super(throwable);
        this.resultCode = resultCode;
    }

    /**
     * Getter method for property resultCode.
     *
     * @return property value of resultCode
     */
    public SystemResultCode getResultCode() {
        return resultCode;
    }

    /**
     * 错误代码
     *
     * @return
     */
    public String getCode() {
        return null == resultCode ? "" : resultCode.getCode();
    }

    /**
     * 错误描述
     *
     * @return
     */
    public String getDescription() {
        return null == resultCode ? "未知错误" : resultCode.getMessage();
    }

    /**
     * @see BaseException#getException()
     */
    @Override
    public Exception getException() {
        return this;
    }

    /**
     * @see BaseException#getResultCodeStr()
     */
    @Override
    public String getResultCodeStr() {
        return null == resultCode ? "" : resultCode.getCode();
    }

    /**
     * @see BaseException#getScene()
     */
    @Override
    public String getScene() {
        return sceneMap.isEmpty() ? "" : sceneMap.toString();
    }

    /**
     * @see BaseException#addScene(String, String)
     */
    @Override
    public void addScene(String key, String value) {
        sceneMap.put(key, value);
    }

}
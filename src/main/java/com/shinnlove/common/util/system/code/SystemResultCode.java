/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package com.shinnlove.common.util.system.code;

import com.shinnlove.common.util.system.enums.BaseEnum;

/**
 * 系统内部返回码。
 *
 * @author shinnlove.jinsheng
 * @version $Id: SystemResultCode.java, v 0.1 2017-12-10 下午4:07 shinnlove.jinsheng Exp $$
 */
public enum SystemResultCode implements BaseEnum {

    /** ---------------------- 公用类:0×× ---------------------- */

    /** 成功 */
    SUCCESS("0", "成功"),

    /** 系统异常 */
    SYSTEM_ERROR("-1", "系统异常"),

    ;

    /**
     * 枚举带参数的构造函数。
     * @param code
     * @param message
     */
    SystemResultCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    /** 枚举码 */
    private String code;
    /** 枚举对应的消息 */
    private String message;

    /**
     * @see com.shinnlove.common.util.system.enums.BaseEnum#getCode()
     */
    @Override
    public String getCode() {
        return code;
    }

    /**
     * @see com.shinnlove.common.util.system.enums.BaseEnum#getMessage()
     */
    @Override
    public String getMessage() {
        return message;
    }

    /**
     * 通过code获取枚举，备注：equals方法可以先trim一下的。
     *
     * @param code 代码
     * @return 枚举
     */
    public static SystemResultCode getEnumByCode(String code) {
        for (SystemResultCode entry : SystemResultCode.values()) {
            if (entry.getCode().equals(code)) {
                return entry;
            }
        }
        return null;
    }

}
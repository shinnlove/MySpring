/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package com.shinnlove.common.util.system.enums;

/**
 * 枚举接口，通用枚举继承自这个接口进行构造。
 *
 * @author shinnlove.jinsheng
 * @version $Id: BaseEnum.java, v 0.1 2017-12-10 下午4:06 shinnlove.jinsheng Exp $$
 */
public interface BaseEnum {

    /**
     * <p>获取枚举编码</p>
     * @return
     */
    String getCode();

    /**
     * <p>获取枚举消息</p>
     * @return
     */
    String getMessage();

}

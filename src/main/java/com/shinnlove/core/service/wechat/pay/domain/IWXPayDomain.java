/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package com.shinnlove.core.service.wechat.pay.domain;

import com.shinnlove.core.service.wechat.pay.config.WXPayConfig;
import com.shinnlove.core.service.wechat.pay.domain.model.DomainInfo;

/**
 * 域名管理，实现主备域名自动切换
 *
 * @author shinnlove.jinsheng
 * @version $Id: IWXPayDomain.java, v 0.1 2017-12-02 上午11:12 shinnlove.jinsheng Exp $$
 */
public interface IWXPayDomain {

    /**
     * 上报域名网络状况
     * @param domain 域名。 比如：api.mch.weixin.qq.com
     * @param elapsedTimeMillis 耗时
     * @param ex 网络请求中出现的异常。
     *           null表示没有异常
     *           ConnectTimeoutException，表示建立网络连接异常
     *           UnknownHostException， 表示dns解析异常
     */
    void report(final String domain, long elapsedTimeMillis, final Exception ex);

    /**
     * 获取域名
     * @param config 配置
     * @return 域名
     */
    DomainInfo getDomain(final WXPayConfig config);

}
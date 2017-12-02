/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package com.shinnlove.core.service.wechat.pay.domain.model;

/**
 * @author shinnlove.jinsheng
 * @version $Id: DomainInfo.java, v 0.1 2017-12-02 上午11:18 shinnlove.jinsheng Exp $$
 */
public class DomainInfo {

    public String domain;       //域名
    public boolean primaryDomain;     //该域名是否为主域名。例如:api.mch.weixin.qq.com为主域名
    public DomainInfo(String domain, boolean primaryDomain) {
        this.domain = domain;
        this.primaryDomain = primaryDomain;
    }

    @Override
    public String toString() {
        return "DomainInfo{" +
                "domain='" + domain + '\'' +
                ", primaryDomain=" + primaryDomain +
                '}';
    }

}
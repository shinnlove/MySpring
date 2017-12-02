/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package com.shinnlove.core.service.wechat.pay.config.impl;

import com.shinnlove.core.service.wechat.pay.config.WXPayConfig;
import com.shinnlove.core.service.wechat.pay.domain.IWXPayDomain;
import com.shinnlove.core.service.wechat.pay.domain.impl.WXPayDomainSimpleImpl;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * @author shinnlove.jinsheng
 * @version $Id: WXPayConfigImpl.java, v 0.1 2017-12-02 上午11:15 shinnlove.jinsheng Exp $$
 */
public class WXPayConfigImpl extends WXPayConfig {

    private byte[] certData;
    private static WXPayConfigImpl INSTANCE;

    private WXPayConfigImpl() throws Exception{
        String certPath = "/Users/zhaochensheng/Downloads/apiclient_cert.p12";
        File file = new File(certPath);
        InputStream certStream = new FileInputStream(file);
        this.certData = new byte[(int) file.length()];
        certStream.read(this.certData);
        certStream.close();
    }

    public static WXPayConfigImpl getInstance() throws Exception{
        if (INSTANCE == null) {
            synchronized (WXPayConfigImpl.class) {
                if (INSTANCE == null) {
                    INSTANCE = new WXPayConfigImpl();
                }
            }
        }
        return INSTANCE;
    }

    public String getAppID() {
        return "wxdb3bb7c95c0d5932";
    }

    public String getMchID() {
        return "10029370";
    }

    /**
     * 4*8=32位密钥，weactpay正好8位，就重复4次
     * @return
     */
    public String getKey() {
        return "weactpayweactpayweactpayweactpay";
    }

    public InputStream getCertStream() {
        ByteArrayInputStream certBis;
        certBis = new ByteArrayInputStream(this.certData);
        return certBis;
    }


    public int getHttpConnectTimeoutMs() {
        return 2000;
    }

    public int getHttpReadTimeoutMs() {
        return 10000;
    }

    public IWXPayDomain getWXPayDomain() {
        return WXPayDomainSimpleImpl.instance();
    }

    public String getPrimaryDomain() {
        return "api.mch.weixin.qq.com";
    }

    public String getAlternateDomain() {
        return "api2.mch.weixin.qq.com";
    }

    @Override
    public int getReportWorkerNum() {
        return 1;
    }

    @Override
    public int getReportBatchSize() {
        return 2;
    }

}
/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.shinnlove.common.util.zookeeper;

import java.io.IOException;

import org.I0Itec.zkclient.ZkClient;

/**
 * ZkClient客户端与session。
 *
 * @author shinnlove.jinsheng
 * @version $Id: ZkClientSession.java, v 0.1 2018-05-04 下午11:40 shinnlove.jinsheng Exp $$
 */
public class ZkClientSession {

    public static void main(String[] args) throws IOException, InterruptedException {
        ZkClient zkClient = new ZkClient("www.shinnlove.com:2181", 5000);
        System.out.println("Zookeeper session established.");
    }

}
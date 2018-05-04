/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.shinnlove.common.util.zookeeper;

import java.util.concurrent.CountDownLatch;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

/**
 * Zookeeper原生客户端。
 *
 * @author shinnlove.jinsheng
 * @version $Id: ZookeeperConstructor.java, v 0.1 2018-05-04 下午10:44 shinnlove.jinsheng Exp $$
 */
public class ZookeeperConstructor implements Watcher {

    private static CountDownLatch connectedSemaphore = new CountDownLatch(1);

    @Override
    public void process(WatchedEvent event) {
        System.out.println("Receive watched event:" + event);
        if (Event.KeeperState.SyncConnected == event.getState()) {
            connectedSemaphore.countDown();
        }
    }

    public static void main(String[] args) throws Exception {
        ZooKeeper zooKeeper = new ZooKeeper("www.shinnlove.com:2181", 5000,
            new ZookeeperConstructor());
        System.out.println(zooKeeper.getState());
        try {
            connectedSemaphore.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Zookeeper session established.");
    }

}
/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package com.shinnlove.core.service.activemq.message.driven;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;

import com.shinnlove.common.model.msg.UnionMessage;
import com.shinnlove.common.util.log.LoggerUtil;

/**
 * 消息驱动的接收者。
 *
 * @author shinnlove.jinsheng
 * @version $Id: MessageDrivenReceiver.java, v 0.1 2017-12-24 上午10:29 shinnlove.jinsheng Exp $$
 */
public class MessageDrivenReceiver {

    /** 日志 */
    private static Logger logger = LoggerFactory.getLogger(MessageDrivenReceiver.class);

    @Autowired
    private JmsTemplate   jmsTemplate;

    /**
     * 统一消息处理驱动，等待JMS自己回调。
     *
     * @param unionMessage
     */
    public void handleMessage(UnionMessage unionMessage) {
        System.out.println("MessageDrivenReceiver被消息驱动处理消息！");
        System.out.println(unionMessage);
        LoggerUtil.info(logger, "接收到一条消息，消息的主题是", unionMessage.getTopic(), "，消息的事件是",
            unionMessage.getEvent(), "，消息内容打印如下：unionMessage=", unionMessage);
    }

}
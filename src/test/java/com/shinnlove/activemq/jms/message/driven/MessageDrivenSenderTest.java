/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package com.shinnlove.activemq.jms.message.driven;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.shinnlove.common.model.msg.UnionMessage;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

/**
 * JMS消息驱动的消息发送者，接收者不会阻塞等待消息，而是等待消息自驱。
 * {@link com.shinnlove.core.service.activemq.message.driven.MessageDrivenReceiver}
 *
 * @author shinnlove.jinsheng
 * @version $Id: MessageDrivenSenderTest.java, v 0.1 2017-12-24 上午10:31 shinnlove.jinsheng Exp $$
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/META-INF/spring/*.xml")
public class MessageDrivenSenderTest {

    @Autowired
    private JmsTemplate jmsTemplate;

    @Test
    public void test_message_driven_send() {
        jmsTemplate.send("spitter.alert.queue", new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                return session.createObjectMessage(new UnionMessage("消息驱动事件", "发送一条消息请求响应"));
            }
        });

        // 主线程不退出，让spring容器通知消息处理
        //        try {
        //            Thread.sleep(10000);
        //        } catch (InterruptedException e) {
        //            e.printStackTrace();
        //        }
    }

}
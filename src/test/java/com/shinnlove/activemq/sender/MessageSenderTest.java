/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package com.shinnlove.activemq.sender;

import org.apache.activemq.command.ActiveMQQueue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.jms.*;

/**
 * 测试发送消息。
 *
 * @author shinnlove.jinsheng
 * @version $Id: MessageSenderTest.java, v 0.1 2017-12-23 下午1:35 shinnlove.jinsheng Exp $$
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/META-INF/spring/*.xml")
public class MessageSenderTest {

    @Autowired
    private ConnectionFactory connectionFactory;

    @Autowired
    private ActiveMQQueue spittleQueue;

    @Test
    public void test_send_message() {
        Connection conn = null;
        Session session = null;
        try {
            conn = connectionFactory.createConnection();
            session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
            Destination destination = spittleQueue;
            MessageProducer producer = session.createProducer(destination);
            // 循环投递消息
            for (int i = 0; i < 1000; i++) {
                try {
                    TextMessage message = session.createTextMessage();
                    message.setText("亲爱的，新年快乐;睡觉啦，晚安第" + i + "次。");
                    producer.send(message);
                } catch (Exception e) {
                    System.out.println("本条index=" + i + "消息发送失败");
                }
            }
        } catch (JMSException e) {
            e.printStackTrace();
        } finally {
            try {
                if (session != null) {
                    session.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (JMSException ex) {
                ex.printStackTrace();
            }
        }
    }

}
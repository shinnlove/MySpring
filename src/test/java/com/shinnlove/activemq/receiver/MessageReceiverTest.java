/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package com.shinnlove.activemq.receiver;

import org.apache.activemq.command.ActiveMQQueue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.jms.*;

/**
 * 测试接收消息。
 *
 * @author shinnlove.jinsheng
 * @version $Id: MessageReceiverTest.java, v 0.1 2017-12-23 下午2:13 shinnlove.jinsheng Exp $$
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/META-INF/spring/*.xml")
public class MessageReceiverTest {

    @Autowired
    private ConnectionFactory connectionFactory;

    @Autowired
    private ActiveMQQueue     spittleQueue;

    @Test
    public void test_receive_message() {
        Connection conn = null;
        Session session = null;
        try {
            conn = connectionFactory.createConnection();
            conn.start();
            session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
            Destination destination = spittleQueue;
            MessageConsumer consumer = session.createConsumer(destination);
            Message message = consumer.receive();
            TextMessage textMessage = (TextMessage) message;
            System.out.println("GOT A MESSAGE：" + textMessage.getText());
            //            conn.start();
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
/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package com.shinnlove.activemq.jms.template;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.shinnlove.common.model.Student;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

/**
 * 测试发送消息。
 *
 * @author shinnlove.jinsheng
 * @version $Id: JMSTemplateSenderTest.java, v 0.1 2017-12-23 下午3:41 shinnlove.jinsheng Exp $$
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/META-INF/spring/*.xml")
public class JMSTemplateSenderTest {

    @Autowired
    private JmsTemplate jmsTemplate;

    @Test
    public void test_send_template_message() {
        jmsTemplate.send("spittle.alert.queue", new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                return session.createObjectMessage(new Student("倩倩", 20));
            }
        });
    }

}
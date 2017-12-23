/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package com.shinnlove.activemq.jms.template;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.shinnlove.common.model.Student;

import javax.jms.JMSException;
import javax.jms.ObjectMessage;

/**
 * 使用JMSTemplate接收消息。
 *
 * @author shinnlove.jinsheng
 * @version $Id: JMSTemplateReceiverTest.java, v 0.1 2017-12-23 下午4:09 shinnlove.jinsheng Exp $$
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/META-INF/spring/*.xml")
public class JMSTemplateReceiverTest {

    @Autowired
    private JmsTemplate jmsTemplate;

    @Test
    public void test_receive_template_message() {
        try {
            ObjectMessage receivedMessage = (ObjectMessage) jmsTemplate.receive();
            Student s = (Student) receivedMessage.getObject();
            System.out.println(s);
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

}
/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package com.shinnlove.common.model.msg;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 统一消息对象。
 *
 * @author shinnlove.jinsheng
 * @version $Id: UnionMessage.java, v 0.1 2017-12-24 上午10:40 shinnlove.jinsheng Exp $$
 */
public class UnionMessage implements Serializable {

    /** uuid */
    private static final long serialVersionUID = -8216807444509393672L;

    /** 消息主题 */
    private String            topic;
    /** 消息事件 */
    private String            event;

    /** 消息id */
    private String            msgId;
    /** 消息负载内容 */
    private Object            payload;

    public UnionMessage(String topic, String event) {
        this.topic = topic;
        this.event = event;
    }

    /**
     * Getter method for property topic.
     *
     * @return property value of topic
     */
    public String getTopic() {
        return topic;
    }

    /**
     * Setter method for property topic.
     *
     * @param topic value to be assigned to property topic
     */
    public void setTopic(String topic) {
        this.topic = topic;
    }

    /**
     * Getter method for property event.
     *
     * @return property value of event
     */
    public String getEvent() {
        return event;
    }

    /**
     * Setter method for property event.
     *
     * @param event value to be assigned to property event
     */
    public void setEvent(String event) {
        this.event = event;
    }

    /**
     * Getter method for property msgId.
     *
     * @return property value of msgId
     */
    public String getMsgId() {
        return msgId;
    }

    /**
     * Setter method for property msgId.
     *
     * @param msgId value to be assigned to property msgId
     */
    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }

    /**
     * Getter method for property payload.
     *
     * @return property value of payload
     */
    public Object getPayload() {
        return payload;
    }

    /**
     * Setter method for property payload.
     *
     * @param payload value to be assigned to property payload
     */
    public void setPayload(Object payload) {
        this.payload = payload;
    }

    /**
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

}
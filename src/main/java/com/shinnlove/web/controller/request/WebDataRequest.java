/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package com.shinnlove.web.controller.request;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * @author shinnlove.jinsheng
 * @version $Id: WebDataRequest.java, v 0.1 2017-12-02 下午10:05 shinnlove.jinsheng Exp $$
 */
public class WebDataRequest {

    private int pageNo;

    private int pageSize;

    private String title;

    private String publisher;

    private String publishInst;

    private String content;

    private String startTime;

    private String endTime;

    private String spiderName;

    public String getSpiderName() {
        return spiderName.trim();
    }

    public void setSpiderName(String spiderName) {
        this.spiderName = spiderName;
    }

    /**
     * Getter method for property pageNo.
     *
     * @return property value of pageNo
     */
    public int getPageNo() {
        return pageNo;
    }

    /**
     * Setter method for property pageNo.
     *
     * @param pageNo value to be assigned to property pageNo
     */
    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    /**
     * Getter method for property pageSize.
     *
     * @return property value of pageSize
     */
    public int getPageSize() {
        return pageSize;
    }

    /**
     * Setter method for property pageSize.
     *
     * @param pageSize value to be assigned to property pageSize
     */
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    /**
     * Getter method for property title.
     *
     * @return property value of title
     */
    public String getTitle() {
        return title.trim();
    }

    /**
     * Setter method for property title.
     *
     * @param title value to be assigned to property title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Getter method for property publisher.
     *
     * @return property value of publisher
     */
    public String getPublisher() {
        return publisher.trim();
    }

    /**
     * Setter method for property publisher.
     *
     * @param publisher value to be assigned to property publisher
     */
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    /**
     * Getter method for property publishInst.
     *
     * @return property value of publishInst
     */
    public String getPublishInst() {
        return publishInst.trim();
    }

    /**
     * Setter method for property publishInst.
     *
     * @param publishInst value to be assigned to property publishInst
     */
    public void setPublishInst(String publishInst) {
        this.publishInst = publishInst;
    }

    /**
     * Getter method for property content.
     *
     * @return property value of content
     */
    public String getContent() {
        return content.trim();
    }

    /**
     * Setter method for property content.
     *
     * @param content value to be assigned to property content
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * Getter method for property startTime.
     *
     * @return property value of startTime
     */
    public String getStartTime() {
        return startTime;
    }

    /**
     * Setter method for property startTime.
     *
     * @param startTime value to be assigned to property startTime
     */
    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    /**
     * Getter method for property endTime.
     *
     * @return property value of endTime
     */
    public String getEndTime() {
        return endTime;
    }

    /**
     * Setter method for property endTime.
     *
     * @param endTime value to be assigned to property endTime
     */
    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    /**
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

}
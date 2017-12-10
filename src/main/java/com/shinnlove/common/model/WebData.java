/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package com.shinnlove.common.model;

import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.hibernate.annotations.NamedQuery;

import javax.persistence.Entity;

/**
 * webData对象。
 *
 * @author shinnlove.jinsheng
 * @version $Id: WebData.java, v 0.1 2017-12-02 下午12:42 shinnlove.jinsheng Exp $$
 */
@Entity
@NamedQuery(name = "myNamedQuery", query = "from WebData as w where w.title = ?")
public class WebData {

    private int    id;

    private String url;

    private String title;    //

    private String content; //

    private Date   pubtime;   //

    private Date   collecttime;

    private String spidername;

    private String machine;

    private String channel;

    private String author;    //

    private String medianame;  //

    private String source;    //

    private String area;     //

    private String replys;   //

    private String viewcount; //

    private String cContent;

    /**
     * 默认构造器。
     */
    public WebData() {
    }

    /**
     * 构造器。
     *
     * @param url
     * @param title
     * @param content
     * @param pubtime
     * @param collecttime
     * @param spidername
     * @param machine
     * @param channel
     * @param author
     * @param medianame
     * @param source
     * @param area
     * @param replys
     * @param viewcount
     * @param cContent
     */
    public WebData(String url, String title, String content, Date pubtime, Date collecttime,
                   String spidername, String machine, String channel, String author,
                   String medianame, String source, String area, String replys, String viewcount,
                   String cContent) {
        this.url = url;
        this.title = title;
        this.content = content;
        this.pubtime = pubtime;
        this.collecttime = collecttime;
        this.spidername = spidername;
        this.machine = machine;
        this.channel = channel;
        this.author = author;
        this.medianame = medianame;
        this.source = source;
        this.area = area;
        this.replys = replys;
        this.viewcount = viewcount;
        this.cContent = cContent;
    }

    /**
     * Getter method for property id.
     *
     * @return property value of id
     */
    public int getId() {
        return id;
    }

    /**
     * Setter method for property id.
     *
     * @param id value to be assigned to property id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Getter method for property url.
     *
     * @return property value of url
     */
    public String getUrl() {
        return url;
    }

    /**
     * Setter method for property url.
     *
     * @param url value to be assigned to property url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * Getter method for property title.
     *
     * @return property value of title
     */
    public String getTitle() {
        return title;
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
     * Getter method for property content.
     *
     * @return property value of content
     */
    public String getContent() {
        return content;
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
     * Getter method for property pubtime.
     *
     * @return property value of pubtime
     */
    public Date getPubtime() {
        return pubtime;
    }

    /**
     * Setter method for property pubtime.
     *
     * @param pubtime value to be assigned to property pubtime
     */
    public void setPubtime(Date pubtime) {
        this.pubtime = pubtime;
    }

    /**
     * Getter method for property collecttime.
     *
     * @return property value of collecttime
     */
    public Date getCollecttime() {
        return collecttime;
    }

    /**
     * Setter method for property collecttime.
     *
     * @param collecttime value to be assigned to property collecttime
     */
    public void setCollecttime(Date collecttime) {
        this.collecttime = collecttime;
    }

    /**
     * Getter method for property spidername.
     *
     * @return property value of spidername
     */
    public String getSpidername() {
        return spidername;
    }

    /**
     * Setter method for property spidername.
     *
     * @param spidername value to be assigned to property spidername
     */
    public void setSpidername(String spidername) {
        this.spidername = spidername;
    }

    /**
     * Getter method for property machine.
     *
     * @return property value of machine
     */
    public String getMachine() {
        return machine;
    }

    /**
     * Setter method for property machine.
     *
     * @param machine value to be assigned to property machine
     */
    public void setMachine(String machine) {
        this.machine = machine;
    }

    /**
     * Getter method for property channel.
     *
     * @return property value of channel
     */
    public String getChannel() {
        return channel;
    }

    /**
     * Setter method for property channel.
     *
     * @param channel value to be assigned to property channel
     */
    public void setChannel(String channel) {
        this.channel = channel;
    }

    /**
     * Getter method for property author.
     *
     * @return property value of author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Setter method for property author.
     *
     * @param author value to be assigned to property author
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * Getter method for property medianame.
     *
     * @return property value of medianame
     */
    public String getMedianame() {
        return medianame;
    }

    /**
     * Setter method for property medianame.
     *
     * @param medianame value to be assigned to property medianame
     */
    public void setMedianame(String medianame) {
        this.medianame = medianame;
    }

    /**
     * Getter method for property source.
     *
     * @return property value of source
     */
    public String getSource() {
        return source;
    }

    /**
     * Setter method for property source.
     *
     * @param source value to be assigned to property source
     */
    public void setSource(String source) {
        this.source = source;
    }

    /**
     * Getter method for property area.
     *
     * @return property value of area
     */
    public String getArea() {
        return area;
    }

    /**
     * Setter method for property area.
     *
     * @param area value to be assigned to property area
     */
    public void setArea(String area) {
        this.area = area;
    }

    /**
     * Getter method for property replys.
     *
     * @return property value of replys
     */
    public String getReplys() {
        return replys;
    }

    /**
     * Setter method for property replys.
     *
     * @param replys value to be assigned to property replys
     */
    public void setReplys(String replys) {
        this.replys = replys;
    }

    /**
     * Getter method for property viewcount.
     *
     * @return property value of viewcount
     */
    public String getViewcount() {
        return viewcount;
    }

    /**
     * Setter method for property viewcount.
     *
     * @param viewcount value to be assigned to property viewcount
     */
    public void setViewcount(String viewcount) {
        this.viewcount = viewcount;
    }

    /**
     * Getter method for property cContent.
     *
     * @return property value of cContent
     */
    public String getcContent() {
        return cContent;
    }

    /**
     * Setter method for property cContent.
     *
     * @param cContent value to be assigned to property cContent
     */
    public void setcContent(String cContent) {
        this.cContent = cContent;
    }

    /**
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

}
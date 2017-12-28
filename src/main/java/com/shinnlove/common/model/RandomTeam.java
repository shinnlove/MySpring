/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package com.shinnlove.common.model;

import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.Entity;

/**
 * 随机Team。
 *
 * @author shinnlove.jinsheng
 * @version $Id: RandomTeam.java, v 0.1 2017-12-27 下午10:57 shinnlove.jinsheng Exp $$
 */
@Entity
public class RandomTeam {

    /** 主键 */
    private long   id;
    /** 创建时间 */
    private Date   gmtCreate;
    /** 修改时间 */
    private Date   gmtModified;
    /** 员工编号 */
    private String empId;
    /** 员工花名 */
    private String empName;
    /** 组编号 */
    private int    teamId;
    /** 组名 */
    private String teamName;
    /** 员工账号 */
    private String domainAccount;
    /** 供写入的备注 */
    private String memo;

    /**
     * Getter method for property id.
     *
     * @return property value of id
     */
    public long getId() {
        return id;
    }

    /**
     * Setter method for property id.
     *
     * @param id value to be assigned to property id
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Getter method for property gmtCreate.
     *
     * @return property value of gmtCreate
     */
    public Date getGmtCreate() {
        return gmtCreate;
    }

    /**
     * Setter method for property gmtCreate.
     *
     * @param gmtCreate value to be assigned to property gmtCreate
     */
    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    /**
     * Getter method for property gmtModified.
     *
     * @return property value of gmtModified
     */
    public Date getGmtModified() {
        return gmtModified;
    }

    /**
     * Setter method for property gmtModified.
     *
     * @param gmtModified value to be assigned to property gmtModified
     */
    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    /**
     * Getter method for property empId.
     *
     * @return property value of empId
     */
    public String getEmpId() {
        return empId;
    }

    /**
     * Setter method for property empId.
     *
     * @param empId value to be assigned to property empId
     */
    public void setEmpId(String empId) {
        this.empId = empId;
    }

    /**
     * Getter method for property empName.
     *
     * @return property value of empName
     */
    public String getEmpName() {
        return empName;
    }

    /**
     * Setter method for property empName.
     *
     * @param empName value to be assigned to property empName
     */
    public void setEmpName(String empName) {
        this.empName = empName;
    }

    /**
     * Getter method for property teamId.
     *
     * @return property value of teamId
     */
    public int getTeamId() {
        return teamId;
    }

    /**
     * Setter method for property teamId.
     *
     * @param teamId value to be assigned to property teamId
     */
    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    /**
     * Getter method for property teamName.
     *
     * @return property value of teamName
     */
    public String getTeamName() {
        return teamName;
    }

    /**
     * Setter method for property teamName.
     *
     * @param teamName value to be assigned to property teamName
     */
    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    /**
     * Getter method for property domainAccount.
     *
     * @return property value of domainAccount
     */
    public String getDomainAccount() {
        return domainAccount;
    }

    /**
     * Setter method for property domainAccount.
     *
     * @param domainAccount value to be assigned to property domainAccount
     */
    public void setDomainAccount(String domainAccount) {
        this.domainAccount = domainAccount;
    }

    /**
     * Getter method for property memo.
     *
     * @return property value of memo
     */
    public String getMemo() {
        return memo;
    }

    /**
     * Setter method for property memo.
     *
     * @param memo value to be assigned to property memo
     */
    public void setMemo(String memo) {
        this.memo = memo;
    }

    /**
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

}
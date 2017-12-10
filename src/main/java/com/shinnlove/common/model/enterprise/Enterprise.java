/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package com.shinnlove.common.model.enterprise;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.Entity;
import java.sql.Timestamp;

/**
 * 企业实体
 *
 * @author shinnlove.jinsheng
 * @version $Id: Enterprise.java, v 0.1 2017-12-10 上午11:54 shinnlove.jinsheng Exp $$
 */
@Entity
public class Enterprise {

    private String eId;
    private String account;
    private String password;
    private Integer serviceVersion;
    private String contactNumber;
    private Timestamp serviceStartTime;
    private Timestamp serviceEndTime;
    private byte[] dimensionCode;
    private Integer addTime;
    private String remark;
    private Integer isDel;

    /**
     * Getter method for property eId.
     *
     * @return property value of eId
     */
    public String geteId() {
        return eId;
    }

    /**
     * Setter method for property eId.
     *
     * @param eId value to be assigned to property eId
     */
    public void seteId(String eId) {
        this.eId = eId;
    }

    /**
     * Getter method for property account.
     *
     * @return property value of account
     */
    public String getAccount() {
        return account;
    }

    /**
     * Setter method for property account.
     *
     * @param account value to be assigned to property account
     */
    public void setAccount(String account) {
        this.account = account;
    }

    /**
     * Getter method for property password.
     *
     * @return property value of password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Setter method for property password.
     *
     * @param password value to be assigned to property password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Getter method for property serviceVersion.
     *
     * @return property value of serviceVersion
     */
    public Integer getServiceVersion() {
        return serviceVersion;
    }

    /**
     * Setter method for property serviceVersion.
     *
     * @param serviceVersion value to be assigned to property serviceVersion
     */
    public void setServiceVersion(Integer serviceVersion) {
        this.serviceVersion = serviceVersion;
    }

    /**
     * Getter method for property contactNumber.
     *
     * @return property value of contactNumber
     */
    public String getContactNumber() {
        return contactNumber;
    }

    /**
     * Setter method for property contactNumber.
     *
     * @param contactNumber value to be assigned to property contactNumber
     */
    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    /**
     * Getter method for property serviceStartTime.
     *
     * @return property value of serviceStartTime
     */
    public Timestamp getServiceStartTime() {
        return serviceStartTime;
    }

    /**
     * Setter method for property serviceStartTime.
     *
     * @param serviceStartTime value to be assigned to property serviceStartTime
     */
    public void setServiceStartTime(Timestamp serviceStartTime) {
        this.serviceStartTime = serviceStartTime;
    }

    /**
     * Getter method for property serviceEndTime.
     *
     * @return property value of serviceEndTime
     */
    public Timestamp getServiceEndTime() {
        return serviceEndTime;
    }

    /**
     * Setter method for property serviceEndTime.
     *
     * @param serviceEndTime value to be assigned to property serviceEndTime
     */
    public void setServiceEndTime(Timestamp serviceEndTime) {
        this.serviceEndTime = serviceEndTime;
    }

    /**
     * Getter method for property dimensionCode.
     *
     * @return property value of dimensionCode
     */
    public byte[] getDimensionCode() {
        return dimensionCode;
    }

    /**
     * Setter method for property dimensionCode.
     *
     * @param dimensionCode value to be assigned to property dimensionCode
     */
    public void setDimensionCode(byte[] dimensionCode) {
        this.dimensionCode = dimensionCode;
    }

    /**
     * Getter method for property addTime.
     *
     * @return property value of addTime
     */
    public Integer getAddTime() {
        return addTime;
    }

    /**
     * Setter method for property addTime.
     *
     * @param addTime value to be assigned to property addTime
     */
    public void setAddTime(Integer addTime) {
        this.addTime = addTime;
    }

    /**
     * Getter method for property remark.
     *
     * @return property value of remark
     */
    public String getRemark() {
        return remark;
    }

    /**
     * Setter method for property remark.
     *
     * @param remark value to be assigned to property remark
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * Getter method for property isDel.
     *
     * @return property value of isDel
     */
    public Integer getIsDel() {
        return isDel;
    }

    /**
     * Setter method for property isDel.
     *
     * @param isDel value to be assigned to property isDel
     */
    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }

    /**
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

}
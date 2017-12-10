/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package com.shinnlove.common.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Arrays;

/**
 * @author shinnlove.jinsheng
 * @version $Id: TEnterprise.java, v 0.1 2017-12-10 上午11:51 shinnlove.jinsheng Exp $$
 */
@Entity
@Table(name = "t_enterprise", schema = "weact", catalog = "")
public class TEnterprise {
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
    @Id
    @Column(name = "e_id", nullable = false, length = 32)
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
    @Basic
    @Column(name = "account", nullable = false, length = 50)
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
    @Basic
    @Column(name = "password", nullable = false, length = 50)
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
    @Basic
    @Column(name = "service_version", nullable = true)
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
    @Basic
    @Column(name = "contact_number", nullable = true, length = 20)
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
    @Basic
    @Column(name = "service_start_time", nullable = true)
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
    @Basic
    @Column(name = "service_end_time", nullable = true)
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
    @Basic
    @Column(name = "dimension_code", nullable = true)
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
    @Basic
    @Column(name = "add_time", nullable = true)
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
    @Basic
    @Column(name = "remark", nullable = true, length = 300)
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
    @Basic
    @Column(name = "is_del", nullable = true)
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TEnterprise that = (TEnterprise) o;

        if (eId != null ? !eId.equals(that.eId) : that.eId != null) return false;
        if (account != null ? !account.equals(that.account) : that.account != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        if (serviceVersion != null ? !serviceVersion.equals(that.serviceVersion) : that.serviceVersion != null)
            return false;
        if (contactNumber != null ? !contactNumber.equals(that.contactNumber) : that.contactNumber != null)
            return false;
        if (serviceStartTime != null ? !serviceStartTime.equals(that.serviceStartTime) : that.serviceStartTime != null)
            return false;
        if (serviceEndTime != null ? !serviceEndTime.equals(that.serviceEndTime) : that.serviceEndTime != null)
            return false;
        if (!Arrays.equals(dimensionCode, that.dimensionCode)) return false;
        if (addTime != null ? !addTime.equals(that.addTime) : that.addTime != null) return false;
        if (remark != null ? !remark.equals(that.remark) : that.remark != null) return false;
        if (isDel != null ? !isDel.equals(that.isDel) : that.isDel != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = eId != null ? eId.hashCode() : 0;
        result = 31 * result + (account != null ? account.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (serviceVersion != null ? serviceVersion.hashCode() : 0);
        result = 31 * result + (contactNumber != null ? contactNumber.hashCode() : 0);
        result = 31 * result + (serviceStartTime != null ? serviceStartTime.hashCode() : 0);
        result = 31 * result + (serviceEndTime != null ? serviceEndTime.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(dimensionCode);
        result = 31 * result + (addTime != null ? addTime.hashCode() : 0);
        result = 31 * result + (remark != null ? remark.hashCode() : 0);
        result = 31 * result + (isDel != null ? isDel.hashCode() : 0);
        return result;
    }
}
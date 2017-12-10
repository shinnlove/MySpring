/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package com.shinnlove.common.model;

import javax.persistence.*;
import java.sql.Date;

/**
 * @author shinnlove.jinsheng
 * @version $Id: TCustomerinfo.java, v 0.1 2017-12-10 上午11:51 shinnlove.jinsheng Exp $$
 */
@Entity
@Table(name = "t_customerinfo", schema = "weact", catalog = "")
public class TCustomerinfo {
    private String customerId;
    private String openid;
    private String customerName;
    private String nickName;
    private String account;
    private String password;
    private String eId;
    private String contactNumber;
    private String email;
    private String sex;
    private Date birthday;
    private String customerAddress;
    private Integer registerTime;
    private String originalMembercard;
    private Integer memberLevel;
    private int historyTotalScore;
    private Integer totalScore;
    private String inviter;
    private String subordinateShop;
    private Integer internalStaff;
    private String internalId;
    private Integer userType;
    private String remark;
    private Integer isDel;

    /**
     * Getter method for property customerId.
     *
     * @return property value of customerId
     */
    @Id
    @Column(name = "customer_id", nullable = false, length = 32)
    public String getCustomerId() {
        return customerId;
    }

    /**
     * Setter method for property customerId.
     *
     * @param customerId value to be assigned to property customerId
     */
    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    /**
     * Getter method for property openid.
     *
     * @return property value of openid
     */
    @Basic
    @Column(name = "openid", nullable = false, length = 50)
    public String getOpenid() {
        return openid;
    }

    /**
     * Setter method for property openid.
     *
     * @param openid value to be assigned to property openid
     */
    public void setOpenid(String openid) {
        this.openid = openid;
    }

    /**
     * Getter method for property customerName.
     *
     * @return property value of customerName
     */
    @Basic
    @Column(name = "customer_name", nullable = false, length = 50)
    public String getCustomerName() {
        return customerName;
    }

    /**
     * Setter method for property customerName.
     *
     * @param customerName value to be assigned to property customerName
     */
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    /**
     * Getter method for property nickName.
     *
     * @return property value of nickName
     */
    @Basic
    @Column(name = "nick_name", nullable = true, length = 50)
    public String getNickName() {
        return nickName;
    }

    /**
     * Setter method for property nickName.
     *
     * @param nickName value to be assigned to property nickName
     */
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    /**
     * Getter method for property account.
     *
     * @return property value of account
     */
    @Basic
    @Column(name = "account", nullable = true, length = 50)
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
    @Column(name = "password", nullable = true, length = 50)
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
     * Getter method for property eId.
     *
     * @return property value of eId
     */
    @Basic
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
     * Getter method for property email.
     *
     * @return property value of email
     */
    @Basic
    @Column(name = "email", nullable = true, length = 100)
    public String getEmail() {
        return email;
    }

    /**
     * Setter method for property email.
     *
     * @param email value to be assigned to property email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Getter method for property sex.
     *
     * @return property value of sex
     */
    @Basic
    @Column(name = "sex", nullable = true, length = 2)
    public String getSex() {
        return sex;
    }

    /**
     * Setter method for property sex.
     *
     * @param sex value to be assigned to property sex
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     * Getter method for property birthday.
     *
     * @return property value of birthday
     */
    @Basic
    @Column(name = "birthday", nullable = true)
    public Date getBirthday() {
        return birthday;
    }

    /**
     * Setter method for property birthday.
     *
     * @param birthday value to be assigned to property birthday
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    /**
     * Getter method for property customerAddress.
     *
     * @return property value of customerAddress
     */
    @Basic
    @Column(name = "customer_address", nullable = true, length = 200)
    public String getCustomerAddress() {
        return customerAddress;
    }

    /**
     * Setter method for property customerAddress.
     *
     * @param customerAddress value to be assigned to property customerAddress
     */
    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    /**
     * Getter method for property registerTime.
     *
     * @return property value of registerTime
     */
    @Basic
    @Column(name = "register_time", nullable = true)
    public Integer getRegisterTime() {
        return registerTime;
    }

    /**
     * Setter method for property registerTime.
     *
     * @param registerTime value to be assigned to property registerTime
     */
    public void setRegisterTime(Integer registerTime) {
        this.registerTime = registerTime;
    }

    /**
     * Getter method for property originalMembercard.
     *
     * @return property value of originalMembercard
     */
    @Basic
    @Column(name = "original_membercard", nullable = true, length = 32)
    public String getOriginalMembercard() {
        return originalMembercard;
    }

    /**
     * Setter method for property originalMembercard.
     *
     * @param originalMembercard value to be assigned to property originalMembercard
     */
    public void setOriginalMembercard(String originalMembercard) {
        this.originalMembercard = originalMembercard;
    }

    /**
     * Getter method for property memberLevel.
     *
     * @return property value of memberLevel
     */
    @Basic
    @Column(name = "member_level", nullable = true)
    public Integer getMemberLevel() {
        return memberLevel;
    }

    /**
     * Setter method for property memberLevel.
     *
     * @param memberLevel value to be assigned to property memberLevel
     */
    public void setMemberLevel(Integer memberLevel) {
        this.memberLevel = memberLevel;
    }

    /**
     * Getter method for property historyTotalScore.
     *
     * @return property value of historyTotalScore
     */
    @Basic
    @Column(name = "history_total_score", nullable = false)
    public int getHistoryTotalScore() {
        return historyTotalScore;
    }

    /**
     * Setter method for property historyTotalScore.
     *
     * @param historyTotalScore value to be assigned to property historyTotalScore
     */
    public void setHistoryTotalScore(int historyTotalScore) {
        this.historyTotalScore = historyTotalScore;
    }

    /**
     * Getter method for property totalScore.
     *
     * @return property value of totalScore
     */
    @Basic
    @Column(name = "total_score", nullable = true)
    public Integer getTotalScore() {
        return totalScore;
    }

    /**
     * Setter method for property totalScore.
     *
     * @param totalScore value to be assigned to property totalScore
     */
    public void setTotalScore(Integer totalScore) {
        this.totalScore = totalScore;
    }

    /**
     * Getter method for property inviter.
     *
     * @return property value of inviter
     */
    @Basic
    @Column(name = "inviter", nullable = true, length = 32)
    public String getInviter() {
        return inviter;
    }

    /**
     * Setter method for property inviter.
     *
     * @param inviter value to be assigned to property inviter
     */
    public void setInviter(String inviter) {
        this.inviter = inviter;
    }

    /**
     * Getter method for property subordinateShop.
     *
     * @return property value of subordinateShop
     */
    @Basic
    @Column(name = "subordinate_shop", nullable = true, length = 32)
    public String getSubordinateShop() {
        return subordinateShop;
    }

    /**
     * Setter method for property subordinateShop.
     *
     * @param subordinateShop value to be assigned to property subordinateShop
     */
    public void setSubordinateShop(String subordinateShop) {
        this.subordinateShop = subordinateShop;
    }

    /**
     * Getter method for property internalStaff.
     *
     * @return property value of internalStaff
     */
    @Basic
    @Column(name = "internal_staff", nullable = true)
    public Integer getInternalStaff() {
        return internalStaff;
    }

    /**
     * Setter method for property internalStaff.
     *
     * @param internalStaff value to be assigned to property internalStaff
     */
    public void setInternalStaff(Integer internalStaff) {
        this.internalStaff = internalStaff;
    }

    /**
     * Getter method for property internalId.
     *
     * @return property value of internalId
     */
    @Basic
    @Column(name = "internal_id", nullable = true, length = 32)
    public String getInternalId() {
        return internalId;
    }

    /**
     * Setter method for property internalId.
     *
     * @param internalId value to be assigned to property internalId
     */
    public void setInternalId(String internalId) {
        this.internalId = internalId;
    }

    /**
     * Getter method for property userType.
     *
     * @return property value of userType
     */
    @Basic
    @Column(name = "user_type", nullable = true)
    public Integer getUserType() {
        return userType;
    }

    /**
     * Setter method for property userType.
     *
     * @param userType value to be assigned to property userType
     */
    public void setUserType(Integer userType) {
        this.userType = userType;
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

        TCustomerinfo that = (TCustomerinfo) o;

        if (historyTotalScore != that.historyTotalScore) return false;
        if (customerId != null ? !customerId.equals(that.customerId) : that.customerId != null) return false;
        if (openid != null ? !openid.equals(that.openid) : that.openid != null) return false;
        if (customerName != null ? !customerName.equals(that.customerName) : that.customerName != null) return false;
        if (nickName != null ? !nickName.equals(that.nickName) : that.nickName != null) return false;
        if (account != null ? !account.equals(that.account) : that.account != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        if (eId != null ? !eId.equals(that.eId) : that.eId != null) return false;
        if (contactNumber != null ? !contactNumber.equals(that.contactNumber) : that.contactNumber != null)
            return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (sex != null ? !sex.equals(that.sex) : that.sex != null) return false;
        if (birthday != null ? !birthday.equals(that.birthday) : that.birthday != null) return false;
        if (customerAddress != null ? !customerAddress.equals(that.customerAddress) : that.customerAddress != null)
            return false;
        if (registerTime != null ? !registerTime.equals(that.registerTime) : that.registerTime != null) return false;
        if (originalMembercard != null ? !originalMembercard.equals(that.originalMembercard) : that.originalMembercard != null)
            return false;
        if (memberLevel != null ? !memberLevel.equals(that.memberLevel) : that.memberLevel != null) return false;
        if (totalScore != null ? !totalScore.equals(that.totalScore) : that.totalScore != null) return false;
        if (inviter != null ? !inviter.equals(that.inviter) : that.inviter != null) return false;
        if (subordinateShop != null ? !subordinateShop.equals(that.subordinateShop) : that.subordinateShop != null)
            return false;
        if (internalStaff != null ? !internalStaff.equals(that.internalStaff) : that.internalStaff != null)
            return false;
        if (internalId != null ? !internalId.equals(that.internalId) : that.internalId != null) return false;
        if (userType != null ? !userType.equals(that.userType) : that.userType != null) return false;
        if (remark != null ? !remark.equals(that.remark) : that.remark != null) return false;
        if (isDel != null ? !isDel.equals(that.isDel) : that.isDel != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = customerId != null ? customerId.hashCode() : 0;
        result = 31 * result + (openid != null ? openid.hashCode() : 0);
        result = 31 * result + (customerName != null ? customerName.hashCode() : 0);
        result = 31 * result + (nickName != null ? nickName.hashCode() : 0);
        result = 31 * result + (account != null ? account.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (eId != null ? eId.hashCode() : 0);
        result = 31 * result + (contactNumber != null ? contactNumber.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (sex != null ? sex.hashCode() : 0);
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        result = 31 * result + (customerAddress != null ? customerAddress.hashCode() : 0);
        result = 31 * result + (registerTime != null ? registerTime.hashCode() : 0);
        result = 31 * result + (originalMembercard != null ? originalMembercard.hashCode() : 0);
        result = 31 * result + (memberLevel != null ? memberLevel.hashCode() : 0);
        result = 31 * result + historyTotalScore;
        result = 31 * result + (totalScore != null ? totalScore.hashCode() : 0);
        result = 31 * result + (inviter != null ? inviter.hashCode() : 0);
        result = 31 * result + (subordinateShop != null ? subordinateShop.hashCode() : 0);
        result = 31 * result + (internalStaff != null ? internalStaff.hashCode() : 0);
        result = 31 * result + (internalId != null ? internalId.hashCode() : 0);
        result = 31 * result + (userType != null ? userType.hashCode() : 0);
        result = 31 * result + (remark != null ? remark.hashCode() : 0);
        result = 31 * result + (isDel != null ? isDel.hashCode() : 0);
        return result;
    }
}
/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package com.shinnlove.common.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;

/**
 * @author shinnlove.jinsheng
 * @version $Id: TShopguide.java, v 0.1 2017-12-10 上午11:51 shinnlove.jinsheng Exp $$
 */
@Entity
@Table(name = "t_shopguide", schema = "weact", catalog = "")
public class TShopguide {
    private String guideId;
    private String eId;
    private String subbranchId;
    private String guideNumber;
    private String account;
    private String password;
    private String guideName;
    private String nickname;
    private Integer sex;
    private String idCard;
    private Date birthday;
    private String cellphone;
    private String signature;
    private String dimensionCode;
    private String headimg;
    private Integer guideLevel;
    private Integer guideType;
    private Integer busyStatus;
    private BigDecimal starLevel;
    private Integer commentCount;
    private BigDecimal expectSales;
    private Integer addTime;
    private Integer latestModify;
    private String remark;
    private Integer isDel;

    /**
     * Getter method for property guideId.
     *
     * @return property value of guideId
     */
    @Id
    @Column(name = "guide_id", nullable = false, length = 32)
    public String getGuideId() {
        return guideId;
    }

    /**
     * Setter method for property guideId.
     *
     * @param guideId value to be assigned to property guideId
     */
    public void setGuideId(String guideId) {
        this.guideId = guideId;
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
     * Getter method for property subbranchId.
     *
     * @return property value of subbranchId
     */
    @Basic
    @Column(name = "subbranch_id", nullable = false, length = 32)
    public String getSubbranchId() {
        return subbranchId;
    }

    /**
     * Setter method for property subbranchId.
     *
     * @param subbranchId value to be assigned to property subbranchId
     */
    public void setSubbranchId(String subbranchId) {
        this.subbranchId = subbranchId;
    }

    /**
     * Getter method for property guideNumber.
     *
     * @return property value of guideNumber
     */
    @Basic
    @Column(name = "guide_number", nullable = true, length = 50)
    public String getGuideNumber() {
        return guideNumber;
    }

    /**
     * Setter method for property guideNumber.
     *
     * @param guideNumber value to be assigned to property guideNumber
     */
    public void setGuideNumber(String guideNumber) {
        this.guideNumber = guideNumber;
    }

    /**
     * Getter method for property account.
     *
     * @return property value of account
     */
    @Basic
    @Column(name = "account", nullable = false, length = 32)
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
    @Column(name = "password", nullable = false, length = 32)
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
     * Getter method for property guideName.
     *
     * @return property value of guideName
     */
    @Basic
    @Column(name = "guide_name", nullable = true, length = 50)
    public String getGuideName() {
        return guideName;
    }

    /**
     * Setter method for property guideName.
     *
     * @param guideName value to be assigned to property guideName
     */
    public void setGuideName(String guideName) {
        this.guideName = guideName;
    }

    /**
     * Getter method for property nickname.
     *
     * @return property value of nickname
     */
    @Basic
    @Column(name = "nickname", nullable = true, length = 50)
    public String getNickname() {
        return nickname;
    }

    /**
     * Setter method for property nickname.
     *
     * @param nickname value to be assigned to property nickname
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /**
     * Getter method for property sex.
     *
     * @return property value of sex
     */
    @Basic
    @Column(name = "sex", nullable = true)
    public Integer getSex() {
        return sex;
    }

    /**
     * Setter method for property sex.
     *
     * @param sex value to be assigned to property sex
     */
    public void setSex(Integer sex) {
        this.sex = sex;
    }

    /**
     * Getter method for property idCard.
     *
     * @return property value of idCard
     */
    @Basic
    @Column(name = "id_card", nullable = true, length = 18)
    public String getIdCard() {
        return idCard;
    }

    /**
     * Setter method for property idCard.
     *
     * @param idCard value to be assigned to property idCard
     */
    public void setIdCard(String idCard) {
        this.idCard = idCard;
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
     * Getter method for property cellphone.
     *
     * @return property value of cellphone
     */
    @Basic
    @Column(name = "cellphone", nullable = true, length = 18)
    public String getCellphone() {
        return cellphone;
    }

    /**
     * Setter method for property cellphone.
     *
     * @param cellphone value to be assigned to property cellphone
     */
    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    /**
     * Getter method for property signature.
     *
     * @return property value of signature
     */
    @Basic
    @Column(name = "signature", nullable = true, length = 100)
    public String getSignature() {
        return signature;
    }

    /**
     * Setter method for property signature.
     *
     * @param signature value to be assigned to property signature
     */
    public void setSignature(String signature) {
        this.signature = signature;
    }

    /**
     * Getter method for property dimensionCode.
     *
     * @return property value of dimensionCode
     */
    @Basic
    @Column(name = "dimension_code", nullable = true, length = 255)
    public String getDimensionCode() {
        return dimensionCode;
    }

    /**
     * Setter method for property dimensionCode.
     *
     * @param dimensionCode value to be assigned to property dimensionCode
     */
    public void setDimensionCode(String dimensionCode) {
        this.dimensionCode = dimensionCode;
    }

    /**
     * Getter method for property headimg.
     *
     * @return property value of headimg
     */
    @Basic
    @Column(name = "headimg", nullable = true, length = 255)
    public String getHeadimg() {
        return headimg;
    }

    /**
     * Setter method for property headimg.
     *
     * @param headimg value to be assigned to property headimg
     */
    public void setHeadimg(String headimg) {
        this.headimg = headimg;
    }

    /**
     * Getter method for property guideLevel.
     *
     * @return property value of guideLevel
     */
    @Basic
    @Column(name = "guide_level", nullable = true)
    public Integer getGuideLevel() {
        return guideLevel;
    }

    /**
     * Setter method for property guideLevel.
     *
     * @param guideLevel value to be assigned to property guideLevel
     */
    public void setGuideLevel(Integer guideLevel) {
        this.guideLevel = guideLevel;
    }

    /**
     * Getter method for property guideType.
     *
     * @return property value of guideType
     */
    @Basic
    @Column(name = "guide_type", nullable = true)
    public Integer getGuideType() {
        return guideType;
    }

    /**
     * Setter method for property guideType.
     *
     * @param guideType value to be assigned to property guideType
     */
    public void setGuideType(Integer guideType) {
        this.guideType = guideType;
    }

    /**
     * Getter method for property busyStatus.
     *
     * @return property value of busyStatus
     */
    @Basic
    @Column(name = "busy_status", nullable = true)
    public Integer getBusyStatus() {
        return busyStatus;
    }

    /**
     * Setter method for property busyStatus.
     *
     * @param busyStatus value to be assigned to property busyStatus
     */
    public void setBusyStatus(Integer busyStatus) {
        this.busyStatus = busyStatus;
    }

    /**
     * Getter method for property starLevel.
     *
     * @return property value of starLevel
     */
    @Basic
    @Column(name = "star_level", nullable = true, precision = 2)
    public BigDecimal getStarLevel() {
        return starLevel;
    }

    /**
     * Setter method for property starLevel.
     *
     * @param starLevel value to be assigned to property starLevel
     */
    public void setStarLevel(BigDecimal starLevel) {
        this.starLevel = starLevel;
    }

    /**
     * Getter method for property commentCount.
     *
     * @return property value of commentCount
     */
    @Basic
    @Column(name = "comment_count", nullable = true)
    public Integer getCommentCount() {
        return commentCount;
    }

    /**
     * Setter method for property commentCount.
     *
     * @param commentCount value to be assigned to property commentCount
     */
    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
    }

    /**
     * Getter method for property expectSales.
     *
     * @return property value of expectSales
     */
    @Basic
    @Column(name = "expect_sales", nullable = false, precision = 2)
    public BigDecimal getExpectSales() {
        return expectSales;
    }

    /**
     * Setter method for property expectSales.
     *
     * @param expectSales value to be assigned to property expectSales
     */
    public void setExpectSales(BigDecimal expectSales) {
        this.expectSales = expectSales;
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
     * Getter method for property latestModify.
     *
     * @return property value of latestModify
     */
    @Basic
    @Column(name = "latest_modify", nullable = true)
    public Integer getLatestModify() {
        return latestModify;
    }

    /**
     * Setter method for property latestModify.
     *
     * @param latestModify value to be assigned to property latestModify
     */
    public void setLatestModify(Integer latestModify) {
        this.latestModify = latestModify;
    }

    /**
     * Getter method for property remark.
     *
     * @return property value of remark
     */
    @Basic
    @Column(name = "remark", nullable = true, length = 255)
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

        TShopguide that = (TShopguide) o;

        if (guideId != null ? !guideId.equals(that.guideId) : that.guideId != null) return false;
        if (eId != null ? !eId.equals(that.eId) : that.eId != null) return false;
        if (subbranchId != null ? !subbranchId.equals(that.subbranchId) : that.subbranchId != null) return false;
        if (guideNumber != null ? !guideNumber.equals(that.guideNumber) : that.guideNumber != null) return false;
        if (account != null ? !account.equals(that.account) : that.account != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        if (guideName != null ? !guideName.equals(that.guideName) : that.guideName != null) return false;
        if (nickname != null ? !nickname.equals(that.nickname) : that.nickname != null) return false;
        if (sex != null ? !sex.equals(that.sex) : that.sex != null) return false;
        if (idCard != null ? !idCard.equals(that.idCard) : that.idCard != null) return false;
        if (birthday != null ? !birthday.equals(that.birthday) : that.birthday != null) return false;
        if (cellphone != null ? !cellphone.equals(that.cellphone) : that.cellphone != null) return false;
        if (signature != null ? !signature.equals(that.signature) : that.signature != null) return false;
        if (dimensionCode != null ? !dimensionCode.equals(that.dimensionCode) : that.dimensionCode != null)
            return false;
        if (headimg != null ? !headimg.equals(that.headimg) : that.headimg != null) return false;
        if (guideLevel != null ? !guideLevel.equals(that.guideLevel) : that.guideLevel != null) return false;
        if (guideType != null ? !guideType.equals(that.guideType) : that.guideType != null) return false;
        if (busyStatus != null ? !busyStatus.equals(that.busyStatus) : that.busyStatus != null) return false;
        if (starLevel != null ? !starLevel.equals(that.starLevel) : that.starLevel != null) return false;
        if (commentCount != null ? !commentCount.equals(that.commentCount) : that.commentCount != null) return false;
        if (expectSales != null ? !expectSales.equals(that.expectSales) : that.expectSales != null) return false;
        if (addTime != null ? !addTime.equals(that.addTime) : that.addTime != null) return false;
        if (latestModify != null ? !latestModify.equals(that.latestModify) : that.latestModify != null) return false;
        if (remark != null ? !remark.equals(that.remark) : that.remark != null) return false;
        if (isDel != null ? !isDel.equals(that.isDel) : that.isDel != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = guideId != null ? guideId.hashCode() : 0;
        result = 31 * result + (eId != null ? eId.hashCode() : 0);
        result = 31 * result + (subbranchId != null ? subbranchId.hashCode() : 0);
        result = 31 * result + (guideNumber != null ? guideNumber.hashCode() : 0);
        result = 31 * result + (account != null ? account.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (guideName != null ? guideName.hashCode() : 0);
        result = 31 * result + (nickname != null ? nickname.hashCode() : 0);
        result = 31 * result + (sex != null ? sex.hashCode() : 0);
        result = 31 * result + (idCard != null ? idCard.hashCode() : 0);
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        result = 31 * result + (cellphone != null ? cellphone.hashCode() : 0);
        result = 31 * result + (signature != null ? signature.hashCode() : 0);
        result = 31 * result + (dimensionCode != null ? dimensionCode.hashCode() : 0);
        result = 31 * result + (headimg != null ? headimg.hashCode() : 0);
        result = 31 * result + (guideLevel != null ? guideLevel.hashCode() : 0);
        result = 31 * result + (guideType != null ? guideType.hashCode() : 0);
        result = 31 * result + (busyStatus != null ? busyStatus.hashCode() : 0);
        result = 31 * result + (starLevel != null ? starLevel.hashCode() : 0);
        result = 31 * result + (commentCount != null ? commentCount.hashCode() : 0);
        result = 31 * result + (expectSales != null ? expectSales.hashCode() : 0);
        result = 31 * result + (addTime != null ? addTime.hashCode() : 0);
        result = 31 * result + (latestModify != null ? latestModify.hashCode() : 0);
        result = 31 * result + (remark != null ? remark.hashCode() : 0);
        result = 31 * result + (isDel != null ? isDel.hashCode() : 0);
        return result;
    }
}
/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package com.shinnlove.common.model;

import javax.persistence.*;

/**
 * @author shinnlove.jinsheng
 * @version $Id: TCustomerguide.java, v 0.1 2017-12-10 上午11:51 shinnlove.jinsheng Exp $$
 */
@Entity
@Table(name = "t_customerguide", schema = "weact", catalog = "")
public class TCustomerguide {
    private String cusGuideId;
    private String customerId;
    private String eId;
    private String subbranchId;
    private String guideId;
    private Integer chooseTime;
    private String guideRemarkname;
    private String remark;
    private Integer isDel;

    /**
     * Getter method for property cusGuideId.
     *
     * @return property value of cusGuideId
     */
    @Id
    @Column(name = "cus_guide_id", nullable = false, length = 32)
    public String getCusGuideId() {
        return cusGuideId;
    }

    /**
     * Setter method for property cusGuideId.
     *
     * @param cusGuideId value to be assigned to property cusGuideId
     */
    public void setCusGuideId(String cusGuideId) {
        this.cusGuideId = cusGuideId;
    }

    /**
     * Getter method for property customerId.
     *
     * @return property value of customerId
     */
    @Basic
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
     * Getter method for property guideId.
     *
     * @return property value of guideId
     */
    @Basic
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
     * Getter method for property chooseTime.
     *
     * @return property value of chooseTime
     */
    @Basic
    @Column(name = "choose_time", nullable = true)
    public Integer getChooseTime() {
        return chooseTime;
    }

    /**
     * Setter method for property chooseTime.
     *
     * @param chooseTime value to be assigned to property chooseTime
     */
    public void setChooseTime(Integer chooseTime) {
        this.chooseTime = chooseTime;
    }

    /**
     * Getter method for property guideRemarkname.
     *
     * @return property value of guideRemarkname
     */
    @Basic
    @Column(name = "guide_remarkname", nullable = true, length = 50)
    public String getGuideRemarkname() {
        return guideRemarkname;
    }

    /**
     * Setter method for property guideRemarkname.
     *
     * @param guideRemarkname value to be assigned to property guideRemarkname
     */
    public void setGuideRemarkname(String guideRemarkname) {
        this.guideRemarkname = guideRemarkname;
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

        TCustomerguide that = (TCustomerguide) o;

        if (cusGuideId != null ? !cusGuideId.equals(that.cusGuideId) : that.cusGuideId != null) return false;
        if (customerId != null ? !customerId.equals(that.customerId) : that.customerId != null) return false;
        if (eId != null ? !eId.equals(that.eId) : that.eId != null) return false;
        if (subbranchId != null ? !subbranchId.equals(that.subbranchId) : that.subbranchId != null) return false;
        if (guideId != null ? !guideId.equals(that.guideId) : that.guideId != null) return false;
        if (chooseTime != null ? !chooseTime.equals(that.chooseTime) : that.chooseTime != null) return false;
        if (guideRemarkname != null ? !guideRemarkname.equals(that.guideRemarkname) : that.guideRemarkname != null)
            return false;
        if (remark != null ? !remark.equals(that.remark) : that.remark != null) return false;
        if (isDel != null ? !isDel.equals(that.isDel) : that.isDel != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = cusGuideId != null ? cusGuideId.hashCode() : 0;
        result = 31 * result + (customerId != null ? customerId.hashCode() : 0);
        result = 31 * result + (eId != null ? eId.hashCode() : 0);
        result = 31 * result + (subbranchId != null ? subbranchId.hashCode() : 0);
        result = 31 * result + (guideId != null ? guideId.hashCode() : 0);
        result = 31 * result + (chooseTime != null ? chooseTime.hashCode() : 0);
        result = 31 * result + (guideRemarkname != null ? guideRemarkname.hashCode() : 0);
        result = 31 * result + (remark != null ? remark.hashCode() : 0);
        result = 31 * result + (isDel != null ? isDel.hashCode() : 0);
        return result;
    }
}
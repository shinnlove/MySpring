/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package com.shinnlove.common.model;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * @author shinnlove.jinsheng
 * @version $Id: TSubbranch.java, v 0.1 2017-12-10 上午11:51 shinnlove.jinsheng Exp $$
 */
@Entity
@Table(name = "t_subbranch", schema = "weact", catalog = "")
public class TSubbranch {
    private String subbranchId;
    private String eId;
    private String subbranchName;
    private String subbranchBrand;
    private String subbranchCode;
    private Integer addTime;
    private Integer latestModify;
    private String province;
    private String city;
    private String county;
    private String subbranchAddress;
    private BigDecimal longitude;
    private BigDecimal latitude;
    private String subbranchDescription;
    private Integer subbranchType;
    private String manager;
    private String contactNumber;
    private String imagePath;
    private String signsPath;
    private String businessLicense;
    private Integer closedStatus;
    private Integer examineStatus;
    private String remark;
    private Integer isDel;

    /**
     * Getter method for property subbranchId.
     *
     * @return property value of subbranchId
     */
    @Id
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
     * Getter method for property subbranchName.
     *
     * @return property value of subbranchName
     */
    @Basic
    @Column(name = "subbranch_name", nullable = true, length = 500)
    public String getSubbranchName() {
        return subbranchName;
    }

    /**
     * Setter method for property subbranchName.
     *
     * @param subbranchName value to be assigned to property subbranchName
     */
    public void setSubbranchName(String subbranchName) {
        this.subbranchName = subbranchName;
    }

    /**
     * Getter method for property subbranchBrand.
     *
     * @return property value of subbranchBrand
     */
    @Basic
    @Column(name = "subbranch_brand", nullable = true, length = 100)
    public String getSubbranchBrand() {
        return subbranchBrand;
    }

    /**
     * Setter method for property subbranchBrand.
     *
     * @param subbranchBrand value to be assigned to property subbranchBrand
     */
    public void setSubbranchBrand(String subbranchBrand) {
        this.subbranchBrand = subbranchBrand;
    }

    /**
     * Getter method for property subbranchCode.
     *
     * @return property value of subbranchCode
     */
    @Basic
    @Column(name = "subbranch_code", nullable = true, length = 50)
    public String getSubbranchCode() {
        return subbranchCode;
    }

    /**
     * Setter method for property subbranchCode.
     *
     * @param subbranchCode value to be assigned to property subbranchCode
     */
    public void setSubbranchCode(String subbranchCode) {
        this.subbranchCode = subbranchCode;
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
     * Getter method for property province.
     *
     * @return property value of province
     */
    @Basic
    @Column(name = "province", nullable = true, length = 32)
    public String getProvince() {
        return province;
    }

    /**
     * Setter method for property province.
     *
     * @param province value to be assigned to property province
     */
    public void setProvince(String province) {
        this.province = province;
    }

    /**
     * Getter method for property city.
     *
     * @return property value of city
     */
    @Basic
    @Column(name = "city", nullable = true, length = 32)
    public String getCity() {
        return city;
    }

    /**
     * Setter method for property city.
     *
     * @param city value to be assigned to property city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Getter method for property county.
     *
     * @return property value of county
     */
    @Basic
    @Column(name = "county", nullable = true, length = 32)
    public String getCounty() {
        return county;
    }

    /**
     * Setter method for property county.
     *
     * @param county value to be assigned to property county
     */
    public void setCounty(String county) {
        this.county = county;
    }

    /**
     * Getter method for property subbranchAddress.
     *
     * @return property value of subbranchAddress
     */
    @Basic
    @Column(name = "subbranch_address", nullable = true, length = 500)
    public String getSubbranchAddress() {
        return subbranchAddress;
    }

    /**
     * Setter method for property subbranchAddress.
     *
     * @param subbranchAddress value to be assigned to property subbranchAddress
     */
    public void setSubbranchAddress(String subbranchAddress) {
        this.subbranchAddress = subbranchAddress;
    }

    /**
     * Getter method for property longitude.
     *
     * @return property value of longitude
     */
    @Basic
    @Column(name = "longitude", nullable = true, precision = 12)
    public BigDecimal getLongitude() {
        return longitude;
    }

    /**
     * Setter method for property longitude.
     *
     * @param longitude value to be assigned to property longitude
     */
    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    /**
     * Getter method for property latitude.
     *
     * @return property value of latitude
     */
    @Basic
    @Column(name = "latitude", nullable = true, precision = 12)
    public BigDecimal getLatitude() {
        return latitude;
    }

    /**
     * Setter method for property latitude.
     *
     * @param latitude value to be assigned to property latitude
     */
    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    /**
     * Getter method for property subbranchDescription.
     *
     * @return property value of subbranchDescription
     */
    @Basic
    @Column(name = "subbranch_description", nullable = true, length = -1)
    public String getSubbranchDescription() {
        return subbranchDescription;
    }

    /**
     * Setter method for property subbranchDescription.
     *
     * @param subbranchDescription value to be assigned to property subbranchDescription
     */
    public void setSubbranchDescription(String subbranchDescription) {
        this.subbranchDescription = subbranchDescription;
    }

    /**
     * Getter method for property subbranchType.
     *
     * @return property value of subbranchType
     */
    @Basic
    @Column(name = "subbranch_type", nullable = true)
    public Integer getSubbranchType() {
        return subbranchType;
    }

    /**
     * Setter method for property subbranchType.
     *
     * @param subbranchType value to be assigned to property subbranchType
     */
    public void setSubbranchType(Integer subbranchType) {
        this.subbranchType = subbranchType;
    }

    /**
     * Getter method for property manager.
     *
     * @return property value of manager
     */
    @Basic
    @Column(name = "manager", nullable = true, length = 50)
    public String getManager() {
        return manager;
    }

    /**
     * Setter method for property manager.
     *
     * @param manager value to be assigned to property manager
     */
    public void setManager(String manager) {
        this.manager = manager;
    }

    /**
     * Getter method for property contactNumber.
     *
     * @return property value of contactNumber
     */
    @Basic
    @Column(name = "contact_number", nullable = true, length = 50)
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
     * Getter method for property imagePath.
     *
     * @return property value of imagePath
     */
    @Basic
    @Column(name = "image_path", nullable = true, length = 255)
    public String getImagePath() {
        return imagePath;
    }

    /**
     * Setter method for property imagePath.
     *
     * @param imagePath value to be assigned to property imagePath
     */
    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    /**
     * Getter method for property signsPath.
     *
     * @return property value of signsPath
     */
    @Basic
    @Column(name = "signs_path", nullable = true, length = 255)
    public String getSignsPath() {
        return signsPath;
    }

    /**
     * Setter method for property signsPath.
     *
     * @param signsPath value to be assigned to property signsPath
     */
    public void setSignsPath(String signsPath) {
        this.signsPath = signsPath;
    }

    /**
     * Getter method for property businessLicense.
     *
     * @return property value of businessLicense
     */
    @Basic
    @Column(name = "business_license", nullable = true, length = 18)
    public String getBusinessLicense() {
        return businessLicense;
    }

    /**
     * Setter method for property businessLicense.
     *
     * @param businessLicense value to be assigned to property businessLicense
     */
    public void setBusinessLicense(String businessLicense) {
        this.businessLicense = businessLicense;
    }

    /**
     * Getter method for property closedStatus.
     *
     * @return property value of closedStatus
     */
    @Basic
    @Column(name = "closed_status", nullable = true)
    public Integer getClosedStatus() {
        return closedStatus;
    }

    /**
     * Setter method for property closedStatus.
     *
     * @param closedStatus value to be assigned to property closedStatus
     */
    public void setClosedStatus(Integer closedStatus) {
        this.closedStatus = closedStatus;
    }

    /**
     * Getter method for property examineStatus.
     *
     * @return property value of examineStatus
     */
    @Basic
    @Column(name = "examine_status", nullable = true)
    public Integer getExamineStatus() {
        return examineStatus;
    }

    /**
     * Setter method for property examineStatus.
     *
     * @param examineStatus value to be assigned to property examineStatus
     */
    public void setExamineStatus(Integer examineStatus) {
        this.examineStatus = examineStatus;
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

        TSubbranch that = (TSubbranch) o;

        if (subbranchId != null ? !subbranchId.equals(that.subbranchId) : that.subbranchId != null) return false;
        if (eId != null ? !eId.equals(that.eId) : that.eId != null) return false;
        if (subbranchName != null ? !subbranchName.equals(that.subbranchName) : that.subbranchName != null)
            return false;
        if (subbranchBrand != null ? !subbranchBrand.equals(that.subbranchBrand) : that.subbranchBrand != null)
            return false;
        if (subbranchCode != null ? !subbranchCode.equals(that.subbranchCode) : that.subbranchCode != null)
            return false;
        if (addTime != null ? !addTime.equals(that.addTime) : that.addTime != null) return false;
        if (latestModify != null ? !latestModify.equals(that.latestModify) : that.latestModify != null) return false;
        if (province != null ? !province.equals(that.province) : that.province != null) return false;
        if (city != null ? !city.equals(that.city) : that.city != null) return false;
        if (county != null ? !county.equals(that.county) : that.county != null) return false;
        if (subbranchAddress != null ? !subbranchAddress.equals(that.subbranchAddress) : that.subbranchAddress != null)
            return false;
        if (longitude != null ? !longitude.equals(that.longitude) : that.longitude != null) return false;
        if (latitude != null ? !latitude.equals(that.latitude) : that.latitude != null) return false;
        if (subbranchDescription != null ? !subbranchDescription.equals(that.subbranchDescription) : that.subbranchDescription != null)
            return false;
        if (subbranchType != null ? !subbranchType.equals(that.subbranchType) : that.subbranchType != null)
            return false;
        if (manager != null ? !manager.equals(that.manager) : that.manager != null) return false;
        if (contactNumber != null ? !contactNumber.equals(that.contactNumber) : that.contactNumber != null)
            return false;
        if (imagePath != null ? !imagePath.equals(that.imagePath) : that.imagePath != null) return false;
        if (signsPath != null ? !signsPath.equals(that.signsPath) : that.signsPath != null) return false;
        if (businessLicense != null ? !businessLicense.equals(that.businessLicense) : that.businessLicense != null)
            return false;
        if (closedStatus != null ? !closedStatus.equals(that.closedStatus) : that.closedStatus != null) return false;
        if (examineStatus != null ? !examineStatus.equals(that.examineStatus) : that.examineStatus != null)
            return false;
        if (remark != null ? !remark.equals(that.remark) : that.remark != null) return false;
        if (isDel != null ? !isDel.equals(that.isDel) : that.isDel != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = subbranchId != null ? subbranchId.hashCode() : 0;
        result = 31 * result + (eId != null ? eId.hashCode() : 0);
        result = 31 * result + (subbranchName != null ? subbranchName.hashCode() : 0);
        result = 31 * result + (subbranchBrand != null ? subbranchBrand.hashCode() : 0);
        result = 31 * result + (subbranchCode != null ? subbranchCode.hashCode() : 0);
        result = 31 * result + (addTime != null ? addTime.hashCode() : 0);
        result = 31 * result + (latestModify != null ? latestModify.hashCode() : 0);
        result = 31 * result + (province != null ? province.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (county != null ? county.hashCode() : 0);
        result = 31 * result + (subbranchAddress != null ? subbranchAddress.hashCode() : 0);
        result = 31 * result + (longitude != null ? longitude.hashCode() : 0);
        result = 31 * result + (latitude != null ? latitude.hashCode() : 0);
        result = 31 * result + (subbranchDescription != null ? subbranchDescription.hashCode() : 0);
        result = 31 * result + (subbranchType != null ? subbranchType.hashCode() : 0);
        result = 31 * result + (manager != null ? manager.hashCode() : 0);
        result = 31 * result + (contactNumber != null ? contactNumber.hashCode() : 0);
        result = 31 * result + (imagePath != null ? imagePath.hashCode() : 0);
        result = 31 * result + (signsPath != null ? signsPath.hashCode() : 0);
        result = 31 * result + (businessLicense != null ? businessLicense.hashCode() : 0);
        result = 31 * result + (closedStatus != null ? closedStatus.hashCode() : 0);
        result = 31 * result + (examineStatus != null ? examineStatus.hashCode() : 0);
        result = 31 * result + (remark != null ? remark.hashCode() : 0);
        result = 31 * result + (isDel != null ? isDel.hashCode() : 0);
        return result;
    }
}
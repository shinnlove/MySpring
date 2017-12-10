/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package com.shinnlove.common.model;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * @author shinnlove.jinsheng
 * @version $Id: TEnterpriseinfo.java, v 0.1 2017-12-10 上午11:51 shinnlove.jinsheng Exp $$
 */
@Entity
@Table(name = "t_enterpriseinfo", schema = "weact", catalog = "")
public class TEnterpriseinfo {
    private String eInfoId;
    private String eId;
    private String brand;
    private String eName;
    private String description;
    private String eIndexLogo;
    private String eSquareLogo;
    private String eRectLogo;
    private String qrCode;
    private String eContactPerson;
    private String eProvince;
    private String eCity;
    private String eCounty;
    private String eAddress;
    private BigDecimal eLongitude;
    private BigDecimal eLatitude;
    private String wechatAccount;
    private String wechatName;
    private Integer industry;
    private String siteName;
    private String focusUrl;
    private String originalId;
    private Integer isAuth;
    private String developerToken;
    private String appid;
    private String appsecret;
    private Integer msgEncode;
    private String aeskey;
    private String paysignkey;
    private String partnerid;
    private String partnerkey;
    private Integer tenpayOpen;
    private Integer authorizeOpen;
    private Integer loginStyle;
    private Integer allSubbranch;
    private int allowDistribute;
    private BigDecimal p2PInitialFee;
    private String remark;
    private Integer isDel;

    /**
     * Getter method for property eInfoId.
     *
     * @return property value of eInfoId
     */
    @Id
    @Column(name = "e_info_id", nullable = false, length = 32)
    public String geteInfoId() {
        return eInfoId;
    }

    /**
     * Setter method for property eInfoId.
     *
     * @param eInfoId value to be assigned to property eInfoId
     */
    public void seteInfoId(String eInfoId) {
        this.eInfoId = eInfoId;
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
     * Getter method for property brand.
     *
     * @return property value of brand
     */
    @Basic
    @Column(name = "brand", nullable = true, length = 50)
    public String getBrand() {
        return brand;
    }

    /**
     * Setter method for property brand.
     *
     * @param brand value to be assigned to property brand
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     * Getter method for property eName.
     *
     * @return property value of eName
     */
    @Basic
    @Column(name = "e_name", nullable = true, length = 50)
    public String geteName() {
        return eName;
    }

    /**
     * Setter method for property eName.
     *
     * @param eName value to be assigned to property eName
     */
    public void seteName(String eName) {
        this.eName = eName;
    }

    /**
     * Getter method for property description.
     *
     * @return property value of description
     */
    @Basic
    @Column(name = "description", nullable = true, length = 255)
    public String getDescription() {
        return description;
    }

    /**
     * Setter method for property description.
     *
     * @param description value to be assigned to property description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Getter method for property eIndexLogo.
     *
     * @return property value of eIndexLogo
     */
    @Basic
    @Column(name = "e_index_logo", nullable = true, length = 200)
    public String geteIndexLogo() {
        return eIndexLogo;
    }

    /**
     * Setter method for property eIndexLogo.
     *
     * @param eIndexLogo value to be assigned to property eIndexLogo
     */
    public void seteIndexLogo(String eIndexLogo) {
        this.eIndexLogo = eIndexLogo;
    }

    /**
     * Getter method for property eSquareLogo.
     *
     * @return property value of eSquareLogo
     */
    @Basic
    @Column(name = "e_square_logo", nullable = true, length = 200)
    public String geteSquareLogo() {
        return eSquareLogo;
    }

    /**
     * Setter method for property eSquareLogo.
     *
     * @param eSquareLogo value to be assigned to property eSquareLogo
     */
    public void seteSquareLogo(String eSquareLogo) {
        this.eSquareLogo = eSquareLogo;
    }

    /**
     * Getter method for property eRectLogo.
     *
     * @return property value of eRectLogo
     */
    @Basic
    @Column(name = "e_rect_logo", nullable = true, length = 200)
    public String geteRectLogo() {
        return eRectLogo;
    }

    /**
     * Setter method for property eRectLogo.
     *
     * @param eRectLogo value to be assigned to property eRectLogo
     */
    public void seteRectLogo(String eRectLogo) {
        this.eRectLogo = eRectLogo;
    }

    /**
     * Getter method for property qrCode.
     *
     * @return property value of qrCode
     */
    @Basic
    @Column(name = "qr_code", nullable = true, length = 200)
    public String getQrCode() {
        return qrCode;
    }

    /**
     * Setter method for property qrCode.
     *
     * @param qrCode value to be assigned to property qrCode
     */
    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
    }

    /**
     * Getter method for property eContactPerson.
     *
     * @return property value of eContactPerson
     */
    @Basic
    @Column(name = "e_contact_person", nullable = true, length = 50)
    public String geteContactPerson() {
        return eContactPerson;
    }

    /**
     * Setter method for property eContactPerson.
     *
     * @param eContactPerson value to be assigned to property eContactPerson
     */
    public void seteContactPerson(String eContactPerson) {
        this.eContactPerson = eContactPerson;
    }

    /**
     * Getter method for property eProvince.
     *
     * @return property value of eProvince
     */
    @Basic
    @Column(name = "e_province", nullable = true, length = 32)
    public String geteProvince() {
        return eProvince;
    }

    /**
     * Setter method for property eProvince.
     *
     * @param eProvince value to be assigned to property eProvince
     */
    public void seteProvince(String eProvince) {
        this.eProvince = eProvince;
    }

    /**
     * Getter method for property eCity.
     *
     * @return property value of eCity
     */
    @Basic
    @Column(name = "e_city", nullable = true, length = 32)
    public String geteCity() {
        return eCity;
    }

    /**
     * Setter method for property eCity.
     *
     * @param eCity value to be assigned to property eCity
     */
    public void seteCity(String eCity) {
        this.eCity = eCity;
    }

    /**
     * Getter method for property eCounty.
     *
     * @return property value of eCounty
     */
    @Basic
    @Column(name = "e_county", nullable = true, length = 32)
    public String geteCounty() {
        return eCounty;
    }

    /**
     * Setter method for property eCounty.
     *
     * @param eCounty value to be assigned to property eCounty
     */
    public void seteCounty(String eCounty) {
        this.eCounty = eCounty;
    }

    /**
     * Getter method for property eAddress.
     *
     * @return property value of eAddress
     */
    @Basic
    @Column(name = "e_address", nullable = true, length = 500)
    public String geteAddress() {
        return eAddress;
    }

    /**
     * Setter method for property eAddress.
     *
     * @param eAddress value to be assigned to property eAddress
     */
    public void seteAddress(String eAddress) {
        this.eAddress = eAddress;
    }

    /**
     * Getter method for property eLongitude.
     *
     * @return property value of eLongitude
     */
    @Basic
    @Column(name = "e_longitude", nullable = true, precision = 12)
    public BigDecimal geteLongitude() {
        return eLongitude;
    }

    /**
     * Setter method for property eLongitude.
     *
     * @param eLongitude value to be assigned to property eLongitude
     */
    public void seteLongitude(BigDecimal eLongitude) {
        this.eLongitude = eLongitude;
    }

    /**
     * Getter method for property eLatitude.
     *
     * @return property value of eLatitude
     */
    @Basic
    @Column(name = "e_latitude", nullable = true, precision = 12)
    public BigDecimal geteLatitude() {
        return eLatitude;
    }

    /**
     * Setter method for property eLatitude.
     *
     * @param eLatitude value to be assigned to property eLatitude
     */
    public void seteLatitude(BigDecimal eLatitude) {
        this.eLatitude = eLatitude;
    }

    /**
     * Getter method for property wechatAccount.
     *
     * @return property value of wechatAccount
     */
    @Basic
    @Column(name = "wechat_account", nullable = true, length = 50)
    public String getWechatAccount() {
        return wechatAccount;
    }

    /**
     * Setter method for property wechatAccount.
     *
     * @param wechatAccount value to be assigned to property wechatAccount
     */
    public void setWechatAccount(String wechatAccount) {
        this.wechatAccount = wechatAccount;
    }

    /**
     * Getter method for property wechatName.
     *
     * @return property value of wechatName
     */
    @Basic
    @Column(name = "wechat_name", nullable = true, length = 50)
    public String getWechatName() {
        return wechatName;
    }

    /**
     * Setter method for property wechatName.
     *
     * @param wechatName value to be assigned to property wechatName
     */
    public void setWechatName(String wechatName) {
        this.wechatName = wechatName;
    }

    /**
     * Getter method for property industry.
     *
     * @return property value of industry
     */
    @Basic
    @Column(name = "industry", nullable = true)
    public Integer getIndustry() {
        return industry;
    }

    /**
     * Setter method for property industry.
     *
     * @param industry value to be assigned to property industry
     */
    public void setIndustry(Integer industry) {
        this.industry = industry;
    }

    /**
     * Getter method for property siteName.
     *
     * @return property value of siteName
     */
    @Basic
    @Column(name = "site_name", nullable = true, length = 50)
    public String getSiteName() {
        return siteName;
    }

    /**
     * Setter method for property siteName.
     *
     * @param siteName value to be assigned to property siteName
     */
    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    /**
     * Getter method for property focusUrl.
     *
     * @return property value of focusUrl
     */
    @Basic
    @Column(name = "focus_url", nullable = true, length = 255)
    public String getFocusUrl() {
        return focusUrl;
    }

    /**
     * Setter method for property focusUrl.
     *
     * @param focusUrl value to be assigned to property focusUrl
     */
    public void setFocusUrl(String focusUrl) {
        this.focusUrl = focusUrl;
    }

    /**
     * Getter method for property originalId.
     *
     * @return property value of originalId
     */
    @Basic
    @Column(name = "original_id", nullable = true, length = 50)
    public String getOriginalId() {
        return originalId;
    }

    /**
     * Setter method for property originalId.
     *
     * @param originalId value to be assigned to property originalId
     */
    public void setOriginalId(String originalId) {
        this.originalId = originalId;
    }

    /**
     * Getter method for property isAuth.
     *
     * @return property value of isAuth
     */
    @Basic
    @Column(name = "is_auth", nullable = true)
    public Integer getIsAuth() {
        return isAuth;
    }

    /**
     * Setter method for property isAuth.
     *
     * @param isAuth value to be assigned to property isAuth
     */
    public void setIsAuth(Integer isAuth) {
        this.isAuth = isAuth;
    }

    /**
     * Getter method for property developerToken.
     *
     * @return property value of developerToken
     */
    @Basic
    @Column(name = "developer_token", nullable = true, length = 50)
    public String getDeveloperToken() {
        return developerToken;
    }

    /**
     * Setter method for property developerToken.
     *
     * @param developerToken value to be assigned to property developerToken
     */
    public void setDeveloperToken(String developerToken) {
        this.developerToken = developerToken;
    }

    /**
     * Getter method for property appid.
     *
     * @return property value of appid
     */
    @Basic
    @Column(name = "appid", nullable = true, length = 50)
    public String getAppid() {
        return appid;
    }

    /**
     * Setter method for property appid.
     *
     * @param appid value to be assigned to property appid
     */
    public void setAppid(String appid) {
        this.appid = appid;
    }

    /**
     * Getter method for property appsecret.
     *
     * @return property value of appsecret
     */
    @Basic
    @Column(name = "appsecret", nullable = true, length = 50)
    public String getAppsecret() {
        return appsecret;
    }

    /**
     * Setter method for property appsecret.
     *
     * @param appsecret value to be assigned to property appsecret
     */
    public void setAppsecret(String appsecret) {
        this.appsecret = appsecret;
    }

    /**
     * Getter method for property msgEncode.
     *
     * @return property value of msgEncode
     */
    @Basic
    @Column(name = "msg_encode", nullable = true)
    public Integer getMsgEncode() {
        return msgEncode;
    }

    /**
     * Setter method for property msgEncode.
     *
     * @param msgEncode value to be assigned to property msgEncode
     */
    public void setMsgEncode(Integer msgEncode) {
        this.msgEncode = msgEncode;
    }

    /**
     * Getter method for property aeskey.
     *
     * @return property value of aeskey
     */
    @Basic
    @Column(name = "aeskey", nullable = true, length = 43)
    public String getAeskey() {
        return aeskey;
    }

    /**
     * Setter method for property aeskey.
     *
     * @param aeskey value to be assigned to property aeskey
     */
    public void setAeskey(String aeskey) {
        this.aeskey = aeskey;
    }

    /**
     * Getter method for property paysignkey.
     *
     * @return property value of paysignkey
     */
    @Basic
    @Column(name = "paysignkey", nullable = true, length = 255)
    public String getPaysignkey() {
        return paysignkey;
    }

    /**
     * Setter method for property paysignkey.
     *
     * @param paysignkey value to be assigned to property paysignkey
     */
    public void setPaysignkey(String paysignkey) {
        this.paysignkey = paysignkey;
    }

    /**
     * Getter method for property partnerid.
     *
     * @return property value of partnerid
     */
    @Basic
    @Column(name = "partnerid", nullable = true, length = 50)
    public String getPartnerid() {
        return partnerid;
    }

    /**
     * Setter method for property partnerid.
     *
     * @param partnerid value to be assigned to property partnerid
     */
    public void setPartnerid(String partnerid) {
        this.partnerid = partnerid;
    }

    /**
     * Getter method for property partnerkey.
     *
     * @return property value of partnerkey
     */
    @Basic
    @Column(name = "partnerkey", nullable = true, length = 50)
    public String getPartnerkey() {
        return partnerkey;
    }

    /**
     * Setter method for property partnerkey.
     *
     * @param partnerkey value to be assigned to property partnerkey
     */
    public void setPartnerkey(String partnerkey) {
        this.partnerkey = partnerkey;
    }

    /**
     * Getter method for property tenpayOpen.
     *
     * @return property value of tenpayOpen
     */
    @Basic
    @Column(name = "tenpay_open", nullable = true)
    public Integer getTenpayOpen() {
        return tenpayOpen;
    }

    /**
     * Setter method for property tenpayOpen.
     *
     * @param tenpayOpen value to be assigned to property tenpayOpen
     */
    public void setTenpayOpen(Integer tenpayOpen) {
        this.tenpayOpen = tenpayOpen;
    }

    /**
     * Getter method for property authorizeOpen.
     *
     * @return property value of authorizeOpen
     */
    @Basic
    @Column(name = "authorize_open", nullable = true)
    public Integer getAuthorizeOpen() {
        return authorizeOpen;
    }

    /**
     * Setter method for property authorizeOpen.
     *
     * @param authorizeOpen value to be assigned to property authorizeOpen
     */
    public void setAuthorizeOpen(Integer authorizeOpen) {
        this.authorizeOpen = authorizeOpen;
    }

    /**
     * Getter method for property loginStyle.
     *
     * @return property value of loginStyle
     */
    @Basic
    @Column(name = "login_style", nullable = true)
    public Integer getLoginStyle() {
        return loginStyle;
    }

    /**
     * Setter method for property loginStyle.
     *
     * @param loginStyle value to be assigned to property loginStyle
     */
    public void setLoginStyle(Integer loginStyle) {
        this.loginStyle = loginStyle;
    }

    /**
     * Getter method for property allSubbranch.
     *
     * @return property value of allSubbranch
     */
    @Basic
    @Column(name = "all_subbranch", nullable = true)
    public Integer getAllSubbranch() {
        return allSubbranch;
    }

    /**
     * Setter method for property allSubbranch.
     *
     * @param allSubbranch value to be assigned to property allSubbranch
     */
    public void setAllSubbranch(Integer allSubbranch) {
        this.allSubbranch = allSubbranch;
    }

    /**
     * Getter method for property allowDistribute.
     *
     * @return property value of allowDistribute
     */
    @Basic
    @Column(name = "allow_distribute", nullable = false)
    public int getAllowDistribute() {
        return allowDistribute;
    }

    /**
     * Setter method for property allowDistribute.
     *
     * @param allowDistribute value to be assigned to property allowDistribute
     */
    public void setAllowDistribute(int allowDistribute) {
        this.allowDistribute = allowDistribute;
    }

    /**
     * Getter method for property p2PInitialFee.
     *
     * @return property value of p2PInitialFee
     */
    @Basic
    @Column(name = "p2p_initial_fee", nullable = false, precision = 2)
    public BigDecimal getP2PInitialFee() {
        return p2PInitialFee;
    }

    /**
     * Setter method for property p2PInitialFee.
     *
     * @param p2PInitialFee value to be assigned to property p2PInitialFee
     */
    public void setP2PInitialFee(BigDecimal p2PInitialFee) {
        this.p2PInitialFee = p2PInitialFee;
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

        TEnterpriseinfo that = (TEnterpriseinfo) o;

        if (allowDistribute != that.allowDistribute) return false;
        if (eInfoId != null ? !eInfoId.equals(that.eInfoId) : that.eInfoId != null) return false;
        if (eId != null ? !eId.equals(that.eId) : that.eId != null) return false;
        if (brand != null ? !brand.equals(that.brand) : that.brand != null) return false;
        if (eName != null ? !eName.equals(that.eName) : that.eName != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (eIndexLogo != null ? !eIndexLogo.equals(that.eIndexLogo) : that.eIndexLogo != null) return false;
        if (eSquareLogo != null ? !eSquareLogo.equals(that.eSquareLogo) : that.eSquareLogo != null) return false;
        if (eRectLogo != null ? !eRectLogo.equals(that.eRectLogo) : that.eRectLogo != null) return false;
        if (qrCode != null ? !qrCode.equals(that.qrCode) : that.qrCode != null) return false;
        if (eContactPerson != null ? !eContactPerson.equals(that.eContactPerson) : that.eContactPerson != null)
            return false;
        if (eProvince != null ? !eProvince.equals(that.eProvince) : that.eProvince != null) return false;
        if (eCity != null ? !eCity.equals(that.eCity) : that.eCity != null) return false;
        if (eCounty != null ? !eCounty.equals(that.eCounty) : that.eCounty != null) return false;
        if (eAddress != null ? !eAddress.equals(that.eAddress) : that.eAddress != null) return false;
        if (eLongitude != null ? !eLongitude.equals(that.eLongitude) : that.eLongitude != null) return false;
        if (eLatitude != null ? !eLatitude.equals(that.eLatitude) : that.eLatitude != null) return false;
        if (wechatAccount != null ? !wechatAccount.equals(that.wechatAccount) : that.wechatAccount != null)
            return false;
        if (wechatName != null ? !wechatName.equals(that.wechatName) : that.wechatName != null) return false;
        if (industry != null ? !industry.equals(that.industry) : that.industry != null) return false;
        if (siteName != null ? !siteName.equals(that.siteName) : that.siteName != null) return false;
        if (focusUrl != null ? !focusUrl.equals(that.focusUrl) : that.focusUrl != null) return false;
        if (originalId != null ? !originalId.equals(that.originalId) : that.originalId != null) return false;
        if (isAuth != null ? !isAuth.equals(that.isAuth) : that.isAuth != null) return false;
        if (developerToken != null ? !developerToken.equals(that.developerToken) : that.developerToken != null)
            return false;
        if (appid != null ? !appid.equals(that.appid) : that.appid != null) return false;
        if (appsecret != null ? !appsecret.equals(that.appsecret) : that.appsecret != null) return false;
        if (msgEncode != null ? !msgEncode.equals(that.msgEncode) : that.msgEncode != null) return false;
        if (aeskey != null ? !aeskey.equals(that.aeskey) : that.aeskey != null) return false;
        if (paysignkey != null ? !paysignkey.equals(that.paysignkey) : that.paysignkey != null) return false;
        if (partnerid != null ? !partnerid.equals(that.partnerid) : that.partnerid != null) return false;
        if (partnerkey != null ? !partnerkey.equals(that.partnerkey) : that.partnerkey != null) return false;
        if (tenpayOpen != null ? !tenpayOpen.equals(that.tenpayOpen) : that.tenpayOpen != null) return false;
        if (authorizeOpen != null ? !authorizeOpen.equals(that.authorizeOpen) : that.authorizeOpen != null)
            return false;
        if (loginStyle != null ? !loginStyle.equals(that.loginStyle) : that.loginStyle != null) return false;
        if (allSubbranch != null ? !allSubbranch.equals(that.allSubbranch) : that.allSubbranch != null) return false;
        if (p2PInitialFee != null ? !p2PInitialFee.equals(that.p2PInitialFee) : that.p2PInitialFee != null)
            return false;
        if (remark != null ? !remark.equals(that.remark) : that.remark != null) return false;
        if (isDel != null ? !isDel.equals(that.isDel) : that.isDel != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = eInfoId != null ? eInfoId.hashCode() : 0;
        result = 31 * result + (eId != null ? eId.hashCode() : 0);
        result = 31 * result + (brand != null ? brand.hashCode() : 0);
        result = 31 * result + (eName != null ? eName.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (eIndexLogo != null ? eIndexLogo.hashCode() : 0);
        result = 31 * result + (eSquareLogo != null ? eSquareLogo.hashCode() : 0);
        result = 31 * result + (eRectLogo != null ? eRectLogo.hashCode() : 0);
        result = 31 * result + (qrCode != null ? qrCode.hashCode() : 0);
        result = 31 * result + (eContactPerson != null ? eContactPerson.hashCode() : 0);
        result = 31 * result + (eProvince != null ? eProvince.hashCode() : 0);
        result = 31 * result + (eCity != null ? eCity.hashCode() : 0);
        result = 31 * result + (eCounty != null ? eCounty.hashCode() : 0);
        result = 31 * result + (eAddress != null ? eAddress.hashCode() : 0);
        result = 31 * result + (eLongitude != null ? eLongitude.hashCode() : 0);
        result = 31 * result + (eLatitude != null ? eLatitude.hashCode() : 0);
        result = 31 * result + (wechatAccount != null ? wechatAccount.hashCode() : 0);
        result = 31 * result + (wechatName != null ? wechatName.hashCode() : 0);
        result = 31 * result + (industry != null ? industry.hashCode() : 0);
        result = 31 * result + (siteName != null ? siteName.hashCode() : 0);
        result = 31 * result + (focusUrl != null ? focusUrl.hashCode() : 0);
        result = 31 * result + (originalId != null ? originalId.hashCode() : 0);
        result = 31 * result + (isAuth != null ? isAuth.hashCode() : 0);
        result = 31 * result + (developerToken != null ? developerToken.hashCode() : 0);
        result = 31 * result + (appid != null ? appid.hashCode() : 0);
        result = 31 * result + (appsecret != null ? appsecret.hashCode() : 0);
        result = 31 * result + (msgEncode != null ? msgEncode.hashCode() : 0);
        result = 31 * result + (aeskey != null ? aeskey.hashCode() : 0);
        result = 31 * result + (paysignkey != null ? paysignkey.hashCode() : 0);
        result = 31 * result + (partnerid != null ? partnerid.hashCode() : 0);
        result = 31 * result + (partnerkey != null ? partnerkey.hashCode() : 0);
        result = 31 * result + (tenpayOpen != null ? tenpayOpen.hashCode() : 0);
        result = 31 * result + (authorizeOpen != null ? authorizeOpen.hashCode() : 0);
        result = 31 * result + (loginStyle != null ? loginStyle.hashCode() : 0);
        result = 31 * result + (allSubbranch != null ? allSubbranch.hashCode() : 0);
        result = 31 * result + allowDistribute;
        result = 31 * result + (p2PInitialFee != null ? p2PInitialFee.hashCode() : 0);
        result = 31 * result + (remark != null ? remark.hashCode() : 0);
        result = 31 * result + (isDel != null ? isDel.hashCode() : 0);
        return result;
    }
}
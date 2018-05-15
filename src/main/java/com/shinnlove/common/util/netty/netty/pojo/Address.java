/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.shinnlove.common.util.netty.netty.pojo;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * HTTP+XML POJO。
 *
 * @author shinnlove.jinsheng
 * @version $Id: Address.java, v 0.1 2018-05-12 下午10:24 shinnlove.jinsheng Exp $$
 */
public class Address {

    private String street1;

    private String street2;

    private String city;

    private String state;

    private String postCode;

    private String country;

    public Address() {
    }

    public Address(String street1, String street2, String city, String state, String postCode,
                   String country) {
        this.street1 = street1;
        this.street2 = street2;
        this.city = city;
        this.state = state;
        this.postCode = postCode;
        this.country = country;
    }

    /**
     * Getter method for property street1.
     *
     * @return property value of street1
     */
    public String getStreet1() {
        return street1;
    }

    /**
     * Setter method for property street1.
     *
     * @param street1 value to be assigned to property street1
     */
    public void setStreet1(String street1) {
        this.street1 = street1;
    }

    /**
     * Getter method for property street2.
     *
     * @return property value of street2
     */
    public String getStreet2() {
        return street2;
    }

    /**
     * Setter method for property street2.
     *
     * @param street2 value to be assigned to property street2
     */
    public void setStreet2(String street2) {
        this.street2 = street2;
    }

    /**
     * Getter method for property city.
     *
     * @return property value of city
     */
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
     * Getter method for property state.
     *
     * @return property value of state
     */
    public String getState() {
        return state;
    }

    /**
     * Setter method for property state.
     *
     * @param state value to be assigned to property state
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * Getter method for property postCode.
     *
     * @return property value of postCode
     */
    public String getPostCode() {
        return postCode;
    }

    /**
     * Setter method for property postCode.
     *
     * @param postCode value to be assigned to property postCode
     */
    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    /**
     * Getter method for property country.
     *
     * @return property value of country
     */
    public String getCountry() {
        return country;
    }

    /**
     * Setter method for property country.
     *
     * @param country value to be assigned to property country
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

}
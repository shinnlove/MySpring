/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.shinnlove.common.util.netty.netty.pojo;

import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * HTTP+XML POJO。
 *
 * @author shinnlove.jinsheng
 * @version $Id: Customer.java, v 0.1 2018-05-12 下午10:22 shinnlove.jinsheng Exp $$
 */
public class Customer {

    private long         customerNumber;

    private String       firstName;

    private String       lastName;

    private List<String> middleNames;

    public Customer() {
    }

    public Customer(long customerNumber, String firstName, String lastName, List<String> middleNames) {
        this.customerNumber = customerNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleNames = middleNames;
    }

    /**
     * Getter method for property customerNumber.
     *
     * @return property value of customerNumber
     */
    public long getCustomerNumber() {
        return customerNumber;
    }

    /**
     * Setter method for property customerNumber.
     *
     * @param customerNumber value to be assigned to property customerNumber
     */
    public void setCustomerNumber(long customerNumber) {
        this.customerNumber = customerNumber;
    }

    /**
     * Getter method for property firstName.
     *
     * @return property value of firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Setter method for property firstName.
     *
     * @param firstName value to be assigned to property firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Getter method for property lastName.
     *
     * @return property value of lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Setter method for property lastName.
     *
     * @param lastName value to be assigned to property lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Getter method for property middleNames.
     *
     * @return property value of middleNames
     */
    public List<String> getMiddleNames() {
        return middleNames;
    }

    /**
     * Setter method for property middleNames.
     *
     * @param middleNames value to be assigned to property middleNames
     */
    public void setMiddleNames(List<String> middleNames) {
        this.middleNames = middleNames;
    }

    /**
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

}
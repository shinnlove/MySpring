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
 * @version $Id: Order.java, v 0.1 2018-05-12 下午10:21 shinnlove.jinsheng Exp $$
 */
public class Order {

    private long     orderNumber;
    private Customer customer;

    private Address  billTo;

    private Shipping shipping;

    private Address  shipTo;

    private Float    total;

    public Order() {
    }

    public Order(long orderNumber, Customer customer, Address billTo, Shipping shipping,
                 Address shipTo, Float total) {
        this.orderNumber = orderNumber;
        this.customer = customer;
        this.billTo = billTo;
        this.shipping = shipping;
        this.shipTo = shipTo;
        this.total = total;
    }

    /**
     * Getter method for property orderNumber.
     *
     * @return property value of orderNumber
     */
    public long getOrderNumber() {
        return orderNumber;
    }

    /**
     * Setter method for property orderNumber.
     *
     * @param orderNumber value to be assigned to property orderNumber
     */
    public void setOrderNumber(long orderNumber) {
        this.orderNumber = orderNumber;
    }

    /**
     * Getter method for property customer.
     *
     * @return property value of customer
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     * Setter method for property customer.
     *
     * @param customer value to be assigned to property customer
     */
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    /**
     * Getter method for property billTo.
     *
     * @return property value of billTo
     */
    public Address getBillTo() {
        return billTo;
    }

    /**
     * Setter method for property billTo.
     *
     * @param billTo value to be assigned to property billTo
     */
    public void setBillTo(Address billTo) {
        this.billTo = billTo;
    }

    /**
     * Getter method for property shipping.
     *
     * @return property value of shipping
     */
    public Shipping getShipping() {
        return shipping;
    }

    /**
     * Setter method for property shipping.
     *
     * @param shipping value to be assigned to property shipping
     */
    public void setShipping(Shipping shipping) {
        this.shipping = shipping;
    }

    /**
     * Getter method for property shipTo.
     *
     * @return property value of shipTo
     */
    public Address getShipTo() {
        return shipTo;
    }

    /**
     * Setter method for property shipTo.
     *
     * @param shipTo value to be assigned to property shipTo
     */
    public void setShipTo(Address shipTo) {
        this.shipTo = shipTo;
    }

    /**
     * Getter method for property total.
     *
     * @return property value of total
     */
    public Float getTotal() {
        return total;
    }

    /**
     * Setter method for property total.
     *
     * @param total value to be assigned to property total
     */
    public void setTotal(Float total) {
        this.total = total;
    }

    /**
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

}
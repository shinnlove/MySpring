/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.shinnlove.common.util.netty.netty.jibx;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import org.jibx.runtime.*;

import com.shinnlove.common.util.netty.netty.pojo.Address;
import com.shinnlove.common.util.netty.netty.pojo.Customer;
import com.shinnlove.common.util.netty.netty.pojo.Order;
import com.shinnlove.common.util.netty.netty.pojo.Shipping;

/**
 * 测试JiBx类库的使用。
 *
 * @author shinnlove.jinsheng
 * @version $Id: TestOrder.java, v 0.1 2018-05-12 下午10:18 shinnlove.jinsheng Exp $$
 */
public class TestOrder {

    private IBindingFactory     factory      = null;
    private StringWriter        writer       = null;
    private StringReader        reader       = null;
    private final static String CHARSET_NAME = "UTF-8";

    /**
     * 使用JiBx将一个POJO对象转换成XML。
     *
     * @param order
     * @return
     * @throws JiBXException
     * @throws IOException
     */
    private String encode2Xml(Order order) throws JiBXException, IOException {
        factory = BindingDirectory.getFactory(Order.class);
        writer = new StringWriter();
        IMarshallingContext mctx = factory.createMarshallingContext();
        mctx.setIndent(2);
        mctx.marshalDocument(order, CHARSET_NAME, null, writer);
        String xmlStr = writer.toString();
        writer.close();
        System.out.println(xmlStr.toString());
        return xmlStr;
    }

    /**
     * 使用JiBx将XML转换成POJO对象。
     *
     * @param xmlBody
     * @return
     * @throws JiBXException
     */
    private Order decode2Order(String xmlBody) throws JiBXException {
        reader = new StringReader(xmlBody);
        IUnmarshallingContext uctx = factory.createUnmarshallingContext();
        Order order = (Order) uctx.unmarshalDocument(reader);
        return order;
    }

    public static void main(String[] args) throws JiBXException, IOException {
        TestOrder test = new TestOrder();
        Order order = createOrder();
        String body = test.encode2Xml(order);
        Order order2 = test.decode2Order(body);
        System.out.println(order2);
    }

    private static Order createOrder() {
        // customer
        String middleName = "Shinnlove";
        List<String> middleNames = new ArrayList<>();
        middleNames.add(middleName);
        Customer customer = new Customer(20L, "Jack", "Adam", middleNames);

        // billTo
        Address billTo = new Address("上海市浦东新区", "张江镇青桐路", "上海", "上海市", "210000", "中国");

        // shipTo
        Address shipTo = new Address("浙江省嘉兴市平湖县", "当湖街道解放西路", "嘉兴", "浙江省", "314200", "中国");

        return new Order(6L, customer, billTo, Shipping.DOMESTIC_EXPRESS, shipTo, 300f);
    }

}
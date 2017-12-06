/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package com.shinnlove.hibernate.demo.criteria;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Property;
import org.springframework.beans.factory.annotation.Autowired;

import com.shinnlove.common.model.WebData;

/**
 * Hibernate的DetachedCriteria（离线Criteria）例子。
 *
 * @author shinnlove.jinsheng
 * @version $Id: DetachedCriteriaTest.java, v 0.1 2017-12-06 下午10:46 shinnlove.jinsheng Exp $$
 */
public class DetachedCriteriaTest {

    /** hibernate session工厂 */
    @Autowired
    private SessionFactory sessionFactory;

    public static void main(String[] args) {
        DetachedCriteriaTest pt = new DetachedCriteriaTest();
        pt.datached();
        pt.subQuery();
    }

    // 执行离线查询
    private void datached() {
        // 定义一个离线查询
        DetachedCriteria query = DetachedCriteria.forClass(WebData.class).setProjection(
            Property.forName("name"));
        // 打开Session和事务
        Session session = sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        // 执行离线查询
        List list = query.getExecutableCriteria(session).list();
        // 遍历查询的结果
        for (Object obj : list) {
            System.out.println(obj);
        }
        tx.commit();
    }

    // 执行子查询
    private void subQuery() {
        // 定义一个离线查询
        DetachedCriteria subQuery = DetachedCriteria.forClass(WebData.class).setProjection(
            Property.forName("name"));
        // 打开Session和事务
        Session session = sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        // 执行子查询
        List list = session.createCriteria(WebData.class)
        // 下面两行代码的作用相同，都示范了通过子查询添加查询条件
            .add(Property.forName("name").in(subQuery))
            //			.add( Subqueries.propertyIn("name" , subQuery))
            .list();
        // 遍历查询的结果
        for (Object obj : list) {
            System.out.println(obj);
        }
        tx.commit();
    }

}
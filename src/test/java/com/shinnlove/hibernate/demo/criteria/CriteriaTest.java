/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package com.shinnlove.hibernate.demo.criteria;

import java.util.List;

import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import com.shinnlove.common.model.WebData;

/**
 * Hibernate的Criteria例子。
 *
 * @author shinnlove.jinsheng
 * @version $Id: CriteriaTest.java, v 0.1 2017-12-06 下午10:42 shinnlove.jinsheng Exp $$
 */
public class CriteriaTest {

    /** hibernate session工厂 */
    @Autowired
    private SessionFactory sessionFactory;

    public static void main(String[] args) {
        CriteriaTest criteriaTest = new CriteriaTest();
        //		criteriaTest.query();
        //		criteriaTest.queryWithJoin();
        criteriaTest.queryWithFecth();
    }

    private void query() {
        // 打开Session和事务
        Session session = sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        // 使用createCriteria开始条件查询
        List list = session.createCriteria(WebData.class)
        // 根据Student的属性进行过滤数据
            .add(Restrictions.gt("name", "a")).list();
        System.out.println("=====简单条件查询获取所有学生记录=====");
        for (Object obj : list) {
            WebData s = (WebData) obj;
            System.out.println(s.getAuthor());
        }
        tx.commit();
    }

    // 示范根据关联实体的属性过滤数据
    private void queryWithJoin() {
        // 打开Session和事务
        Session session = sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        // 使用createCriteria开始条件查询
        List list = session.createCriteria(WebData.class)
        // 此处增加限制条件必须是Student实体存在的属性
            .add(Restrictions.gt("studentNumber", 20050231))
            // 如果要增加对Student的关联类的属性的限制
            // 则必须重新createCriteria()
            // 如果此关联属性是集合，则只要集合里任意一个对象的属性满足下面条件即可
            //			.createCriteria("enrolments")
            //			.add( Restrictions.gt("semester" , 2))
            .createAlias("enrolments", "en").add(Restrictions.gt("en.semester", 2)).list();
        System.out.println("=====关联条件查询获取所有学生记录=====");
        for (Object obj : list) {
            WebData s = (WebData) obj;
            System.out.println(s.getAuthor());

        }
        tx.commit();
    }

    // 示范FetchMode的用法
    private void queryWithFecth() {
        // 打开Session和事务
        Session session = sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        // 使用createCriteria开始条件查询
        List list = session.createCriteria(WebData.class)
            // 此处增加限制条件必须是Student实体存在的属性
            .add(Restrictions.gt("studentNumber", 20050231))
            .setFetchMode("enrolments", FetchMode.JOIN).list();
        tx.commit();
        System.out.println("=====启用预初始化的条件查询获取所有学生记录=====");
        for (Object obj : list) {
            WebData s = (WebData) obj;
            System.out.println(s.getAuthor());
            // Session关闭后访问Student的关联实体
        }
    }

}
/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package com.shinnlove.hibernate.demo.projection;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Property;
import org.springframework.beans.factory.annotation.Autowired;

import com.shinnlove.common.model.WebData;

/**
 * Hibernate的Projection例子。
 *
 * @author shinnlove.jinsheng
 * @version $Id: ProjectionTest.java, v 0.1 2017-12-06 下午10:38 shinnlove.jinsheng Exp $$
 */
public class ProjectionTest {

    /** hibernate session工厂 */
    @Autowired
    private SessionFactory sessionFactory;

    public static void main(String[] args) {
        ProjectionTest pt = new ProjectionTest();
        pt.queryForProperty2();
    }

    private void query() {
        // 打开Session和事务
        Session session = sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        // 使用createCriteria开始条件查询
        List list = session.createCriteria(WebData.class).createAlias("student", "s")
            .setProjection(Projections.projectionList()
            // 统计记录条数
                .add(Projections.rowCount())
                // 统计选择该课程里最大的学生姓名
                .add(Projections.max("s.name"))
                // 按course进行分组
                .add(Projections.groupProperty("course"))).list();
        for (Object ele : list) {
            Object[] objs = (Object[]) ele;
            WebData c = (WebData) objs[2];
            System.out.println("=====<" + c.getAuthor() + ">课程的选课统计=====");
            System.out.println("选课人数:" + objs[0]);
            System.out.println("选课的姓名最大的学生为：" + objs[1]);
        }
        tx.commit();
    }

    private void aliasQuery() {
        // 打开Session和事务
        Session session = sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        List list = session.createCriteria(WebData.class)
            .setProjection(Projections.projectionList()
            // 按course进行分组
                .add(Projections.groupProperty("course"))
                // 统计记录条数，并为统计结果指定别名c
                .add(Projections.alias(Projections.rowCount(), "c"))).addOrder(Order.asc("c"))
            .list();
        for (Object ele : list) {
            System.out.println(Arrays.toString((Object[]) ele));
        }
        tx.commit();
    }

    private void aliasQuery2() {
        // 打开Session和事务
        Session session = sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        List list = session.createCriteria(WebData.class)
            .setProjection(Projections.projectionList()
            // 按course进行分组，并为分组结果指定别名c
                .add(Projections.groupProperty("course").as("c"))
                // 统计记录条数
                .add(Projections.rowCount())).addOrder(Order.asc("c")).list();
        for (Object ele : list) {
            System.out.println(java.util.Arrays.toString((Object[]) ele));
        }
        tx.commit();
    }

    private void aliasQuery3() {
        // 打开Session和事务
        Session session = sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        List list = session.createCriteria(WebData.class)
            .setProjection(Projections.projectionList()
            // 按course进行分组，指定别名为c
                .add(Projections.groupProperty("course"), "c")
                // 统计每组记录的条数，指定别名为rc
                .add(Projections.rowCount(), "rc")).addOrder(Order.asc("rc")).list();
        for (Object ele : list) {
            System.out.println(java.util.Arrays.toString((Object[]) ele));
        }
        tx.commit();
    }

    private void queryForProperty() {
        // 打开Session和事务
        Session session = sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        // 使用Property只选出指定列
        List list = session.createCriteria(WebData.class).setProjection(Property.forName("name"))
            .list();
        for (Object ele : list) {
            System.out.println(ele);
        }
        tx.commit();
    }

    private void queryForProperty2() {
        // 打开Session和事务
        Session session = sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        // 使用Property选出指定列，并根据指定列过滤数据
        List list = session
            .createCriteria(WebData.class)
            .createAlias("student", "s")
            .setProjection(
                Projections.projectionList().add(Property.forName("course"))
                    .add(Property.forName("s.name"))).add(Property.forName("s.name").eq("孙悟空")) // ①
            .list();
        for (Object ele : list) {
            System.out.println(java.util.Arrays.toString((Object[]) ele));
        }
        tx.commit();
    }

}
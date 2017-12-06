/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package com.shinnlove.hibernate.demo.hql;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.shinnlove.common.model.WebData;

/**
 * Hibernate的HQL查询。
 *
 * @author shinnlove.jinsheng
 * @version $Id: HqlQuery.java, v 0.1 2017-12-06 下午10:53 shinnlove.jinsheng Exp $$
 */
public class HqlQuery {

    /** hibernate session工厂 */
    @Autowired
    private SessionFactory sessionFactory;

    public static void main(String[] args) throws Exception {
        HqlQuery mgr = new HqlQuery();
        // 调用查询方法
        mgr.findPersons();
        // 调用第二个查询方法
        mgr.findPersonsByHappenDate();
        // 调用第二个查询方法
        mgr.findPersonProperty();

        // implicit的HQL
        mgr.findPersons2();
        // 调用第二个查询方法
        mgr.findPersonsByHappenDate2();
        mgr.findPersonsFetchMyEvent();

        // 命名查询
        mgr.findByNamedQuery();

    }

    // 第一个查询方法
    private void findPersons() {
        // 获得Hibernate Session
        Session session = sessionFactory.getCurrentSession();
        // 开始事务
        Transaction tx = session.beginTransaction();
        // 以HQL语句创建Query对象.
        List pl = session
            .createQuery(
                "select distinct p from Person p " + "join p.myEvents where title = :eventTitle")
            // 执行setString()方法为HQL语句的参数赋值
            .setString("eventTitle", "很普通的事情")
            // Query调用list()方法获取查询的全部实例
            .list();
        // 遍历查询的全部结果
        for (Object ele : pl) {
            WebData p = (WebData) ele;
            System.out.println(p.getAuthor());
        }
        // 提交事务
        tx.commit();
    }

    // 第二个查询方法
    private void findPersonsByHappenDate() throws Exception {
        // 获得Hibernate Session对象
        Session session = sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        // 解析出Date对象
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date start = sdf.parse("2005-01-01");
        System.out.println("系统开始通过日期查找人" + start);
        // 通过Session的createQuery方法创建Query对象
        List pl = session
            .createQuery(
                "select distinct p from Person p "
                        + "inner join p.myEvents event where event.happenDate "
                        + "between :firstDate and :endDate")
            // 设置参数
            .setDate("firstDate", start).setDate("endDate", new Date())
            // 返回结果集
            .list();
        // 遍历结果集
        for (Object ele : pl) {
            WebData p = (WebData) ele;
            System.out.println(p.getAuthor());
        }
        tx.commit();
    }

    // 第三个查询方法：查询属性
    private void findPersonProperty() {
        // 获得Hibernate Session
        Session session = sessionFactory.getCurrentSession();
        // 开始事务
        Transaction tx = session.beginTransaction();
        // 以HQL语句创建Query对象.
        List pl = session.createQuery(
            "select distinct p.id,  p.name , p.age " + "from Person p join p.myEvents")
        // Query调用list()方法访问查询得到的全部属性
            .list();
        // 遍历查询的全部结果
        for (Object ele : pl) {
            Object[] objs = (Object[]) ele;
            System.out.println(java.util.Arrays.toString(objs));
        }
        // 提交事务
        tx.commit();
    }

    //c第一个查询方法
    private void findPersons2() {
        // 获得Hibernate Session
        Session session = sessionFactory.getCurrentSession();
        // 开始事务
        Transaction tx = session.beginTransaction();
        // 以HQL语句创建Query对象,HQL语句使用隐式连接
        List pl = session.createQuery("from Person p where p.myEvent.title > :title")
        // 执行setString()方法为HQL语句的参数赋值
            .setString("title", " ")
            //Query调用list()方法访问查询的全部实例
            .list();
        // 遍历查询的全部结果
        for (Object ele : pl) {
            WebData p = (WebData) ele;
            System.out.println(p.getAuthor());
        }
        // 提交事务
        tx.commit();
    }

    // 第二个查询方法
    private void findPersonsByHappenDate2() throws Exception {
        // 获得Hibernate Session对象
        Session session = sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        System.out.println("====开始通过日期查找人====");
        // 以HQL语句创建Query对象,HQL语句使用显式连接
        // 因为没有使用fetch关键字，所以返回List集合元素是被查询实体
        List pl = session
            .createQuery(
                "select p from Person p left join "
                        + "p.myEvent event where event.happenDate < :endDate")
            .setDate("endDate", new Date()).list();
        // 遍历结果集
        for (Object ele : pl) {
            WebData p = (WebData) ele;
            System.out.println(p.getAuthor());
            // 因为执行HQL时没有使用fetch，
            // 所以只能在Session没有关闭时访问Person关联实体的属性
            //            System.out.println(p.getMyEvent().getTitle());
        }
        tx.commit();
    }

    // 第三个查询方法，测试fetch关键字
    private void findPersonsFetchMyEvent() throws Exception {
        // 获得Hibernate Session对象
        Session session = sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        System.out.println("====测试fetch查询====");
        // 以HQL语句创建Query对象,HQL语句使用显式连接
        // 因为使用了fetch关键字，所以返回结果中已有包含关联实体
        List pl = session
            .createQuery(
                "from Person p left join fetch "
                        + "p.myEvent event where event.happenDate < :endDate")
            .setDate("endDate", new Date()).list();
        tx.commit();

        // 遍历结果集
        for (Object ele : pl) {
            WebData p = (WebData) ele;
            System.out.println(p.getAuthor());
            // 因为HQL语句中使用了fecth关键字
            // 所以可以在Session关闭后访问Person关联实体的属性
            //            System.out.println(p.getMyEvent().getTitle());
        }
    }

    /**
     * 一定要和Entity类要对上。
     *
     * @throws Exception
     */
    private void findByNamedQuery() throws Exception {
        // 打开Hibernate的Session和事务
        Session session = sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        System.out.println("===执行命名查询===");
        // 执行命名查询
        List pl = session.getNamedQuery("myNamedQuery")
        // 根据HQL语句里参数索引为参数赋值
            .setInteger(0, 20).list();
        // 迭代输出查询得到的每个Person对象
        for (Object ele : pl) {
            WebData p = (WebData) ele;
            System.out.println(p.getAuthor());
        }
        // 提交事务、关闭Session
        tx.commit();
    }

    // 执行简单的命名SQL查询
    //    private void simpleQuery()
    //    {
    //        // 打开Session和事务
    //        Session session = HibernateUtil.currentSession();
    //        Transaction tx = session.beginTransaction();
    //        // 调用命名查询，直接返回结果
    //        List list = session.getNamedQuery("simpleQuery")
    //                .list();
    //        tx.commit();
    //        HibernateUtil.closeSession();
    //        // 遍历结果集
    //        for(Object ele : list)
    //        {
    //            // 每个集合元素是Student对象
    //            Student s = (Student)ele;
    //            System.out.println(s.getName() + "\t");
    //        }
    //    }
    //
    //    // 执行命名SQL查询
    //    private void query()
    //    {
    //        // 打开Session和事务
    //        Session session = HibernateUtil.currentSession();
    //        Transaction tx = session.beginTransaction();
    //        // 调用命名查询，直接返回结果
    //        List list = session.getNamedQuery("queryTest")
    //                .setInteger("targetYear" , 2005)
    //                .list();
    //        tx.commit();
    //        HibernateUtil.closeSession();
    //        // 遍历结果集
    //        for(Object ele : list)
    //        {
    //            // 每个集合元素是Student、Enrolment
    //            // 和stuName三个元素的数组
    //            Object[] objs = (Object[])ele;
    //            Student s = (Student)objs[0];
    //            Enrolment e = (Enrolment)objs[1];
    //            Course c = (Course)objs[2];
    //            String stuName = (String)objs[3];
    //            System.out.println(s.getName() + "\t"
    //                    + e.getYear() + "\t" + e.getSemester()
    //                    + "\t=" + e.getCourse().getName() + "=\t" + stuName);
    //        }
    //    }
    //
    //    // 调用存储过程
    //    private void callProcedure()
    //    {
    //        // 打开Session和事务
    //        Session session = HibernateUtil.currentSession();
    //        Transaction tx = session.beginTransaction();
    //        // 调用命名查询，直接返回结果
    //        List list = session.getNamedQuery("callProcedure")
    //                .list();
    //        tx.commit();
    //        HibernateUtil.closeSession();
    //        // 遍历结果集
    //        for(Object ele : list)
    //        {
    //            // 每个集合元素是Student对象
    //            Student s = (Student)ele;
    //            System.out.println(s.getName());
    //        }
    //    }

}
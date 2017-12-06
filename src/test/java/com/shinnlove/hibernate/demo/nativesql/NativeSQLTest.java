/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package com.shinnlove.hibernate.demo.nativesql;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.transform.Transformers;
import org.hibernate.type.StandardBasicTypes;
import org.springframework.beans.factory.annotation.Autowired;

import com.shinnlove.common.model.WebData;

/**
 * Hibernate的原生SQL查询。
 *
 * @author shinnlove.jinsheng
 * @version $Id: NativeSQLTest.java, v 0.1 2017-12-06 下午11:10 shinnlove.jinsheng Exp $$
 */
public class NativeSQLTest {

    /** hibernate session工厂 */
    @Autowired
    private SessionFactory sessionFactory;

    public static void main(String[] args) {
        NativeSQLTest test = new NativeSQLTest();
        //		test.scalarQuery();
        //		test.entityQuery();
        //		test.multiEntityQuery();
        test.beanQuery();
        //		test.joinQuery();
    }

    // 执行标量查询
    public void scalarQuery() {
        // 打开Session和事务
        Session session = sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        String sqlString = "select stu.* from student_inf as stu";
        List list = session.createSQLQuery(sqlString)
            // 指定查询name和student_id两个数据列
            .addScalar("name", StandardBasicTypes.STRING)
            .addScalar("student_id", StandardBasicTypes.INTEGER)
            // 返回标量值列表
            .list();
        for (Object ele : list) {
            // 每个集合元素都是一个数组，数组元素是name、student_id两列值
            Object[] row = (Object[]) ele;
            System.out.println(row[0] + "\t" + row[1]);
        }
        tx.commit();
    }

    // 执行实体SQL查询
    public void entityQuery() {
        // 打开Session和事务
        Session session = sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        String sqlString = "select * from enrolment_inf where year=?1";
        List list = session.createSQLQuery(sqlString)
        // 指定将查询的记录行转换成Student实体
            .addEntity(WebData.class)
            // 为SQL字符串的参数设置值
            .setInteger("1", 2005).list();
        for (Object ele : list) {
            // 每个集合元素都是一个Enrolment对象
            WebData e = (WebData) ele;
            //            System.out.println(e.getStudent().getName() + "\t" + e.getCourse().getName());
        }
        tx.commit();
    }

    // 执行返回多个实体的SQL查询
    public void multiEntityQuery() {
        // 打开Session和事务
        Session session = sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        String sqlString = "select s.*,e.*,c.* "
                           + "from student_inf s,enrolment_inf e,course_inf c "
                           + "where s.student_id = e.student_id "
                           + "and e.course_code = c.course_code";
        //        List list = session.createSQLQuery(sqlString)
        //        // 指定将从s表查询得到的记录行转换成Student实体
        //            .addEntity("s", Student.class)
        //            // 指定将从e表查询得到的记录行转换成Enrolment实体
        //            .addEntity("e", Enrolment.class)
        //            // 指定将从c表查询得到的记录行转换成Course实体
        //            .addEntity("c", Course.class).list();
        //        // 提交事务，关闭Session
        //        tx.commit();
        //        // 因为数据已经全部被选出，故程序可以遍历列表中的数据
        //        for (Object ele : list) {
        //            // 每个集合元素都是Student、Enrolment
        //            // 和Course所组成的数组
        //            Object[] objs = (Object[]) ele;
        //            Student s = (Student) objs[0];
        //            Enrolment e = (Enrolment) objs[1];
        //            Course c = (Course) objs[2];
        //            System.out.println(s.getName() + "\t" + e.getYear() + "\t" + e.getSemester() + "\t"
        //                               + c.getName());
        //        }
    }

    // 执行返回普通JavaBean的SQL查询
    public void beanQuery() {
        // 打开Session和事务
        Session session = sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        String sqlString = "select s.name stuName, c.name courseName "
                           + "from student_inf s,enrolment_inf e,course_inf c "
                           + "where s.student_id = e.student_id "
                           + "and e.course_code = c.course_code ";
        List list = session.createSQLQuery(sqlString)
        // 指定将查询的记录行转换成StudentCourse对象
            .setResultTransformer(Transformers.aliasToBean(WebData.class)).list();
        // 提交事务，关闭Session
        tx.commit();
        session.close();
        // 因为数据已经全部被选出，故程序可以遍历列表中的数据
        for (Object ele : list) {
            // 每个集合元素都是StudentCourse对象
            WebData sc = (WebData) ele;
            System.out.println(sc.getAuthor() + "\t" + sc.getTitle());
        }
    }

    // 使用关联的原生SQL查询
    public void joinQuery() {
        // 打开Session和事务
        Session session = sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        String sqlString = "select s.* , e.* from student_inf s , "
                           + "enrolment_inf e where s.student_id=e.student_id";
        List list = session.createSQLQuery(sqlString).addEntity("s", WebData.class)
            .addJoin("e", "s.enrolments").list();
        // 提交事务，关闭Session
        tx.commit();
        session.close();
        // 因为数据已经全部被选出，故程序可以遍历列表中的数据
        for (Object ele : list) {
            // 每个集合元素都是Student、Enrolment组成的数组
            Object[] objs = (Object[]) ele;
            //            Student s = (Student) objs[0];
            //            Enrolment e = (Enrolment) objs[1];
            //            System.out.println(s.getName() + "\t" + e.getYear());
        }
    }

}
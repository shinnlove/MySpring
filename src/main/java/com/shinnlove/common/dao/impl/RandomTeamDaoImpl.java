/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package com.shinnlove.common.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.shinnlove.common.dao.RandomTeamDao;
import com.shinnlove.common.model.RandomTeam;

/**
 * 随机Team仓储类。
 *
 * @author shinnlove.jinsheng
 * @version $Id: RandomTeamDaoImpl.java, v 0.1 2017-12-27 下午11:11 shinnlove.jinsheng Exp $$
 */
public class RandomTeamDaoImpl implements RandomTeamDao {

    /** hibernate session工厂 */
    private SessionFactory sessionFactory;

    @Override
    public long insert(RandomTeam randomTeam) {
        // 事务对象
        Transaction tx = null;
        String hql = "";
        try {
            Session session = sessionFactory.getCurrentSession();
            tx = session.beginTransaction();

            //保存User对象
            session.save(randomTeam);

            //提交事务
            tx.commit();

            return randomTeam.getId();

        } catch (Exception e) {
            e.printStackTrace();
            //回滚事务
            tx.rollback();
        } finally {
            if (tx != null) {
                tx = null;
            }
        }
        return -1L;
    }

    @Override
    public List<RandomTeam> queryTeam() {

        // 事务对象
        Transaction tx = null;
        String hql = "";
        List<RandomTeam> randomTeamList = new ArrayList<RandomTeam>();
        try {
            Session session = sessionFactory.getCurrentSession();
            tx = session.beginTransaction();
            hql = "from RandomTeam";
            Query query = session.createQuery(hql);
            List list = query.list();
            tx.commit();

            // 转换
            for (Object o : list) {
                randomTeamList.add((RandomTeam) o);
            }

        } catch (Exception ex) {
            ex.printStackTrace(); // 打印异常堆栈
        } finally {
            if (tx != null) {
                tx = null;
            }
        }

        return randomTeamList;
    }

    /**
     * Setter method for property sessionFactory.
     *
     * @param sessionFactory value to be assigned to property sessionFactory
     */
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

}
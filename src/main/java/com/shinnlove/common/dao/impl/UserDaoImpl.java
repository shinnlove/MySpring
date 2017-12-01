/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package com.shinnlove.common.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.shinnlove.common.dao.UserDao;
import com.shinnlove.common.model.User;

/**
 * 用户层DAO
 *
 * @author shinnlove.jinsheng
 * @version $Id: UserDaoImpl.java, v 0.1 2017-11-25 下午10:39 shinnlove.jinsheng Exp $$
 */
public class UserDaoImpl implements UserDao {

    private SessionFactory sessionFactory;

    @Override
    public User getUserById(int id) {

        // 事务对象
        Transaction tx = null;
        String hql = "";
        User user = new User();
        try {
            Session session = sessionFactory.getCurrentSession();
            tx = session.beginTransaction();
            hql = "from User where id=?";
            Query query = session.createQuery(hql);
            query.setParameter(0, id);
            List list = query.list();
            tx.commit();
            if (list.size() > 0) {
                user = (User) list.get(0);
            }
        } catch (Exception ex) {
            ex.printStackTrace(); // 打印异常堆栈
        } finally {
            if (tx != null) {
                tx = null;
            }
        }

        return user;
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
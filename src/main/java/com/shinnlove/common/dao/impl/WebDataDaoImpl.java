/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package com.shinnlove.common.dao.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.shinnlove.common.dao.WebDataDao;
import com.shinnlove.common.model.WebData;
import com.shinnlove.web.controller.request.WebDataRequest;
import org.hibernate.criterion.*;

/**
 * 网页数据查询DAO实现。
 *
 * @author shinnlove.jinsheng
 * @version $Id: WebDataDaoImpl.java, v 0.1 2017-12-02 下午12:53 shinnlove.jinsheng Exp $$
 */
public class WebDataDaoImpl implements WebDataDao {

    /** hibernate session工厂 */
    private SessionFactory sessionFactory;

    /**
     * @see com.shinnlove.common.dao.WebDataDao#saveWebData(WebData)
     */
    @Override
    public void saveWebData(WebData webData) {
//        Session session = sessionFactory.getCurrentSession();
//        Transaction tx = session.beginTransaction();
//        try {
//            session.save(webData);
//            tx.commit();
//        } catch (Exception e) {
//            e.printStackTrace();
//            tx.rollback();
//        }
    }

    /**
     * @see com.shinnlove.common.dao.WebDataDao#getWebDataById(int)
     */
    @Override
    public WebData getWebDataById(int id) {
        // 事务对象
        Transaction tx = null;
        String hql = "";
        WebData webData = new WebData();
        try {
            Session session = sessionFactory.getCurrentSession();
            tx = session.beginTransaction();
            hql = "from WebData where id=?";
            Query query = session.createQuery(hql);
            query.setParameter(0, id);
            List list = query.list();
            tx.commit();
            if (list.size() > 0) {
                webData = (WebData) list.get(0);
            }
        } catch (Exception ex) {
            ex.printStackTrace(); // 打印异常堆栈
        } finally {
            if (tx != null) {
                tx = null;
            }
        }
        return webData;
    }

    /**
     * @see com.shinnlove.common.dao.WebDataDao#queryWebDataByPage(WebDataRequest, int, int)
     */
    @Override
    public List<WebData> queryWebDataByPage(WebDataRequest request, int pageNo, int pageSize) {

        List<WebData> webDataList = new ArrayList<>();

        String hql = "from WebData";

        Session session = sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            Query query = session.createQuery(hql);

            //            // 拼接参数
            //            String publisher = request.getPublisher();
            //            if (!"".equals(publisher)) {
            //                hql += " where spidername=?";
            //            }
            //
            //            query.setParameter(0, publisher);

            // 从第几条开始、每一查询返回多少数量
            query.setFirstResult((pageNo - 1) * pageSize);
            query.setMaxResults(pageSize);

            List list = query.list();
            tx.commit();

            // 转换
            for (Object o : list) {
                webDataList.add((WebData) o);
            }

        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        }

        return webDataList;
    }

    /**
     * @see com.shinnlove.common.dao.WebDataDao#queryAllWebDataByPage(WebDataRequest)
     */
    @Override
    public List<WebData> queryAllWebDataByPage(WebDataRequest request) {

        Session session = sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();

        List<WebData> webDataList = new ArrayList<WebData>();

        try {
            String strStartTime = (request.getStartTime() == null) ? "2000-01-01" : request
                .getStartTime().substring(0, 10);
            String strEndTime = (request.getEndTime() == null) ? new SimpleDateFormat("yyyy-MM-dd")
                .format(new Date()) : request.getEndTime().substring(0, 10);

            Date startDate = java.sql.Date.valueOf(strStartTime);

            Date endDate = java.sql.Date.valueOf(strEndTime);

            Criterion creterion = Expression.between("pubtime",startDate,endDate);

            Criteria criteria = session.createCriteria(WebData.class);

            criteria.setFirstResult((request.getPageNo() - 1) * request.getPageSize());
            criteria.setMaxResults(request.getPageSize());

            // 查询结果
            webDataList = criteria.add(Restrictions.eq("spidername", request.getSpiderName()))
                    .add(Restrictions.like("title", "%"+request.getTitle()+"%"))
                    .add(Restrictions.like("author","%"+ request.getPublisher()+"%"))
                        //  mysql数据库中该字段为空无法判断
//                    .add(Restrictions.like("medianame","%%"))
                    .add(Restrictions.like("cContent","%"+request.getContent()+"%"))
                    .add(creterion)
                    .addOrder(Order.desc("pubtime"))
                    .list();

            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        }
        return webDataList;

        //        Iterator iterator =  webDataList.iterator();
        //        while(iterator.hasNext()) {
        //            WebData webData = (WebData) iterator.next();
        //            System.out.println(webData.getId() + webData.getAuthor());
        //        }
        //
        //        List<WebData> webDataList = new ArrayList<>();
        //
        //        String sql = "from WebData t where 1=1 ";
        //        StringBuilder sb = new StringBuilder();
        //
        //        // 查询key（必须和数据字段对应上）
        //        List<Object> paramList = new ArrayList<Object>();
        //
        //        // 动态需要组装的查询参数Map
        //        Map<String, Object> queryMap = new HashMap<String, Object>();
        //        // 处理title
        //        String title = request.getTitle();
        //        if (title != null && !"".equals(title)) {
        //            queryMap.put("title", title);
        //        }
        //        // 处理author
        //        String publisher = request.getPublisher();
        //        if (publisher != null && !"".equals(publisher)) {
        //            queryMap.put("author", publisher);
        //        }
        //
        //        if (!queryMap.isEmpty()) {
        //            for (String key : queryMap.keySet()) {
        //                if (!"".equals(queryMap.get(key))) {
        //                    paramList.add(queryMap.get(key));
        //                    sb.append("and t." + key + " = ? ");
        //                }
        //            }
        //        }
        //        final Object[] objectArr = paramList.toArray();
        //        final String hql = sql + sb.toString() + "order by t.id";
        //        final String sqlcount = "select count(*) " + hql;
        //
        //        final int pageNo = request.getPageNo();
        //        final int pageSize = request.getPageSize();
        //
        //        //        String hql = "from WebData";
        //
        ////        Session session = sessionFactory.getCurrentSession();
        ////        Transaction tx = session.beginTransaction();
        //        try {
        //            Query query = session.createQuery(hql);
        //
        //            //            query.setFirstResult((pageNo-1)*pageSize);
        //            //            query.setMaxResults(pageSize);
        //            for (int i = 0; i < objectArr.length; i++) {
        //                query.setParameter(i, objectArr[i]);
        //            }
        //
        //            List list = query.list();
        //            tx.commit();
        //
        //            // 转换
        //            for (Object o : list) {
        //                webDataList.add((WebData) o);
        //            }
        //
        //        } catch (Exception e) {
        //            e.printStackTrace();
        //            tx.rollback();
        //        }
        //        return webDataList;
    }

    /**
     * @see com.shinnlove.common.dao.WebDataDao#queryAllWebDataCount(WebDataRequest)
     */
    @Override
    public long queryAllWebDataCount(WebDataRequest request) {

        Session session = sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();

        long result = 0;

        try {
            String strStartTime = (request.getStartTime() == null) ? "2000-01-01" : request
                .getStartTime().substring(0, 10);
            String strEndTime = (request.getEndTime() == null) ? new SimpleDateFormat("yyyy-MM-dd")
                .format(new Date()) : request.getEndTime().substring(0, 10);

            Date startDate = java.sql.Date.valueOf(strStartTime);

            Date endDate = java.sql.Date.valueOf(strEndTime);

            Criterion creterion = Expression.between("pubtime", startDate, endDate);

            Criteria criteria = session.createCriteria(WebData.class);

            // 查询结果
            criteria = criteria.add(Restrictions.eq("spidername", request.getSpiderName()))
                    .add(Restrictions.like("title", "%"+request.getTitle()+"%"))
                    .add(Restrictions.like("author","%"+ request.getPublisher()+"%"))
                    //  mysql数据库中该字段为空无法判断
//                    .add(Restrictions.like("medianame","%%"))
                    .add(Restrictions.like("cContent","%"+request.getContent()+"%"))
                    .add(creterion)
                    .setProjection(Projections.rowCount());      // 此处添加count函数

            result = ((Number)criteria.uniqueResult()).intValue();  // 统计计算结果

            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        }
        return result;
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
/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package com.shinnlove.common.dao;

import java.util.List;

import com.shinnlove.common.model.RandomTeam;

/**
 * 随机组的DAO。
 *
 * @author shinnlove.jinsheng
 * @version $Id: RandomTeamDao.java, v 0.1 2017-12-27 下午11:08 shinnlove.jinsheng Exp $$
 */
public interface RandomTeamDao {

    /**
     * 插入一条随机team数据
     *
     * @param randomTeam
     * @return
     */
    long insert(RandomTeam randomTeam);

    /**
     * 判断某个用户的域账号是否已经存在。
     *
     * @param empId   
     * @param empName
     * @return
     */
    int userExist(String empId, String empName);

    /**
     * 查询team。
     *
     * @return
     */
    List<RandomTeam> queryTeam();

    /**
     * 检索某个员工所在的组号（如果存在）
     *
     * @param empName
     * @return
     */
    int checkUserTeamId(String empName);

}
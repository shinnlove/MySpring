/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package com.shinnlove.common.dao.impl;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.shinnlove.common.dao.RandomTeamDao;
import com.shinnlove.common.model.RandomTeam;

/**
 * 随机队伍的单元测试。
 *
 * @author shinnlove.jinsheng
 * @version $Id: RandomTeamDaoImplTest.java, v 0.1 2017-12-27 下午11:15 shinnlove.jinsheng Exp $$
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/META-INF/spring/*.xml")
public class RandomTeamDaoImplTest {

    private static Logger logger = LoggerFactory.getLogger(UserDaoImplTest.class);

    @Autowired
    private RandomTeamDao randomTeamDao;

    @Test
    public void queryAllTeam() {
        List<RandomTeam> randomTeamList = randomTeamDao.queryTeam();
        System.out.println(randomTeamList);
    }

    @Test
    public void insertTeamTest() {
        RandomTeam team = new RandomTeam();

        team.setEmpId("123456");
        team.setEmpName("倩倩");
        team.setDomainAccount("evelyn.hfl");
        team.setTeamId(2);
        team.setTeamName("颜值爆表");
        team.setMemo("代码添加");
        team.setGmtCreate(new Date());
        team.setGmtModified(new Date());
        long id = randomTeamDao.insert(team);
        System.out.println(id);
    }

    @Test
    public void testUserExist() {
        String domainAccount1 = "evelyn.hfl";
        int result1 = randomTeamDao.userExist(domainAccount1);
        assertEquals(1, result1);

        String domainAccount2 = "chensheng.zcs";
        int result2 = randomTeamDao.userExist(domainAccount2);
        assertEquals(0, result2);
    }

}
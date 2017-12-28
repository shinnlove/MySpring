/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package com.shinnlove.web.controller.random.team;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.shinnlove.common.dao.RandomTeamDao;
import com.shinnlove.common.model.RandomTeam;
import com.shinnlove.common.util.log.ExceptionUtil;
import com.shinnlove.common.util.system.exception.SystemException;

/**
 * 随机选组控制器。
 *
 * @author shinnlove.jinsheng
 * @version $Id: RandomTeamController.java, v 0.1 2017-12-28 上午10:42 shinnlove.jinsheng Exp $$
 */
@Controller
public class RandomTeamController {

    @Autowired
    private RandomTeamDao                                         randomTeamDao;

    /** 组的映射 */
    private static Map<Integer/*team_id*/, String/*team_name*/> teamNameMap = new HashMap<Integer, String>();

    static {
        teamNameMap.put(1, "地表最强");
        teamNameMap.put(2, "颜值爆表");
        teamNameMap.put(3, "无懈可击");
        teamNameMap.put(4, "独孤求败");
    }

    /**
     * 请求随机分组页面
     */
    @RequestMapping(value = "/team/randomTeam", method = RequestMethod.GET)
    public String doGet() {
        return "randomTeam";
    }

    /**
     * 请求随机分组页面
     *
     * @param empId         员工工号
     * @param domainAccount 员工域账号
     * @return
     */
    @RequestMapping(value = "/team/randomSelect.json", method = RequestMethod.POST)
    @ResponseBody
    public String requestForRandom(String empId, String empName, String domainAccount) {
        JSONObject result;
        try {

            int exist = randomTeamDao.userExist(domainAccount);
            if (exist <= 0) {
                // 还没分过组就准备分组
                Map<Integer/*team_id*/, Integer/*count*/> countMap = new HashMap<Integer, Integer>();
                List<RandomTeam> randomTeamList = randomTeamDao.queryTeam();

                for (RandomTeam rt : randomTeamList) {
                    int teamId = rt.getTeamId();
                    if (countMap.containsKey(teamId)) {
                        int sum = countMap.get(teamId) + 1;
                        countMap.put(teamId, sum);
                    } else {
                        countMap.put(teamId, 1);
                    }
                } // end for

                int okTeamId = 1, min = 1;
                for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
                    int teamId = entry.getKey();
                    int oneTeamCount = entry.getValue();

                    if (oneTeamCount <= min) {
                        min = oneTeamCount;
                        okTeamId = teamId;
                    }
                }

                // 准备插入
                RandomTeam randomTeam = new RandomTeam();
                randomTeam.setEmpId(empId);
                randomTeam.setEmpName(empName);
                randomTeam.setDomainAccount(domainAccount);
                randomTeam.setTeamId(okTeamId);
                randomTeam.setTeamName(teamNameMap.get(okTeamId));
                randomTeam.setGmtCreate(new Date());
                randomTeam.setGmtModified(new Date());
                randomTeam.setMemo("用户选择随机分组，系统为用户自动添加");
                long id = randomTeamDao.insert(randomTeam);
                if (id <= 0) {
                    throw new SystemException("为新成员分组后插入数据库失败！");
                }

                // 成功返回结果
                JSONObject obj = convert(randomTeam);
                result = buildResult(0, "ok", obj);

            } else {
                // 分过组了就返回已经分过组了
                result = buildResult(10001, "用户已经分过组:", null);
            }

        } catch (Exception e) {
            ExceptionUtil.error(e, "请求随机分组页面出现错误，原因是：", e.getMessage());
            result = buildResult(-1, "System Error:" + e.getMessage(), null);
        }

        return result.toJSONString();
    }

    /**
     * 转换分组成JSONObject。
     *
     * @param randomTeam
     * @return
     */
    private JSONObject convert(RandomTeam randomTeam) {
        JSONObject object = new JSONObject();
        object.put("id", randomTeam.getId());
        object.put("domain_account", randomTeam.getDomainAccount());
        object.put("emp_id", randomTeam.getEmpId());
        object.put("team_id", randomTeam.getTeamId());
        object.put("team_name", randomTeam.getTeamName());
        object.put("gmt_create", randomTeam.getGmtCreate());
        object.put("gmt_modified", randomTeam.getGmtModified());
        object.put("memo", randomTeam.getMemo());
        return object;
    }

    /**
     * 组装标准响应数据给前端。
     *
     * @param errCode   错误码，0代表无错误
     * @param errMsg    错误描述，0的时候msg是ok
     * @param data      若成功数据内容
     * @return
     */
    private JSONObject buildResult(int errCode, String errMsg, Object data) {
        JSONObject result = new JSONObject();
        result.put("errCode", errCode);
        result.put("errMsg", errMsg);
        result.put("data", data);
        return result;
    }

}
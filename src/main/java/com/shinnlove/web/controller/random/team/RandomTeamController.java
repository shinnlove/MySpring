/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package com.shinnlove.web.controller.random.team;

import java.security.MessageDigest;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.shinnlove.common.dao.RandomTeamDao;
import com.shinnlove.common.model.RandomTeam;
import com.shinnlove.common.util.log.ExceptionUtil;
import com.shinnlove.common.util.log.LoggerUtil;
import com.shinnlove.common.util.system.exception.SystemException;

/**
 * 随机选组控制器。
 *
 * @author shinnlove.jinsheng
 * @version $Id: RandomTeamController.java, v 0.1 2017-12-28 上午10:42 shinnlove.jinsheng Exp $$
 */
@Controller
public class RandomTeamController {

    /** logger */
    private static Logger                                         logger       = LoggerFactory
                                                                                   .getLogger(RandomTeamController.class);
    /** 随机team仓储 */
    @Autowired
    private RandomTeamDao                                         randomTeamDao;

    /** 组的映射 */
    private static Map<Integer/*team_id*/, String/*team_name*/> teamNameMap  = new HashMap<Integer, String>();

    /** ctoken的hash映射 */
    private static ConcurrentHashMap<String, String>              tokenHashSet = new ConcurrentHashMap<String, String>();

    static {
        teamNameMap.put(1, "地表最强");
        teamNameMap.put(2, "颜值爆表");
        teamNameMap.put(3, "无懈可击");
        teamNameMap.put(4, "独孤求败");
    }

    @RequestMapping(value = "/team/entry", method = RequestMethod.GET)
    public String doEnter() {
        return "entry";
    }

    /**
     * 请求随机分组页面
     */
    @RequestMapping(value = "/team/randomTeam", method = RequestMethod.GET)
    public String doGet(ModelMap modelMap) {
        int max = 1000;
        Random random = new Random();
        int num = random.nextInt(max);
        String ctoken = encrypt("MD5", String.valueOf(num));
        tokenHashSet.put(ctoken, ctoken);
        modelMap.addAttribute("ctoken", ctoken);
        return "randomTeam";
    }

    private String encrypt(String algorithm, String str) {
        try {
            MessageDigest md = MessageDigest.getInstance(algorithm);
            md.update(str.getBytes());
            StringBuffer sb = new StringBuffer();
            byte[] bytes = md.digest();
            for (int i = 0; i < bytes.length; i++) {
                int b = bytes[i] & 0xFF;
                if (b < 0x10) {
                    sb.append('0');
                }
                sb.append(Integer.toHexString(b));
            }
            return sb.toString();
        } catch (Exception e) {
            return "";
        }
    }

    /**
     * 查询当前所有分组情况。
     *
     * @return
     */
    @RequestMapping(value = "/team/currentTeam.json", method = RequestMethod.POST)
    @ResponseBody
    public String queryCurrentTeam() {
        JSONObject result;
        try {
            List<RandomTeam> randomTeamList = randomTeamDao.queryTeam();

            Map<Integer, List<RandomTeam>> teamGroup = new HashMap<Integer, List<RandomTeam>>();
            teamGroup.put(1, new ArrayList<RandomTeam>());
            teamGroup.put(2, new ArrayList<RandomTeam>());
            teamGroup.put(3, new ArrayList<RandomTeam>());
            teamGroup.put(4, new ArrayList<RandomTeam>());

            for (RandomTeam rt : randomTeamList) {
                try {
                    teamGroup.get(rt.getTeamId()).add(rt);
                } catch (Exception e) {
                    LoggerUtil.warn(logger, e, "有分组信息不完整！跳过该分组");
                }
            }

            result = buildResult(0, "ok", wrapperTeamInfo(teamGroup));
        } catch (Exception e) {
            ExceptionUtil.error(e, "请求随机分组页面出现错误，原因是：", e.getMessage());
            result = buildResult(-1, "System Error:" + e.getMessage(), null);
        }
        return result.toJSONString();
    }

    /**
     * 包装一下队伍信息。
     *
     * @param teamGroup
     * @return
     */
    private JSONArray wrapperTeamInfo(Map<Integer, List<RandomTeam>> teamGroup) {
        // 最终全队信息
        JSONArray fullTeamInfo = new JSONArray();
        for (Map.Entry<Integer, List<RandomTeam>> entry : teamGroup.entrySet()) {
            JSONObject obj = new JSONObject();

            int teamId = entry.getKey();
            obj.put("team_id", teamId);
            obj.put("team_name", teamNameMap.get(teamId));

            JSONArray array = new JSONArray();
            List<RandomTeam> teamList = entry.getValue();
            for (RandomTeam r : teamList) {
                array.add(convert(r));
            }
            obj.put("members", array);

            fullTeamInfo.add(obj);
        } // end for 

        return fullTeamInfo;
    }

    /**
     * 请求随机分组页面
     *
     * @param empId         员工工号
     * @param empName       员工名字
     * @param ctoken        CSRF的token
     * @return
     */
    @RequestMapping(value = "/team/randomSelect.json", method = RequestMethod.POST)
    @ResponseBody
    public String requestForRandom(String empId, String empName, String ctoken) {
        JSONObject result;

        if ("".equals(ctoken)) {
            result = buildResult(-1, "System Error: Invalid ctoken.", null);
        } else {

            if (!tokenHashSet.contains(ctoken)) {
                // 不包含
                result = buildResult(-1, "System Error: Invalid ctoken.", null);
            } else {
                // 包含
                tokenHashSet.remove(ctoken);

                try {

                    int exist = randomTeamDao.userExist(empId, empName);
                    if (exist <= 0) {
                        // 还没分过组就准备分组
                        Map<Integer/*team_id*/, Integer/*count*/> countMap = new HashMap<Integer, Integer>();
                        countMap.put(1, 0);
                        countMap.put(2, 0);
                        countMap.put(3, 0);
                        countMap.put(4, 0);

                        // 统计当前组信息
                        List<RandomTeam> randomTeamList = randomTeamDao.queryTeam();
                        for (RandomTeam rt : randomTeamList) {
                            int teamId = rt.getTeamId();
                            int sum = countMap.get(teamId) + 1;
                            countMap.put(teamId, sum);
                        } // end for

                        int okTeamId = 1, min = 100000;
                        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
                            int teamId = entry.getKey();
                            int oneTeamCount = entry.getValue();

                            if (oneTeamCount < min) {
                                min = oneTeamCount;
                                okTeamId = teamId;
                            }
                        }

                        //                        int max = 100000;
                        //                        Random random = new Random();
                        //                        int okTeamId = random.nextInt(max) % 4 + 1;

                        // 准备插入
                        RandomTeam randomTeam = new RandomTeam();
                        randomTeam.setEmpId(empId);
                        randomTeam.setEmpName(empName);
                        randomTeam.setDomainAccount("alibaba");
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
                        result = buildResult(10001, "用户已经分过组，请不要重复点击！", null);
                    }

                } catch (Exception e) {
                    ExceptionUtil.error(e, "请求随机分组页面出现错误，原因是：", e.getMessage());
                    result = buildResult(-1, "System Error:" + e.getMessage(), null);
                }

            }

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
        object.put("emp_name", randomTeam.getEmpName());
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
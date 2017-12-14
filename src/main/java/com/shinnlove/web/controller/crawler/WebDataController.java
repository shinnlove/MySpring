/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package com.shinnlove.web.controller.crawler;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.shinnlove.common.dao.WebDataDao;
import com.shinnlove.common.model.WebData;
import com.shinnlove.common.util.system.exception.SystemException;
import com.shinnlove.web.controller.request.WebDataRequest;

import javax.servlet.http.HttpServletRequest;

/**
 * 网页数据处理控制器。
 *
 * @author shinnlove.jinsheng
 * @version $Id: WebDataController.java, v 0.1 2017-12-02 下午1:39 shinnlove.jinsheng Exp $$
 */
@Controller
public class WebDataController {

    /** 日志 */
    private static Logger logger = Logger.getLogger(WebDataController.class);

    @Autowired
    private WebDataDao webDataDao;

    /**
     * 查询WebData详情。
     *
     * @param paramKey
     * @return
     */
    @RequestMapping(value = "/crawler/webDataDetail.json", method = { RequestMethod.GET,
            RequestMethod.POST }, produces = "application/json; charset=utf-8")
    @ResponseBody
    public String getWebDataDetail(HttpServletRequest request, String paramKey) {

        String remoteAddr = request.getRemoteAddr();
        Date requestTime = new Date();

        MDC.put("ip", remoteAddr);
        MDC.put("rtime", requestTime);

        JSONObject result;
        try {
            WebData query = JSONObject.parseObject(paramKey, WebData.class);
            WebData webDataDetail = webDataDao.getWebDataById(query.getId());
            JSONObject obj = convert(webDataDetail);
            result = buildResult(0, "ok", obj);
        } catch (Exception e) {
            result = buildResult(-1, "System Error:" + e.getMessage(), null);
        }
        return result.toJSONString();
    }

    /**
     * 分页查询webData
     *
     * @return
     */
    @RequestMapping(value = "/crawler/webDataList.json", method = { RequestMethod.GET,
            RequestMethod.POST }, produces = "application/json; charset=utf-8")
    @ResponseBody
    public String getWebDataByPage(HttpServletRequest request, String paramKey) {

        String remoteAddr = request.getRemoteAddr();
        Date requestTime = new Date();

        MDC.put("ip", remoteAddr);
        MDC.put("rtime", requestTime);

        logger.warn("进入了getWebDataByPage方法，查询参数paramKey=" + paramKey);

        try {
            int a = 10;
            int b = 0;
            int c = a / b;
            String str = String.valueOf(c);
        } catch (Exception e) {
            SystemException exception = new SystemException("出现错误", e);
            logger.error("捕捉到发生错误：", exception);
        }

        JSONObject result;
        try {
            WebDataRequest query = JSON.parseObject(paramKey, WebDataRequest.class);
            //            List<WebData> webDataList = webDataDao.queryWebDataByPage(request, request.getPageNo(),
            //                request.getPageSize());

            //            List<WebData> webDataList = webDataDao.queryWebDataByPage(null, 1, 10);

            // 查询总的数据条数
            Long count = webDataDao.queryAllWebDataCount(query);

            List<WebData> webDataList = webDataDao.queryAllWebDataByPage(query);

            JSONArray array = new JSONArray();
            for (WebData w : webDataList) {
                JSONObject o = convert(w);
                array.add(o);
            }

            result = buildResult(0, "ok", array, count);
        } catch (Exception e) {
            result = buildResult(-1, "System Error:" + e.getMessage(), null);
        }

        return result.toJSONString();
    }

    /**
     * 实体对象转json对象
     *
     * @param webData
     * @return
     */
    private JSONObject convert(WebData webData) {
        JSONObject object = new JSONObject();
        object.put("id", webData.getId());
        object.put("url", webData.getUrl());
        object.put("title", webData.getTitle());
        object.put("content", webData.getContent());
        object.put("pubtime", webData.getPubtime());
        object.put("collecttime", webData.getCollecttime());
        object.put("spidername", webData.getSpidername());
        object.put("machine", webData.getMachine());
        object.put("channel", webData.getChannel());
        object.put("author", webData.getAuthor());
        object.put("medianame", webData.getMedianame());
        object.put("source", webData.getSource());
        object.put("area", webData.getArea());
        object.put("replys", webData.getReplys());
        object.put("viewcount", webData.getViewcount());
        object.put("cContent", webData.getcContent());
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

    /**
     * 组装标准响应数据给前端。
     *
     * @param errCode   错误码，0代表无错误
     * @param errMsg    错误描述，0的时候msg是ok
     * @param data      若成功数据内容
     * @param total     总数量
     * @return
     */
    private JSONObject buildResult(int errCode, String errMsg, Object data, Long total) {
        JSONObject result = new JSONObject();
        result.put("errCode", errCode);
        result.put("errMsg", errMsg);
        result.put("data", data);
        result.put("total", total);
        return result;
    }

}
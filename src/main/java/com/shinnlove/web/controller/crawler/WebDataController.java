/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package com.shinnlove.web.controller.crawler;

import java.util.List;

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
import com.shinnlove.web.controller.request.WebDataRequest;

/**
 * 网页数据处理控制器。
 *
 * @author shinnlove.jinsheng
 * @version $Id: WebDataController.java, v 0.1 2017-12-02 下午1:39 shinnlove.jinsheng Exp $$
 */
@Controller
public class WebDataController {

    @Autowired
    private WebDataDao webDataDao;

    @RequestMapping(value = "/crawler/webData.json", produces = "application/json; charset=utf-8")
    @ResponseBody
    public String getWebData() {
        int id = 1;
        WebData webData = webDataDao.getWebDataById(1);
        JSONObject o = convert(webData);
        return o.toJSONString();
    }

    /**
     * 分页查询webData
     *
     * @return
     */
    @RequestMapping(value = "/crawler/webDataList.json", method = { RequestMethod.GET,
            RequestMethod.POST }, produces = "application/json; charset=utf-8")
    @ResponseBody
    public String getWebDataByPage(String paramKey) {
        JSONObject result;
        try {
            WebDataRequest request = JSON.parseObject(paramKey, WebDataRequest.class);
            //            List<WebData> webDataList = webDataDao.queryWebDataByPage(request, request.getPageNo(),
            //                request.getPageSize());

            //            List<WebData> webDataList = webDataDao.queryWebDataByPage(null, 1, 10);

            List<WebData> webDataList = webDataDao.queryAllWebDataByPage(request);

            JSONArray array = new JSONArray();
            for (WebData w : webDataList) {
                JSONObject o = convert(w);
                array.add(o);
            }

            result = buildResult(0, "ok", array);
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

}
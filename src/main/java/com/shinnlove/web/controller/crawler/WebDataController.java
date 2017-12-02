/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package com.shinnlove.web.controller.crawler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.shinnlove.common.dao.WebDataDao;
import com.shinnlove.common.model.WebData;

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

    @RequestMapping("/crawler/webData.json")
    @ResponseBody
    public String getWebData() {
        int id = 1;
        WebData webData = webDataDao.getWebDataById(1);
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
        return object.toJSONString();
    }

}
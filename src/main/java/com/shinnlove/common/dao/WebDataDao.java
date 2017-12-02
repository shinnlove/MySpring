/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package com.shinnlove.common.dao;

import java.util.List;

import com.shinnlove.common.model.WebData;
import com.shinnlove.web.controller.request.WebDataRequest;

/**
 * 网页数据查询DAO。
 *
 * @author shinnlove.jinsheng
 * @version $Id: WebDataDao.java, v 0.1 2017-12-02 下午12:50 shinnlove.jinsheng Exp $$
 */
public interface WebDataDao {

    /**
     * 保存网页数据。
     * 
     * @param webData
     */
    void saveWebData(WebData webData);

    /**
     * 根据id查询网页数据。
     *
     * @param id
     * @return
     */
    WebData getWebDataById(int id);

    /**
     * 分页查询网页数据。
     *
     * @param request
     * @param pageNo
     * @param pageSize
     * @return
     */
    List<WebData> queryWebDataByPage(WebDataRequest request, int pageNo, int pageSize);

}
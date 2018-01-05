/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.shinnlove.web.controller.velocity;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * velocity引擎控制器。
 *
 * @author shinnlove.jinsheng
 * @version $Id: VelocityController.java, v 0.1 2018-01-05 下午11:23 shinnlove.jinsheng Exp $$
 */
@Controller
public class VelocityController {

    /**
     * 测试velocity模板配置。
     *
     * @param request  
     * @param response
     * @return
     */
    @RequestMapping(value = "/velocity", method = { RequestMethod.GET, RequestMethod.POST })
    public String getWebDataDetail(HttpServletRequest request, HttpServletResponse response, Model model) {
        model.addAttribute("city", "上海");
        return "hello";
    }

}
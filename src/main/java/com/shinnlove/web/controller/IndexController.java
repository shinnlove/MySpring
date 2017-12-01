/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package com.shinnlove.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 主页测试控制器。
 *
 * @author shinnlove.jinsheng
 * @version $Id: IndexController.java, v 0.1 2017-08-22 下午10:02 shinnlove.jinsheng Exp $$
 */
@Controller
public class IndexController {

    @RequestMapping("/home/index")
    public String index() {
        return "index";
    }

    @RequestMapping("/home/uploadPage")
    public String uploadPage() {
        return "uploadPage";
    }

}
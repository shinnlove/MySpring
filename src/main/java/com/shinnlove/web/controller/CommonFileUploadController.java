/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package com.shinnlove.web.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.shinnlove.common.dao.UserDao;
import com.shinnlove.common.dao.WebDataDao;
import com.shinnlove.common.model.User;
import com.shinnlove.common.model.WebData;

import javax.servlet.http.HttpServletRequest;

/**
 * 公共文件上传控制器。
 *
 * @author shinnlove.jinsheng
 * @version $Id: CommonFileUploadController.java, v 0.1 2017-08-22 下午11:10 shinnlove.jinsheng Exp $$
 */
@Controller
public class CommonFileUploadController {

    @Autowired
    private UserDao userDao;

    @Autowired
    private WebDataDao webDataDao;

    /**
     * 处理文件上传
     *
     * @param file 上传的文件
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/home/uploadFile")
    public String upload(MultipartFile file, HttpServletRequest request, ModelMap model) {

        System.out.println("开始");
        int id = 1;
        User user = userDao.getUserById(id);
        System.out.println("1查询到的用户" + user);

        int anotherId = 2;
        User user2 = userDao.getUserById(anotherId);
        System.out.println("2查询到的用户" + user2);

        String path = request.getSession().getServletContext().getRealPath("upload");
        String fileName = file.getOriginalFilename();

        System.out.println(path);

        User newUser = new User("evelyn", "19881218", 28);
        userDao.saveUser(newUser);

        int webDataId = 1;

        WebData webData = webDataDao.getWebDataById(webDataId);
        System.out.println(webData);

        File targetFile = new File(path, fileName);
        if (!targetFile.exists()) {
            targetFile.mkdirs();
        }

        // 保存文件
        try {
            file.transferTo(targetFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        model.addAttribute("fileUrl", request.getContextPath() + "/upload/" + fileName);

        return "result";

    }

    /**
     * 处理上传文件（request转换成MultipartHttpServletRequest方式）
     * 
     * 特别注意：spring本身会将整个错误堆栈抛出来，应该设置全局的错误拦截器和错误页面。
     *
     * @param request
     * @param model
     * @return
     */
    @RequestMapping(value = "/home/multipartUpload")
    public String multipartUpload(HttpServletRequest request, ModelMap model) {
        MultipartHttpServletRequest fileRequest = (MultipartHttpServletRequest) request;
        // 多文件获取则是使用MultipartHttpServletRequest.getFiles
        List<MultipartFile> fileList = fileRequest.getFiles("pro-img");

        String path = request.getSession().getServletContext().getRealPath("upload");

        for (MultipartFile file : fileList) {
            String oneFileName = file.getOriginalFilename();
            // File并不支持autoClosable
            File ioFile = new File(path, oneFileName);
            try {
                file.transferTo(ioFile);
                model.addAttribute("fileUrl", request.getContextPath() + "/upload/" + oneFileName);
            } catch (IOException e) {
                model.addAttribute("result", false);
                model.addAttribute("msg", "文件异常，上传失败！");
            }
        }

        return "result";
    }

}
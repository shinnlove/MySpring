/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.shinnlove.common.util.template;

import java.io.StringWriter;
import java.util.Properties;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

import com.shinnlove.common.model.User;

/**
 * apache velocity模板渲染。
 *
 * @author shinnlove.jinsheng
 * @version $Id: VelocityTemplate.java, v 0.1 2018-01-01 下午12:02 shinnlove.jinsheng Exp $$
 */
public class VelocityTemplate {

    public static final String HELLO_WORLD_VM_PATH    = "helloWorld.vm";
    public static final String USER_INFO_VM_PATH      = "/Users/zhaochensheng/Downloads/userInfo.vm";
    public static final String EMAIL_TEMPLATE_VM_PATH = "/Users/zhaochensheng/Downloads/emailTemplate.vm";

    public static void main(String[] args) throws Exception {
        System.out.println(System.getProperty("user.dir"));//user.dir指定了当前的路径
        sayHelloFromVM(HELLO_WORLD_VM_PATH);
//        testUser(USER_INFO_VM_PATH);
    }

    /**
     * 简单的hello world
     *
     * @param fileVM
     * @throws Exception
     */
    public static void sayHelloFromVM(String fileVM) throws Exception {

        VelocityEngine ve = new VelocityEngine();

        // 这里不能用~的用户路径，只能直接指定绝对路径
        Properties properties = new Properties();
        properties.setProperty(ve.FILE_RESOURCE_LOADER_PATH, "/Users/zhaochensheng/Downloads");

        ve.init(properties);

        Template t = ve.getTemplate(fileVM);
        VelocityContext context = new VelocityContext();
        context.put("hello", "world!!倩倩");
        StringWriter writer = new StringWriter();
        t.merge(context, writer);
        System.out.println(writer.toString());
    }

    /**
     * test User
     *
     * @param fileVM
     * @throws Exception
     */
    public static void testUser(String fileVM) throws Exception {
        VelocityEngine ve = new VelocityEngine();
        ve.init();

        Template template = ve.getTemplate(fileVM);
        VelocityContext velocityContext = new VelocityContext();
        User user = new User();
        user.setName("hongten");
        velocityContext.put("user", user);
        StringWriter stringWriter = new StringWriter();
        template.merge(velocityContext, stringWriter);

        System.out.println(stringWriter.toString());
    }

}
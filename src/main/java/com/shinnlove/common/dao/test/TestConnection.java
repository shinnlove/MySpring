/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package com.shinnlove.common.dao.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @author shinnlove.jinsheng
 * @version $Id: TestConnection.java, v 0.1 2017-09-03 上午10:47 shinnlove.jinsheng Exp $$
 */
public class TestConnection {

    public static final String url      = "jdbc:mysql://127.0.0.1/springdemo";
    public static final String name     = "com.mysql.jdbc.Driver";
    public static final String user     = "root";
    public static final String password = "";

    public static void main(String[] args) {
        System.out.println("hurui");

        String sql = "select * from user limit 0, 10";

        try {
            Class.forName(name);//指定连接类型
            Connection conn = DriverManager.getConnection(url, user, password);//获取连接
            PreparedStatement pst = conn.prepareStatement(sql);//准备执行语句

            ResultSet result = pst.executeQuery();

            while (result.next()) {
                String a = result.getString(1);
                String b = result.getString(2);
                String c = result.getString(3);
                String d = result.getString(4);
                System.out.println(a + "\t" + b + "\t" + c + "\t" + d);
            }//显示数据
            result.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
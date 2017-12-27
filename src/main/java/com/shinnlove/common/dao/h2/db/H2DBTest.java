/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package com.shinnlove.common.dao.h2.db;

import java.sql.*;

/**
 * H2数据库测试。
 *
 * @author shinnlove.jinsheng
 * @version $Id: H2DBTest.java, v 0.1 2017-12-26 下午8:55 shinnlove.jinsheng Exp $$
 */
public class H2DBTest {

    public static void main(String[] args) {

        try {
            Class.forName("org.h2.Driver");
            Connection conn = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
            // add application code here
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM user");
            while (rs.next()) {
                System.out.println(rs.getInt("id") + "," + rs.getString("name"));
            }
            conn.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
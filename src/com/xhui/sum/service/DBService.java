package com.xhui.sum.service;

import com.xhui.sum.bean.UserBean;

import java.sql.*;

public class DBService {
    // 数据库的用户名与密码，需要根据自己的设置
    private static final String USER = "root";
    private static final String PASS = "root";
    // JDBC 驱动名及数据库 URL
    private static final String DB_URL = "jdbc:mysql://localhost:3306/sum?useUnicode=true&characterEncoding=utf-8&serverTimezone=GMT";
    private static final String DB_DRIVER = "com.mysql.jdbc.Driver";
    private static DBService service;

    public static DBService getService() {
        return new DBService();
    }

    private Connection conn = null;

    private DBService() {
        // 打开一个连接
        try {
            Class.forName(DB_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public UserBean getUserBean(String acc) {

        // 执行 SQL 查询
        Statement stmt = null;
        UserBean userBean = null;
        try {
            stmt = conn.createStatement();
            String sql;

            sql = "select * from user_info where account = '" + acc + "'";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {

                // 通过字段检索
                long id = rs.getLong("id");
                String account = rs.getString("account");
                String password = rs.getString("password");
                String nickname = rs.getString("nickname");
                userBean = new UserBean();
                userBean.setId(id);
                userBean.setAccount(account);
                userBean.setNickname(nickname);
                userBean.setPassword(password);
            }

            // 完成后关闭
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 最后是用于关闭资源的块
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
                se2.printStackTrace();
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        return userBean;
    }

    public boolean putUserBean(String account, String password) {
        // 执行 SQL 查询
        Statement stmt = null;
        boolean rs;
        try {
            stmt = conn.createStatement();
            String sql = "insert into user_info (account, password, nickname) values ('"
                    + account + "', '" + password + "', '" + "昵称" + account + "')";
            stmt.executeUpdate(sql);
            rs = true;
            // 完成后关闭
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
            rs = false;
        } finally {
            // 最后是用于关闭资源的块
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
                se2.printStackTrace();
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        return rs;
    }

    public boolean updateUser(String account, String key, String value) {
        // 执行 SQL 查询
        Statement stmt = null;
        boolean rs;
        try {
            stmt = conn.createStatement();
            String sql = "update user_info set " + key + " = '" + value + "' where account = '" + account + "' ";
            stmt.executeUpdate(sql);
            rs = true;
            // 完成后关闭
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
            rs = false;
        } finally {
            // 最后是用于关闭资源的块
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
                se2.printStackTrace();
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        return rs;
    }
}

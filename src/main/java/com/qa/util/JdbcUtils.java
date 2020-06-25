package com.qa.util;

/**
 * @ Motto：No pains, no gains！
 * @ Project：youxueketang
 * @ class：JdbcOpration
 * @ Author：duzhengjun
 * @ dateTime：2020/6/7 11:16
 */

import java.sql.*;

/**
 * 数据库连接常用类
 *
 */
public class JdbcUtils {
    /**
     * 进行数据库连接，并返回连接对象
     * @return 数据库连接对象
     * @throws Exception
     */
    public static Connection getConnection() throws Exception {
        String url = "jdbc:mysql:///数据库名?characterEncoding=utf8&useSSL=false";
        String username = "用户名";
        String password = "密码";
        String driver = "com.mysql.jdbc.Driver";
        Class.forName(driver); // 将数据库连接驱动driver加载到内存中
        return DriverManager.getConnection(url, username, password); // 返回连接对象
    }
    /**
     * 关闭数据库连接的静态方法
     * @param conn 需要关闭的连接对象
     * @param stmt 需要关闭的语句对象
     * @param rs 需要关闭的查询结果对象
     */
    public static void close(Connection conn, Statement stmt, ResultSet rs) {
        if(rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(conn!=null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}

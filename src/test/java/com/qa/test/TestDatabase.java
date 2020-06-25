package com.qa.test;

import java.sql.*;

/**
 * @ Motto：No pains, no gains！
 * @ Project：youxueketang
 * @ class：TestDatabase
 * @ Author：duzhengjun
 * @ dateTime：2020/6/4 21:16
 */
public class TestDatabase {
    public static void main(String[] args) {

        Connection con;
        String driver="com.mysql.jdbc.Driver";
        String url="jdbc:mysql://localhost:3306/test?&useSSL=false&serverTimezone=UTC";
        String user="root";
        String password="940927";
        try {
            //注册JDBC驱动程序
            Class.forName(driver);
            //建立连接
            con = DriverManager.getConnection(url, user, password);
            if (!con.isClosed()) {
                System.out.println("数据库连接成功");
            }
            String sql ="select * from score";
            PreparedStatement preparedStatement=con.prepareStatement(sql);
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                System.out.println(resultSet.getString("Degree"));
            }
            con.close();
        } catch (ClassNotFoundException e) {
            System.out.println("数据库驱动没有安装");

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("数据库连接失败");
        }
    }
}


//
//
//package com.qa.test;
//
//        import java.sql.Connection;
//        import java.sql.DriverManager;
//        import java.sql.PreparedStatement;
//        import java.sql.SQLException;
//
///**
// * @ Motto：No pains, no gains！
// * @ Project：youxueketang
// * @ class：Haha
// * @ Author：duzhengjun
// * @ dateTime：2020/6/4 21:30
// */
//public class Haha {
//    public static void main(String[] args) throws ClassNotFoundException, SQLException {
//        //注册数据库驱动
//        Class.forName("com.mysql.jdbc.Driver");
//        //获取数据库连接（里面内容依次是："jdbc:mysql://主机名:端口号/数据库名","用户名","登录密码"）
//        Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test?useUnicode=true&characterEncoding=utf8","root","940927");
//        //需要执行的SQL语句（?是占位符，代表一个参数）
//        String sql = "insert into xiaodu(id,name) values(?,?)";
//        //获取预处理对象，并依次给参数赋值
//        PreparedStatement statement = connection.prepareCall(sql);
//        statement.setInt(1,114); //数据库字段类型是int，就是setInt；1代表第一个参数
//        statement.setString(2,"d的");    //数据库字段类型是String，就是setString；2代表第二个参数
//
//        //执行sql语句（执行了几条记录，就返回几）
//        int i = statement.executeUpdate();
//        System.out.println("总共执行了"+i+"条记录");
//        //关闭jdbc连接
//        statement.close();
//        connection.close();
//    }
//}

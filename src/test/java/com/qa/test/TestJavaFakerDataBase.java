package com.qa.test;

import com.github.javafaker.Faker;

import java.sql.*;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Random;

/**
 * @ Motto：No pains, no gains！
 * @ Project：youxueketang
 * @ class：TestJavaFakerDataBase
 * @ Author：duzhengjun
 * @ dateTime：2020/6/6 18:01
 */
public class TestJavaFakerDataBase {


    /**
     * 通过JavaFaker构造测试数据
     */
    static Faker faker = new Faker(Locale.CHINA);

    /**
     * 连接MySQL数据库
     */
    static Connection con;  //声明Connection对象
    static PreparedStatement ps;    //声明PreparedStatement对象
    static ResultSet res;    //声明ResultSet对象
    public Connection getConnection() {
        try {
            //注册JDBC驱动程序
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("数据库驱动加载成功");
            //通过访问数据库URL获取数据库连接对象，以此建立连接
            con = DriverManager.getConnection("jdbc:mysql://192.168.46.36:3306/test?useUnicode=true&characterEncoding=utf8", "dzj", "dzj");
            System.out.println("数据库连接成功");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("数据库驱动未安装或驱动版本较低");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("数据库连接失败");
        }
        return con;
    }

    public static void main(String[] args) throws SQLException {
        TestJavaFakerDataBase jd = new TestJavaFakerDataBase();//创建本类对象
        con = jd.getConnection();//调用连接数据库的方法
        try {
//            //查询数据表employee中的数据
//            ps = con.prepareStatement("select * from employee");
//            res = ps.executeQuery(); //执行查询语句
//            System.out.println("执行插入前数据");
//            //遍历查询结果集
//            while (res.next()) {
//                String first_name = res.getString("first_name");
//                String last_name = res.getString("last_name");
//                int age = res.getInt(3);
//                String sex = res.getString("sex");
//                Float income = res.getFloat(5);
//
//                System.out.print("姓名"+last_name+first_name+" ");
//                System.out.print("年龄"+age+" ");
//                if (sex==null) {
//                    System.out.print("性别未填写");
//                } else {
//                    System.out.print("性别"+sex+" ");
//                }
//                System.out.println("收入"+income);
//
//            }
            //向数据表employee中动态添加列值
            ps = con.prepareStatement(
                    "insert into employee(first_name,last_name,age,sex,income) " +
                            "values(?,?,?,?,?)"
            );
            //添加数据

            for (int i=1;i<=1000;i++) {

                String abc = faker.file().extension();

                String first_name = faker.name().firstName();
                String last_name = faker.name().lastName();
                Number age = faker.number().numberBetween(7,12);
                List<String> sex = Arrays.asList("女","男");
                Random random = new Random();
                int sex_index = random.nextInt(sex.size());
                Double income = faker.number().randomDouble(1,0,100000);

                ps.setString(1,first_name);
                ps.setString(2,last_name);
                ps.setString(3, String.valueOf(age));
                ps.setString(4, sex.get(sex_index));
                ps.setString(5, String.valueOf(income));

                ps.executeUpdate(); //执行插入语句
                System.out.println("employee表已插入"+i+"条数据");
            }   return;

        }  catch (Exception e) {
            e.printStackTrace();
        } finally {
            con.close();    //关闭数据库连接
            ps.close();
            res.close();

            System.out.println("数据库连接已断开！");
        }
    }

}

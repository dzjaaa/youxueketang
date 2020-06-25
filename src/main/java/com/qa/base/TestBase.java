package com.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * @ Motto：No pains, no gains！
 * @ Project：youxueketang
 * @ class：TestBase
 * @ Author：duzhengjun
 * @ dateTime：2020/6/7 08:39
 * 本类作为所有接口请求测试的父类，都需要继承这个父类。写一个构造方法，实现加载读取properties文件
 */

public class TestBase {
    public Properties prop;
    public int RESPNSE_STATUS_CODE_200 = 200;
    public int RESPNSE_STATUS_CODE_201 = 201;
    public int RESPNSE_STATUS_CODE_404 = 404;
    public int RESPNSE_STATUS_CODE_500 = 500;

    //把加载配置文件的代码写在空参构造函数里，好处就是，每初始化这个类的对象就会执行构造函数的代码，即执行读取配置文件这么一个作用
    public TestBase() {
        try {
            prop = new Properties();
            FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+
                    "/src/main/java/com/qa/config/config.properties");
            prop.load(fis);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //main函数主要是为了检测user.dir目录是否正确，执行结果：/Users/duzhengjun/IdeaProjects/youxueketang 正是当前项目的目录
    public static void main(String[] args) {
        System.out.println(System.getProperty("user.dir"));
    }
}

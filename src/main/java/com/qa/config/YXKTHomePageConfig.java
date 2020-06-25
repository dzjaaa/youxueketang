package com.qa.config;

import java.util.ResourceBundle;

/**
 * @ Motto：No pains, no gains！
 * @ Project：youxueketang
 * @ class：
 * @ Author：duzhengjun
 * @ dateTime：2020/5/1 14:53
 */
public class YXKTHomePageConfig {
    public static final ResourceBundle rb = ResourceBundle.getBundle("YXKTHomePage");
    public static final String DRIVERTYPE = rb.getString("driverType");    //确认浏览器类型
    public static final long SLEEP = Long.parseLong(rb.getString("sleep"));             //休眠时间
    public static final String HOMEURL = rb.getString("homeUrl");    //优学派智慧教育首页
    public static final String LOGINBUTTON = rb.getString("loginButton");   //登录button
    public static final String USERNAMETEXT =rb.getString("userNameText");              //定位用户名输入框
    public static final String USERNAME =rb.getString("userName");                      //输入账号/手机号
    public static final String PASSWORDTEXT =rb.getString("passWordText");              //定位密码输入框
    public static final String PASSWORD =rb.getString("passWord");                      //输入密码
    public static final String LOGINBUTTON2 = rb.getString("loginButton2");               //定位登录button
    public static final String HEAD = rb.getString("head");                             //定位头像/名称/身份
    public static final String SWITCH = rb.getString("switch");                          //定位点击切换
    public static final String HYYX = rb.getString("hyyx");     //定位切换至荷叶一小
//    public static final String CLOSEICON = rb.getString("closeIcon");   //点击关闭右侧个人中心

}

package com.qa.page;

import com.qa.config.YXKTHomePageConfig;
import com.qa.util.Page;

/**
 * @ Motto：No pains, no gains！
 * @ Project：youxueketang
 * @ class：优学派主页
 * @ Author：duzhengjun
 * @ dateTime：2020/5/1 11:57
 */
public class YXKTHomePage {
    Page page = new Page(YXKTHomePageConfig.DRIVERTYPE);

    //启动浏览器并进入登录页
    public void enterLoginPage(){
        //输入优学派智慧教育首页地址
        page.geturl(YXKTHomePageConfig.HOMEURL);

        //休眠
        page.pause(300);

        //窗口最大化
        page.windowmax();

        //点击首页登录button
        page.click(YXKTHomePageConfig.LOGINBUTTON);

        //休眠
        page.pause(500);

        //切换窗口(获取新窗口句柄，操作该页面下的元素)
        page.gethandle();

        //休眠
        page.pause(500);

    }

    //登录用户账户
    public void login(){
        //输入账号/手机号
        page.sendKey(YXKTHomePageConfig.USERNAMETEXT,YXKTHomePageConfig.USERNAME);

        //输入密码
        page.sendKey(YXKTHomePageConfig.PASSWORDTEXT,YXKTHomePageConfig.PASSWORD);

        //点击登录
        page.click(YXKTHomePageConfig.LOGINBUTTON2);

        //休眠
        page.pause(YXKTHomePageConfig.SLEEP);
    }

    //切换身份
    public void switchIdentity(){
        //点击头像/名称/身份以准备切换身份
        page.click(YXKTHomePageConfig.HEAD);

        //休眠
        page.pause(YXKTHomePageConfig.SLEEP);

        //点击切换
        page.click(YXKTHomePageConfig.SWITCH);
        page.pause(YXKTHomePageConfig.SLEEP);
        page.click(YXKTHomePageConfig.HYYX);

    }

}

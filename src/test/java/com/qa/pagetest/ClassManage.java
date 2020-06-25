package com.qa.pagetest;

import com.qa.page.YXKTHomePage;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * @ Motto：No pains, no gains！
 * @ Project：youxueketang
 * @ class：
 * @ Author：duzhengjun
 * @ dateTime：2020/5/1 15:23
 */
public class ClassManage {
    YXKTHomePage yxp =new YXKTHomePage();

    @BeforeTest
    //打开浏览器进入登录页并登录成功
    public void switchIdentity(){
        yxp.enterLoginPage();   //进入到登录页
        System.out.println("===========已经进入到登录页==========");
        yxp.login();    //用户登录
        System.out.println("===========用户登录成功==========");
        yxp.switchIdentity();   //切换身份至荷叶一小
        System.out.println("===========用户身份已切换至荷叶一小=======");
    }



    @Test
    public void addStudent(){
        System.out.println("ss");
    }

}

package com.qa.util;

import org.openqa.selenium.JavascriptExecutor;

/**
 * @ Motto：No pains, no gains！
 * @ Project：youxueketang
 * @ class：元素操作
 * @ Author：duzhengjun
 * @ dateTime：2020/5/1 11:49
 */
public class ElementUtils extends ElementLocation{
    public ElementUtils(){
        super();
    }

    public ElementUtils(String driverType) {
        super(driverType);
    }

    //模拟用户点击
    public void click (String xpath){
        xPath(xpath).click();
    }

    //模拟用户输入
    public void sendKey (String xpath,String text){
        xPath(xpath).sendKeys(text);
    }

    //进入框架
    public void frame (String xpath){
        driver.switchTo().frame(xPath(xpath));
    }

    //退出框架
    public void exitframe (){
        driver.switchTo().defaultContent();
    }

    //JS
    public void JS(String js){
        JavascriptExecutor jjs = (JavascriptExecutor) driver;
        jjs.executeScript(js);
    }

    //清除文字
    public void clear(String xpath){
        xPath(xpath).clear();
    }

    //点击提交
    public void submit(String xpath){
        xPath(xpath).submit();
    }
}

package com.qa.util;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

/**
 * @ Motto：No pains, no gains！
 * @ Project：youxueketang
 * @ class：启动浏览器
 * @ Author：duzhengjun
 * @ dateTime：2020/5/1 11:32
 */
public class BrowserLaunch {
    WebDriver driver;
    public BrowserLaunch(){

    }
    public BrowserLaunch(String driverType){
        chooseBrowser(driverType);
    }


    public void chooseBrowser(String driverType){
        int d = Integer.parseInt(driverType);
        switch (d){
            case 1:lanchChrome();
                break;
            case 2:lanchFirefox();
                break;
            case 3:lanchIE();
                break;
        }
    }

    public WebDriver lanchChrome(){
        System.out.println("正在启动谷歌浏览器");
        driver = new ChromeDriver();
        System.out.println("启动谷歌浏览器成功");
        return driver;
    }

    public WebDriver lanchFirefox(){
        System.out.println("正在启动火狐浏览器");
        driver = new FirefoxDriver();
        System.out.println("启动火狐浏览器成功");
        return driver;
    }

    public WebDriver lanchIE(){
        System.out.println("正在启动IE浏览器");
        System.setProperty("webdriver.ie.driver","C:\\Program Files (x86)\\Internet Explorer\\iexplore.exe");
        driver = new InternetExplorerDriver();
        System.out.println("启动IE浏览器成功");
        return driver;
    }
}

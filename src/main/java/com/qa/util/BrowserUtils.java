package com.qa.util;

import static org.apache.xmlbeans.XmlBeans.getTitle;

/**
 * @ Motto：No pains, no gains！
 * @ Project：youxueketang
 * @ class：浏览器操作
 * @ Author：duzhengjun
 * @ dateTime：2020/5/1 11:42
 */
public class BrowserUtils extends BrowserLaunch{
    public BrowserUtils(){
        super();
    }
    public BrowserUtils(String driverType) {
        super(driverType);
    }

    public void closeBrowser(){
        System.out.println("关闭当前窗口");
        driver.close();
    }

    public void quitBrowser(){
        System.out.println("关闭浏览器");
        driver.quit();
    }

    //休眠
    public void pause(long millis){
        if(millis>0){
            try {
                Thread.sleep(millis);
                System.out.println("休眠"+millis+"毫秒");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }else {
            System.out.println("休眠时间须大于0");
        }

    }

    //窗口最大化
    public void windowmax(){
        driver.manage().window().maximize();
        System.out.println("窗口最大化");
    }

    //输入网址
    public void geturl(String url){
        if(url.equals("")){
            System.out.println("输入不能为空，无法打开网页");
            return;
        }
        if(url.startsWith("http://") || url.startsWith("https://")){
            driver.get(url);
            if(driver.getTitle().equals("无法找到该页")){
                System.out.println("网址无效");
                return;
            }
            System.out.println("打开网页"+getTitle());
        }else {
            driver.get("http://"+url);
            if(driver.getTitle().equals("无法找到该页")){
                System.out.println("网址无效");
                return;
            }
            System.out.println("打开网页"+getTitle());
        }

    }

    //刷新当前页面
    public void refresh(){
        System.out.println("刷新");
        driver.navigate().refresh();
    }

    //浏览器后退
    public void back(){
        System.out.println("向后退");
        driver.navigate().back();
    }

    //浏览器前进
    public void forward(){
        System.out.println("向前进");
        driver.navigate().forward();
    }

    //切换窗口(获取新窗口句柄，操作该页面下的元素)
    public void gethandle(){
//        System.out.println("获得网页句柄"); //int
//        /*Set<String> WinHandels =driver.getWindowHandles();    //得到当前窗口的set集合
//        List<String> it=new ArrayList<String>(WinHandels);      //将set集合存入list对象*/
//        List<String> it= (List<String>) driver.getWindowHandles();
//        System.out.println("切换窗口啦");
//        driver.switchTo().window(it.get(i));                    // i=1 切换到弹出的新窗口
        String winHandleBefore = driver.getWindowHandle();
        for(String winHandle : driver.getWindowHandles())
        {
            if (winHandle.equals(winHandleBefore))
            {
                continue;
            }
            driver.switchTo().window(winHandle);
            break;
        }
    }
}

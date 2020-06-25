package com.qa.pagetest;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.Set;
import java.util.concurrent.TimeUnit;


/**
 * @ Motto：No pains, no gains！
 * @ Project：youxueketang
 * @ class：AddressBookTest
 * @ Author：duzhengjun
 * @ dateTime：2020/5/19 18:42
 */
public class AddressBookTest {
    //准备一个webdriver的实例
    WebDriver driver = new ChromeDriver();
    SwitchtabWorkBench workbench = new SwitchtabWorkBench();
    AddStudent addstudent = new AddStudent();
    MakeTestQuestion makeTestQuestion = new MakeTestQuestion();


    @BeforeTest
    public void logIn() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        System.setProperty("webdriver.chrome.driver","\\Tools\\chrome.exe");
        driver.get("https://www.youxueketang.com/");//进入优学课堂主页
        System.out.println("已经成功打开浏览器并进入优学课堂首页");
        driver.manage().window().maximize();//浏览器最大化

        driver.findElement(By.xpath("//*[@id=\"yxp_website\"]/header/div/div/div[2]")).click();//点击右上角登录button进入登录页
        Thread.sleep(1000);//线程休眠1000ms

        /**
         * 因为登录页是新开的一个标签页，需要切换窗口
         */
        //获取当前窗口句柄（此时是获得https://www.youxueketang.com/页面的句柄）
        String currentHandle = driver.getWindowHandle();
        System.out.println("优学派智慧教育主页句柄是："+currentHandle);
        //获得所有的窗口句柄，如果不是currentHandle,则进入该窗口
        Set<String> windowHandles = driver.getWindowHandles();//得到当前窗口的set集合
        for (String windowHandle : windowHandles) {
            if (!currentHandle.equals(windowHandle) ) {
                //进入到当前窗口
                driver.switchTo().window(windowHandle);
            }
        }
        System.out.println("切换窗口成功");
        Thread.sleep(2000);

        try {
            driver.findElement(By.xpath("//*[@id=\"pane-0\"]/form/div[1]/div/div/input")).sendKeys("13002840927");//输入用户名
            driver.findElement(By.xpath("//*[@id=\"pane-0\"]/form/div[2]/div/div/input")).sendKeys("dzj111");//输入用户密码
            driver.findElement(By.xpath("//*[@id=\"pane-0\"]/form/div[3]/div/button")).click();//点击登录按钮
            System.out.println("用户已成功登录");
            Thread.sleep(2000);
        }catch (Exception e){
            System.out.println("服务器正在构建，请稍后再试");
        }

        driver.findElement(By.xpath("//*[@id=\"yxpProtal\"]/div/div[1]/div[1]/div/div[1]/div[2]/div[1]/div/p")).click();//点击用户头像打开个人中心以切换身份
        Thread.sleep(1000);//线程休眠1000ms
        driver.findElement(By.xpath(".//div[@class=\"nav-ident-tag\"]")).click();//点击切换
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@class=\"el-select-dropdown el-popper ident-popper\"]/div[1]/div[1]/ul/li[1]/span")).click();//选择荷叶一小
        Thread.sleep(1000);
        System.out.println("用户单位已切换至荷叶一小");

    }

    @Test
    public void addUser() throws InterruptedException {


        driver.findElement(By.xpath("//*[@id=\"yxpProtal\"]/div/div[1]/div[1]/div/div[2]/div[2]/div/div[1]/div/ul/li[9]/div[1]")).click();//点击进入通讯录
        System.out.println("用户已进入通讯录模块");
        Thread.sleep(1500);//线程休眠1000ms

        workbench.switchWorkBench();    //切回我的空间
        makeTestQuestion.makeTestQuestion();    //制作一道单选试题

        driver.findElement(By.xpath("//*[@id=\"yxpProtal\"]/div/div[1]/div[1]/div/div[2]/div[2]/div/div[1]/div/ul/li[11]/div[1]")).click();//点击进入通讯录
        System.out.println("用户已进入通讯录模块");
        Thread.sleep(1500);//线程休眠1000ms

        driver.findElement(By.xpath("//*[@id=\"yxp_user\"]/div/div[1]/div/div[2]/div[2]/div[2]/div[6]/div[3]/div[2]/button[1]")).click();//点击添加用户
//        driver.switchTo().frame("//*[@id=\"blockbyte-bs-sidebar\"]");
        Thread.sleep(1500);
        driver.findElement(By.xpath("//div[@class=\"crop-upload\"]/div[1]")).click();//点击头像准备上传
        Thread.sleep(1000);

        driver.findElement(By.xpath("//div[@class=\"vicp-drop-area\"]/input[1]")).sendKeys("/Users/duzhengjun/Pictures/喜欢/头像9.jpeg");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[@class=\"vicp-step2\"]/div[2]/button[2]")).click();//点击保存
        System.out.println("上传头像成功");
        Thread.sleep(3000);

        driver.findElement(By.xpath("//div[@class=\"el-input el-input--medium\"]/input[1]")).sendKeys("新增通讯录用户1");//写入姓名
        driver.findElement(By.xpath("//div[@class=\"el-input el-input--medium el-input-group el-input-group--prepend\"]/input[1]")).sendKeys("13002820927");//写入手机号码
        driver.findElement(By.xpath("//div[@class=\"footer\"]/button")).click();//点击取消
        System.out.println("取消添加用户");

        workbench.switchWorkBench();//切回我的空间

        /**
         * 三年级七班添加一个名为张三的学生
         */
        addstudent.addStudent();

        driver.findElement(By.xpath("//*[@id=\"yxpClass\"]/div/div[1]/div/div[1]/div[2]/div[2]/div/p")).click();//点击用户头像打开个人中心
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"pane-baseInfo\"]/div/div/form/div[1]/div/div/div/img")).click();//点击头像准备上传
        Thread.sleep(1000);
//        driver.findElement(By.xpath("//div[@class=\"vicp-drop-area\"]")).click();//点击上传
//        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[@class=\"vicp-drop-area\"]/input[1]")).sendKeys("/Users/duzhengjun/Pictures/喜欢/头像9.jpeg");
        Thread.sleep(3000);

        driver.findElement(By.xpath("//div[@class=\"vicp-step2\"]/div[2]/button[2]")).click();//点击保存
        System.out.println("上传头像成功");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"pane-baseInfo\"]/div/div/form/div[10]/div/button[2]/span")).click();
        System.out.println("更换头像成功");
        Thread.sleep(2000);
        driver.quit();
        System.out.println("测试结束");

    }


    //切回工作台我的空间
    class SwitchtabWorkBench {
        public void switchWorkBench () throws InterruptedException {
            try {
                driver.findElement(By.xpath("//*[@id=\"yxp_user\"]/div/div[1]/div/div[1]/div[1]/i")).click();//点击展开工作台
                Thread.sleep(1000);
                driver.findElement(By.xpath("//div[@class=\"el-scrollbar__view left-dia-box\"]/div")).click();//点击回到我的空间
                System.out.println("切换非首页的我的空间");
            }   catch (Exception e){
                driver.findElement(By.xpath("//*[@id=\"yxpProtal\"]/div/div[1]/div[1]/div/div[1]/div[1]/i")).click();//点击展开工作台
                Thread.sleep(1000);
                driver.findElement(By.xpath("//div[@class=\"el-scrollbar__view left-dia-box\"]/div")).click();//点击回到我的空间
                System.out.println("切换首页的我的空间");
            }
        }
    }

    //添加学生(三年级七班添加学生)
    class AddStudent {
            public void addStudent () throws InterruptedException {
                /**
                 * 用户已经进入工作台
                 **/

                driver.findElement(By.xpath("//*[@id=\"yxpProtal\"]/div/div[1]/div[1]/div/div[2]/div[2]/div/div[1]/div/ul/li[4]/div[1]/img")).click();//点击进入班级管理
                Thread.sleep(3000);
                driver.findElement(By.xpath("//*[@id=\"yxpClass\"]/div/div[1]/div/div[2]/div[2]/div/div[4]/div/div[3]/table/tbody/tr/td[8]/div/span[2]")).click();//点击进入三年级-七班
                Thread.sleep(2000);
                driver.findElement(By.xpath("//*[@id=\"tab-studentList\"]")).click();//切换到学生列表
                Thread.sleep(2000);
                driver.findElement(By.xpath("//*[@id=\"pane-studentList\"]/div/div[1]/div[1]/button[1]/span")).click();//点击添加button
                Thread.sleep(2000);
                driver.findElement(By.xpath("//div[@class=\"el-input el-input--medium\"]/input[1]")).click();//点击学生姓名输入框
                driver.findElement(By.xpath("//div[@class=\"el-input el-input--medium\"]/input[1]")).sendKeys("张三");//输入学生姓名
                Thread.sleep(2000);
                driver.findElement(By.xpath("//span[@class=\"el-tooltip el-icon-close item\"]")).click();//点击关闭无用手机号码栏
                driver.findElement(By.xpath("//div[@class=\"btn-group\"]/button[2]")).click();//点击提交学生创建信息
                Thread.sleep(2500);
            }
    }

    //我的资源制作一道单选题
    class MakeTestQuestion {
        public void makeTestQuestion() throws InterruptedException {
            /**
             * 用户已进入工作台
             */
            driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
            driver.findElement(By.xpath("//*[@id=\"yxpProtal\"]/div/div[1]/div[1]/div/div[2]/div[2]/div/div[1]/div/ul/li[2]/div[1]/img")).click();  //点击进入我的资源
            Thread.sleep(1000);
            driver.findElement(By.xpath("//*[@id=\"yxpExercise\"]/div/div[1]/div/div[2]/div[1]/ul/li[2]/div")).click();    //点击展开我的试题
            driver.findElement(By.xpath("//*[@id=\"yxpExercise\"]/div/div[1]/div/div[2]/div[1]/ul/li[2]/ul/li[1]/span")).click();   //点击我的试题
            Thread.sleep(2000);
            //选择单位-荷叶一小
            driver.findElement(By.xpath("//*[@id=\"yxpExercise\"]/div/div[1]/div/div[2]/div[2]/div[2]/div/div[2]/div[1]/div[1]/div/input")).sendKeys("荷叶一小");

            //选择学段-小学
            driver.findElement(By.xpath("//*[@id=\"yxpExercise\"]/div/div[1]/div/div[2]/div[2]/div[2]/div/div[2]/div[1]/div[2]/div/input")).sendKeys("小学");

            //选择学科-语文
            driver.findElement(By.xpath("//*[@id=\"yxpExercise\"]/div/div[1]/div/div[2]/div[2]/div[2]/div/div[2]/div[1]/div[3]/div[1]/input")).sendKeys("数学");
            Thread.sleep(2000);

            driver.findElement(By.xpath("//*[@id=\"yxpExercise\"]/div/div[1]/div/div[2]/div[2]/div[2]/div/div[2]/div[1]/button/span")).click(); //点击添加试题button

            //选择题型-单选题
            driver.findElement(By.xpath("//*[@id=\"yxpExercise\"]/div/div[1]/div/div[2]/div[2]/div[2]/div/div[2]/div[1]/div/input")).sendKeys("单选题");

            //选择题模-单选题模板
            driver.findElement(By.xpath("//*[@id=\"yxpExercise\"]/div/div[1]/div/div[2]/div[2]/div[2]/div/div[2]/div[2]/div/input")).sendKeys("单选题模板");


            /**
             * 编辑试题信息
             */
            driver.findElement(By.xpath("//*[@id=\"yxpExercise\"]/div/div[1]/div/div[2]/div[2]/div[2]/div/div[3]/div/div[2]/div[1]/div[3]")).click();   //点击题干输入框
            Thread.sleep(1000);
            driver.findElement(By.xpath("//*[@id=\"yxpExercise\"]/div/div[1]/div/div[2]/div[2]/div[2]/div/div[3]/div/div[2]/div[1]/div[3]")).sendKeys("测试单选题-题干，正确答案是A");   //题干输入文字
            driver.findElement(By.xpath("//*[@id=\"yxpExercise\"]/div/div[1]/div/div[2]/div[2]/div[2]/div/div[3]/div/div[2]/div[1]/div[3]")).sendKeys(Keys.ENTER);

            driver.findElement(By.xpath("//*[@id=\"yxpExercise\"]/div/div[1]/div/div[2]/div[2]/div[2]/div/div[3]/div/div[1]/div[1]/button[5]/span/i")).click(); //点击图片准备上传
            //使用方法uploadFile实现图片插入
            FileUpload fl = new FileUpload();
            System.out.println("准备上传图片");
            fl.uploadFile("/Users/duzhengjun/Pictures/壁纸/天气之子电影海报4k壁纸3840x2160_彼岸图网.jpg");
            Thread.sleep(6000);
            //答案A：~
            driver.findElement(By.xpath("//*[@id=\"yxpExercise\"]/div/div[1]/div/div[2]/div[2]/div[2]/div/div[3]/div/div[2]/div[1]/div[5]/div[1]/div[2]/div")).sendKeys("~");
            //答案B：？
            driver.findElement(By.xpath("//*[@id=\"yxpExercise\"]/div/div[1]/div/div[2]/div[2]/div[2]/div/div[3]/div/div[2]/div[1]/div[5]/div[2]/div[2]/div")).sendKeys("?");
            //答案C：$
            driver.findElement(By.xpath("//*[@id=\"yxpExercise\"]/div/div[1]/div/div[2]/div[2]/div[2]/div/div[3]/div/div[2]/div[1]/div[5]/div[3]/div[2]/div")).sendKeys("$");
            //答案D：==
            driver.findElement(By.xpath("//*[@id=\"yxpExercise\"]/div/div[1]/div/div[2]/div[2]/div[2]/div/div[3]/div/div[2]/div[1]/div[5]/div[4]/div[2]/div")).sendKeys("==");
            Thread.sleep(2000);
            //选择答案A
            driver.findElement(By.xpath("//*[@id=\"yxpExercise\"]/div/div[1]/div/div[2]/div[2]/div[2]/div/div[3]/div/div[2]/div[1]/div[7]/div/label[1]/span[1]/span")).click();
            Thread.sleep(2000);

            //提示内容输入：这是一道单选题
            driver.findElement(By.xpath("//*[@id=\"yxpExercise\"]/div/div[1]/div/div[2]/div[2]/div[2]/div/div[3]/div/div[2]/div[1]/div[9]")).sendKeys("这是一道单选题哦");
            //解析内容输入：请认真思考后解答
            driver.findElement(By.xpath("//*[@id=\"yxpExercise\"]/div/div[1]/div/div[2]/div[2]/div[2]/div/div[3]/div/div[2]/div[1]/div[11]")).sendKeys("请认真思考后解答");
            //点评内容输入：这里点评放个空格
            driver.findElement(By.xpath("//*[@id=\"yxpExercise\"]/div/div[1]/div/div[2]/div[2]/div[2]/div/div[3]/div/div[2]/div[1]/div[13]")).sendKeys("这里点评放个空格");
            Thread.sleep(1500);


//            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();",);

//            //点击设置教材信息
//            driver.findElement(By.xpath("//*[@id=\"yxpExercise\"]/div/div[1]/div/div[2]/div[2]/div[2]/div/div[3]/div/div[2]/div[2]/div/div[2]/div[1]/span")).click();
//            //点击切换教材
//            driver.findElement(By.xpath("/html/body/div[17]/div/div[2]/div/div[3]/span")).click();
//            //选择部编版16版
//            driver.findElement(By.xpath("//*[@id=\"dropdown-menu-400\"]/div[2]/div[1]/div/div/div[1]/div[2]/div[1]/div[2]/div/div[1]/div/div/div/div[2]/div[1]/p")).click();
//            //选择第一章 我上学了
//            driver.findElement(By.xpath("//*[@id=\"pane-0\"]/div/div[1]/div/div/div/div[1]/div[2]/div[1]/div[1]/label/span/span")).click();
//            //点击确认
//            driver.findElement(By.xpath("/html/body/div[20]/div/div[3]/div/button[2]")).click();
//
//            //点击右上角保存试题button
//            driver.findElement(By.xpath("//*[@id=\"yxpExercise\"]/div/div[1]/div/div[2]/div[2]/div[2]/div/div[3]/div/div[1]/div[2]/button[2]/span/i")).click();


        }
    }

    //上传文件
    class FileUpload {
        //这个方法供上传文件用（Mac），Windows可以使用第三方工具AutoIt来处理文件上传
        public void uploadFile(String filepath){
            //File Need to be imported
            File file = new File(filepath);
            StringSelection stringSelection= new StringSelection(file.getAbsolutePath());
            //Copy to clipboard
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);

            Robot robot = null;
            try {
                robot = new Robot();
            } catch (AWTException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            ////// Cmd + Tab is needed since it launches a Java app and the browser looses focus

            robot.keyPress(KeyEvent.VK_META);

            robot.keyPress(KeyEvent.VK_TAB);

            robot.keyRelease(KeyEvent.VK_META);

            robot.keyRelease(KeyEvent.VK_TAB);

            robot.delay(500);

            /////Open Goto window shortkey is commmand +shift + G, adpate to MAC///////

            robot.keyPress(KeyEvent.VK_META);

            robot.keyPress(KeyEvent.VK_SHIFT);

            robot.keyPress(KeyEvent.VK_G);

            robot.keyRelease(KeyEvent.VK_META);

            robot.keyRelease(KeyEvent.VK_SHIFT);

            robot.keyRelease(KeyEvent.VK_G);

            /////Paste the clipboard value

            robot.keyPress(KeyEvent.VK_META);

            robot.keyPress(KeyEvent.VK_V);

            robot.keyRelease(KeyEvent.VK_META);

            robot.keyRelease(KeyEvent.VK_V);

            ///////Press Enter key to close the Goto window and Upload window

            robot.keyPress(KeyEvent.VK_ENTER);

            robot.keyRelease(KeyEvent.VK_ENTER);


            robot.delay(2000);

            robot.keyPress(KeyEvent.VK_ENTER);

            robot.keyRelease(KeyEvent.VK_ENTER);


        }
    }

}

//        //使用方法uploadFile实现新增用户头像上传
//        FileUpload fl2 = new FileUpload();
//        System.out.println("准备上传头像");
//        fl2.uploadFile("/Users/duzhengjun/Pictures/壁纸/《睡》二次元动漫美图_彼岸图网.jpg");
//        Thread.sleep(5000);
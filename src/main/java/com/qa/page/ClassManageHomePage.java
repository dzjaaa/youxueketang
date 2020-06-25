package com.qa.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * @ Motto：No pains, no gains！
 * @ Project：youxueketang
 * @ class：
 * @ Author：duzhengjun
 * @ dateTime：2020/5/1 21:50
 */
public class ClassManageHomePage {
    WebDriver driver = new ChromeDriver();
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
}

package com.qa.util;

/**
 * @ Motto：No pains, no gains！
 * @ Project：youxueketang
 * @ class：
 * @ Author：duzhengjun
 * @ dateTime：2020/5/1 11:52
 */
public class Page extends ElementUtils {
    public Page() {
        super();
    }
    public Page(String driverType){
        super(driverType);
    }

    /*PO模型--页面对象
    一、测试策略制定：
        1.接口测试
        2.UI自动化
        3.UI自动化加接口测试(全部接口实现自动化、主流程和核心流程实现UI自动化）
        ：实现底层代码和核心流程无误、非核心流程从UI层出现错误，肯定是UI层面的问题，
        UI修复的速度低和成本高)

    二、UI自动化
    PO模型
    Page-Object-->Webdriver二次封装-->Page
        1.数据存储、读取(Excel+POI或者DB+JDBC)
        2.配置文件--a.Webdriver
                    b.元素定位配置
        3.执行--a.Webdriver
                b.TestNG(运行、断言)
                c.日志(Log4J)
        4.报告

    三、框架实现
        1.Webdriver二次封装
        2.TestNG(执行策略、断言)
        3.数据驱动(DTT)--针对不同的数据执行不同的脚本
            Excel+POI+迭代器
        4.Log4J+ReportNG
        5.Maven(拉包、项目管理)
        6.Jenkins(持续集成)

    四、测试脚本
        1.数据准备(ExcelUtils)
        2.@Test--Wevdriver
        3.各种工具

    五、框架分层
        自动化测试分层设计
        1.测试用例层--对所有的测试用例转变为测试
        2.场景封装层--对流程的测试
        3.模块封装层--对模块的测试
        4.页面封装层--对页面的测试
        5.页面层--将所有的页面转变成一个java class(属性--元素、行为--功能)
        6.框架层--PO-Page

    */
}

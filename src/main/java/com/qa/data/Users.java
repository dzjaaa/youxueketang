package com.qa.data;

/**
 * @ Motto：No pains, no gains！
 * @ Project：youxueketang
 * @ class：Users
 * @ Author：duzhengjun
 * @ dateTime：2020/6/7 11:00
 *  用户实例，每个字段对应数据库user表的每个字段
 */
public class Users {

    private String loginName;
    private String password;

    public Users() {
        super();
    }

    public Users(String loginName,String password) {
        super();
        this.loginName = loginName;
        this.password = password;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

//    @Override
//    public String toString() {
//        return "User [loginName=" + loginName + ", password=" + password + "]";
//    }

}

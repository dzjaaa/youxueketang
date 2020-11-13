package com.qa.test;

import com.qa.data.Users;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @ Motto：No pains, no gains！
 * @ Project：youxueketang
 * @ class：TestApi
 * @ Author：duzhengjun
 * @ dateTime：2020/6/7 17:46
 */

public class TestApi {

    public static void main(String[] args) throws ClassNotFoundException,IOException {

        //准备请求URL
        String url = "https://youxueketang.anoah.com/api/user/account/login";

        //准备post请求
        HttpPost post = new HttpPost(url);

        //添加请求头信息
        post.setHeader("Content-Type","application/json;charset=UTF-8");

        //准备参数 -->post请求的参数放在请求体中间
        Users user = new Users("13002840927","JjAkcJiR02+anmeXdRgaMfjduLhsH5vHNfgkad7vbtcx7QoGtNAoWGX2eavyasE3geSgHm+Qi++LvY3OVOfhFR9vxDVfhV+OYvpV4rR1/X+sjiVO9mZzcDoFtqGLK1OZrucwmrnBxrP2WX29viLg9M9KXKX/gV31n8VN2TOKyBQ=");
        List<NameValuePair> parameters = new ArrayList<>();
        parameters.add(new BasicNameValuePair("loginName","13002840927"));
        parameters.add(new BasicNameValuePair("password","ddddggbb"));
        HttpEntity requestEntity = new UrlEncodedFormEntity(parameters);
        post.setEntity(requestEntity);

        //创建一个发包客户端
        CloseableHttpClient httpClient = HttpClients.createDefault();

        //通过这个客户端进行发包，得到响应
        CloseableHttpResponse response = httpClient.execute(post);

        //获得响应信息
        HttpEntity entity = response.getEntity();
        String entityString = EntityUtils.toString(entity);
        System.out.println(entityString);

    }
}

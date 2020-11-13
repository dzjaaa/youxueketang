package com.qa.apitest;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;

/**
 * @ Motto：No pains, no gains！
 * @ Project：youxueketang
 * @ class：apiTestDemo
 * @ Author：duzhengjun
 * @ dateTime：2020/11/7 22:32
 */
public class apiTestDemo {
    @Test
    public void httpPostYXT() throws IOException {
        //创建client
        CloseableHttpClient client = HttpClients.createDefault();
        //创建 HttpPost，登录
        HttpPost post = new HttpPost("https://youxueketang.anoah.com/api/user/account/login");
        //设置请求头
        post.setHeader("content-type", "application/json;charset=UTF-8");
        //设置请求参数
        HashMap<String,Object> map=new HashMap<>();
        map.put("loginName","13002840927");
        map.put("password","oEIwMcRMCJFmijal6iPTenXPlOBjK925lG0BVwyT3rRu2VGLJ12GxDxI1ymwyx5ova6HZTbgTVxFOihj9/JR0xWT59PKBdOOotU6NlloAkAGaH9fPSSLl00wxwRrh3A0vsBvk+eVPU5lD1GrezpmCvgP5Jc13ZHg2b4oxxcuUxw=");
        JSONObject jsonObject=new JSONObject(map);
        StringEntity se=new StringEntity(jsonObject.toJSONString(), ContentType.APPLICATION_JSON);
        post.setEntity(se);
        //获取响应
        CloseableHttpResponse response = client.execute(post);
        HttpEntity entity = response.getEntity();
        String result = EntityUtils.toString(entity);
        //关闭流和连接
        EntityUtils.consume(entity);
        response.close();
        //解析result,获取jwt
        JSONObject res = JSON.parseObject(result);
        String jwt=res.getJSONObject("data").getString("jwt");
        System.out.println(jwt);



        //创建 HttpGet，获取用户信息
        HttpGet get = new HttpGet("https://youxueketang.anoah.com/api/user/account/getOrgInfo");
        //设置请求头
        get.setHeader("authorization", jwt);
        //获取响应
        CloseableHttpResponse response2 = client.execute(get);
        HttpEntity entity2 = response2.getEntity();
        String result2 = EntityUtils.toString(entity2);
        //关闭流和连接
        EntityUtils.consume(entity2);
        response2.close();
        //解析result,获取jwt
        JSONObject res2 = JSON.parseObject(result2);
        System.out.println(res2.toJSONString());
        //断言，打印 errorMsg
//        Assert.assertEquals("a","ds","获取的用户名不一致");

    }
}

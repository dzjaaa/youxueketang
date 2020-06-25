package com.qa.apitest;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.qa.base.TestBase;
import com.qa.data.Users;
import com.qa.restclient.RestClient;
import com.qa.util.TestUtil;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.junit.Test;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.util.HashMap;

/**
 * @ Motto：No pains, no gains！
 * @ Project：youxueketang
 * @ class：PostApiTest
 * @ Author：duzhengjun
 * @ dateTime：2020/6/7 10:52
 */
public class PostApiTest extends TestBase{
    TestBase testBase;
    String host;
    String url;
    RestClient restClient;
    CloseableHttpResponse closeableHttpResponse;

    @BeforeTest
    public void setUp() {
        testBase = new TestBase();
        host = prop.getProperty("HOST");
        url = host+"/api/user/account/login";
    }

    @Test
    public void postApiTest() throws ClientProtocolException, IOException {
        restClient = new RestClient();
        //准备请求头信息
        HashMap<String,String> headermap = new HashMap<String,String>();
        headermap.put("Content-Type", "application/json;charset=UTF-8");

        //对象转换成json字符串
        Users user = new Users("13002840927","WWLhA0m/hpBkHjoJRVCsMx8xvkBHlcOGOJ6t+DIMJw9gq2EtW0beb1yG6aCgMX0hwrERHv0kRN4xxFFqw5wkckKoyrzNkP6rFDypHlk1UnYIZrY2bYrL5kEOErUEnS+FIAYFk0+SrDsDE2q4yzlZoOcoBnbMQnNodwMR6doCDIM=");
        String userJsonString = JSON.toJSONString(user);
        //System.out.println(userJsonString);

        closeableHttpResponse = restClient.post(url,userJsonString,headermap);

        //验证状态码是否是200
        int statusCode = closeableHttpResponse.getStatusLine().getStatusCode();
        Assert.assertEquals(statusCode,RESPNSE_STATUS_CODE_200,"status code is not 200");

        //断言响应json内容中name和job是不是期待结果
        String responseString = EntityUtils.toString(closeableHttpResponse.getEntity());
        JSONObject responseJson = JSON.parseObject(responseString);
//        System.out.println(responseString);
        String loginName = TestUtil.getValueByJPath(responseJson,"loginName");
        String password = TestUtil.getValueByJPath(responseJson,"password");
        Assert.assertEquals(loginName,"13002840927","登录名不相同");
        Assert.assertEquals(password,"WWLhA0m/hpBkHjoJRVCsMx8xvkBHlcOGOJ6t+DIMJw9gq2EtW0beb1yG6aCgMX0hwrERHv0kRN4xxFFqw5wkckKoyrzNkP6rFDypHlk1UnYIZrY2bYrL5kEOErUEnS+FIAYFk0+SrDsDE2q4yzlZoOcoBnbMQnNodwMR6doCDIM=","密码不相同");


    }
}

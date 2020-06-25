package com.qa.apitest;

import com.qa.base.TestBase;
import com.qa.restclient.RestClient;
import org.apache.http.client.ClientProtocolException;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;

/**
 * @ Motto：No pains, no gains！
 * @ Project：youxueketang
 * @ class：GetApiTest
 * @ Author：duzhengjun
 * @ dateTime：2020/6/7 09:05
 */
public class GetApiTest extends TestBase {
    TestBase testBase;
    String host;
    String url;
    RestClient restClient;

    @BeforeClass
    public void setUp() {
        testBase = new TestBase();
        host = prop.getProperty("HOST");
        url = host+"/api/user/account/login";
    }

    @Test
    public void getAPTTest() throws ClientProtocolException, IOException {
        restClient = new RestClient();
        restClient.get(url);
    }
}

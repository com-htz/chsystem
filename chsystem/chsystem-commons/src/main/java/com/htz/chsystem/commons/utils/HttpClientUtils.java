package com.htz.chsystem.commons.utils;

import org.apache.http.HttpEntity;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.Arrays;

/**
 * HttpClient 工具类
 * <p>Title: HttpClientUtils</p>
 * <p>Description: </p>
 *
 * @author EnergyFiled
 * @version 1.0.0
 */
public class HttpClientUtils {

    public static final String GET = "get";
    public static final String POST = "post";

    public static final String REQUEST_HEADER_CONNECTION = "keep-alive";
    public static final String REQUEST_HEADER_USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/80.0.3987.122 Safari/537.36";

    /**
     * GET 请求
     * @param url 请求地址
     * @return
     */
    public static String doGet(String url){
        return createRequest(url, GET, null);
    }

    /**
     *  GET请求
     * @param url 请求地址
     * @param cookie cookie
     * @return
     */
    public static String doGet(String url, String cookie){
        return createRequest(url, GET, cookie);
    }

    /**
     *  POST 请求
     * @param url 请求地址
     * @param params 请求参数
     * @return
     */
    public static String doPost(String url, BasicNameValuePair... params){
        return createRequest(url, POST, null, params);
    }

    /**
     *  POST 请求
     * @param url 请求地址
     * @param cookie cookie
     * @param params 请求参数
     * @return
     */
    public static String doPost(String url, String cookie, BasicNameValuePair... params){
        return createRequest(url, POST, cookie, params);
    }


    /**
     * 创建请求
     * @param url 请求地址
     * @param requestMethod 请求方式
     * @param cookie cookie
     * @param params 请求参数
     * @return
     */
    private static String createRequest(String url, String requestMethod, String cookie, BasicNameValuePair... params){
        CloseableHttpClient httpClient = HttpClients.createDefault();
        String result = null;

        try {
            //请求结果
            result = null;

            //请求方式
            HttpGet httpGet = null;
            HttpPost httpPost = null;

            //响应
            CloseableHttpResponse httpResponse = null;

            //GET 请求
            if (GET.equals(requestMethod)) {
                httpGet = new HttpGet(url);
                httpGet.setHeader("Connection", REQUEST_HEADER_CONNECTION);
                httpGet.setHeader("User-Agent", REQUEST_HEADER_USER_AGENT);
                httpGet.setHeader("Cookie", cookie);

                httpResponse = httpClient.execute(httpGet);

            }

            //POST请求
            else if (POST.equals(requestMethod)) {
                httpPost = new HttpPost(url);
                httpPost.setHeader("Connection", REQUEST_HEADER_CONNECTION);
                httpPost.setHeader("User-Agent", REQUEST_HEADER_USER_AGENT);
                httpPost.setHeader("Cookie", cookie);

                //有参数传入
                if (params != null && params.length > 0){
                    httpPost.setEntity(new UrlEncodedFormEntity(Arrays.asList(params), "UTF-8"));
                }

                httpResponse = httpClient.execute(httpPost);
            }

            HttpEntity httpEntity = httpResponse.getEntity();
            result = EntityUtils.toString(httpEntity);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (httpClient != null){
                try {
                    httpClient.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
        return result;
    }
}

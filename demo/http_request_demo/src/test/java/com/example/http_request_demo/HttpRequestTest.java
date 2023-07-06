package com.example.http_request_demo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ejlchina.okhttps.*;
import com.example.http_request_demo.entity.User;
import org.assertj.core.util.DateUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author benjamin_5
 * @Description
 * @date 2023/1/30
 */
@SpringBootTest
public class HttpRequestTest {
    private static final String BASE_URL = "http://localhost:8086";

    /**
     * 简单get、post同步请求示例
     */
    @Test
    public void simpleRequestTest() {
        // 构造HTTP实例
        HTTP http = HTTP.builder()
                .baseUrl(BASE_URL)
                .addMsgConvertor(new FastjsonMsgConvertor())
                .build();
        // get同步请求
        List<User> users = http.sync("/api/list/user").get().getBody().toList(User.class);
        // post同步请求
        JSONObject users2 = http.sync("/api/list/user/json").post().getBody().toBean(JSONObject.class);
        System.out.println("get sync: " + JSON.toJSONString(users));
        System.out.println("post sync: " + users2);
        // 直接使用OkHttps工具类来发起请求，更加方便快捷
        String result = OkHttps.sync(BASE_URL + "/api/list/user").get().getBody().toString();
        System.out.println("OkHttps sync: " + result);
        // 也可以直接使用HttpUtils工具类来发起请求，更加方便快捷
        String result2 = HttpUtils.sync(BASE_URL + "/api/list/user").get().getBody().toString();
        System.out.println("HttpUtils sync: " + result2);
    }

    /**
     * 异步请求调用示例
     */
    @Test
    public void asyncRequestTest() {
        // 方式一（异步调用，同步获取结果）
        HttpCall httpCall = OkHttps.async(BASE_URL + "/api/list/user").get();
        List<User> users = httpCall.getResult().getBody().toList(User.class);
        System.out.println("get async: " + JSON.toJSONString(users));

        // 方式二（真正实现异步调用及获取结果）
        OkHttps.async(BASE_URL + "/api/list/user")
                .setOnResponse(result -> {
                    List<User> users2 = result.getBody().toList(User.class);
                    System.out.println("get async2: " + JSON.toJSONString(users2));
                })
                .post();
        // 观察如下打印语句的输出顺序
        System.out.println("request finish");
    }

    /**
     * 键值对型入参请求示例
     */
    @Test
    public void kvParamsRequestTest() {
        JSONObject jsonObject = OkHttps.sync(BASE_URL + "/api/get/user")
                .addBodyPara("id", 123)
//                .addFilePara("img", "文件路径")
                .post()
                .getBody().toBean(JSONObject.class);
        System.out.println("result: " + jsonObject);
    }

    /**
     * 对象型入参请求示例
     */
    @Test
    public void jsonParamsRequestTest() {
        User user = new User(123L, "张三", 23, new Date());
        JSONObject jsonObject = OkHttps.sync(BASE_URL + "/api/get/user/json")
                .setBodyPara(user)
                // 报文类型：form、json、xml
                .bodyType("json")
                .post()
                .getBody().toBean(JSONObject.class);
        System.out.println("result: " + jsonObject);
    }

    /**
     * 设置请求头
     */
    @Test
    public void headerRequestTest() {
        JSONObject jsonObject = OkHttps.sync(BASE_URL + "/api/get/header")
                .addHeader("token", "131231231231")
                .post()
                .getBody().toBean(JSONObject.class);
        System.out.println("result: " + jsonObject);
    }

    @Test
    public void bigDataRequestTest() {
        OkHttps.sync("http://localhost:8080/data/bigData")
                .setOnProcess(onProcess -> {
                    long totalBytes = onProcess.getTotalBytes();
                    System.out.println(totalBytes);
                }).post();
    }

    @Test
    public void dataTest() throws Exception {
        //请求的webservice的url
        URL url = new URL("http://localhost:8080/data/bigData");
        //创建http链接
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        //设置请求的方法类型
        httpURLConnection.setRequestMethod("POST");
        //设置请求的内容类型
        httpURLConnection.setRequestProperty("Content-type", "application/x-www-form-urlencoded");
        //设置发送数据
        httpURLConnection.setDoOutput(true);
        //设置接受数据
        httpURLConnection.setDoInput(true);
        //发送数据,使用输出流
        OutputStream outputStream = httpURLConnection.getOutputStream();
        //发送的soap协议的数据
        String content = "timeout=15";
        //发送数据
        outputStream.write(content.getBytes());
        //接收数据
        InputStream inputStream = httpURLConnection.getInputStream();
        //定义字节数组
        byte[] b = new byte[1024];
        //定义一个输出流存储接收到的数据
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        //开始接收数据
        int len = 0;
        double size = 0.5 * 1024 * 1024;
        while (true) {
            len = inputStream.read(b);
            if (len == -1) {
                //数据读完
                break;
            }
            byteArrayOutputStream.write(b, 0, len);
            if(byteArrayOutputStream.size() >  size){
                System.out.println("数据超限，读取中断");
                break;
            }
        }
        //从输出流中获取读取到数据(服务端返回的)
        String response = byteArrayOutputStream.toString();
        System.out.println(response);
    }

}

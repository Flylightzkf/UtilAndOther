package com.password.test;

/**
 * @author kfz
 * @create 2023-06-14 17:51
 */
import java.net.HttpURLConnection;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class DeleteUserDemo {

    public static void main(String[] args) {
        String accessToken = "wwbe3e6856c98743c6";
        String userId = "Kaikai";
        String urlStr = "https://qyapi.weixin.qq.com/cgi-bin/user/get" + "?access_token=" + accessToken + "&userid=" + userId;

        try {
            URL url = new URL(urlStr);
            HttpURLConnection connection = (HttpURLConnection)url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();

            InputStream inputStream = connection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }

            bufferedReader.close();
            inputStream.close();

            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
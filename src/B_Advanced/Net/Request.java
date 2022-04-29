package B_Advanced.Net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Request {
    public static void main(String[] args) throws Exception {
        String url_basic = "http://localhost:8019/";
        String bus = "bus?type=metro";
        String numberOfBus = "number-of-bus";
        String pet = "pet";
        String url_combined = url_basic + pet;

        // 1. 构建URL对象
//        URL url = new URL("http","localhost",8080,"hello");
        URL url = new URL(url_basic);

        // 2. 创建链接，定义请求头
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");

        // 必须设置false，否则会自动redirect到重定向后的地址
        conn.setInstanceFollowRedirects(false);

        // 3. 发送请求，并获取返回信息
        conn.connect();
        String result = getReturn(conn);

        System.out.println(result);
    }

    public static String getReturn(HttpURLConnection conn) throws IOException {

        StringBuffer buffer = new StringBuffer();

        //将返回的输入流转换成字符串
        try (InputStream inputStream = conn.getInputStream();
             InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
             BufferedReader bufferedReader = new BufferedReader(inputStreamReader);) {

            String str = null;
            while ((str = bufferedReader.readLine()) != null) {
                buffer.append(str);
            }
            return buffer.toString();
        }
    }
}
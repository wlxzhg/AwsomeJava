package cn.xiaozhigang.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class HttpGet {
    //用get方法访问指定url，返回网页源码
    public static String doGet(String url) {
        String result = ""; //定义一个字符串来存储网页内容
        BufferedReader in = null; //定义一个缓冲字符输入流
        try {
            URL realUrl = new URL(url); //将字符串转换为url对象
            //初始化一个链接到url
            URLConnection connection = realUrl.openConnection();
            //开始实际的链接
            connection.connect();
            //初始化BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            //用来临时存储抓取到的每一行的数据
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("请求异常");
            e.printStackTrace();
        } finally {
            try {
                if(in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return result;
    }
}

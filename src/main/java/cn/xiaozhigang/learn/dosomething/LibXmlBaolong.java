package cn.xiaozhigang.learn.dosomething;

import com.xiaozhigang.util.HttpGet;

public class LibXmlBaolong {
    public static void main(String[] args) {
        String url = "http://202.117.122.222:8991/X?op=bor-info-nlc&bor-id=13020120075&CON_LAG=chi&user_name=www-zxst&user_password=zxst@lib";
        String str = HttpGet.doGet(url);
        //获取姓名
        int beginIndex = str.indexOf("<z303-name>") + "<z303-name>".length();
        int endIndex = str.indexOf("</z303-name>");
        String name = str.substring(beginIndex,endIndex);
        System.out.println(name);
    }
}

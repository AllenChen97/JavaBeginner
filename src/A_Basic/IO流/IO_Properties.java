package _16_IOStream;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/*
* 配置文件：
* 不需要改动代码、代码也不需要多次编译
*
* Java规范，属性配置文件以.properties结尾，但不一定
* properties是专门用来存放属性配置文件内容的类
* */

public class IO_Properties {
    public static void main(String[] args) throws IOException {
        FileReader reader = new FileReader("src/_16_IOStream/config.properties");
        Properties pro = new Properties();
        pro.load(reader);
        System.out.println(pro.getProperty("username"));
        System.out.println(pro.getProperty("password"));

    }
}

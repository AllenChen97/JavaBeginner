package A_Basic.B_数据类型.a_字符串;

import java.lang.StringBuffer;

/*
    如果大量对字符串进行拼接，创建多个字符串对象会大量占用内存空间，建议使用JDK中自带的StringBuffer 或StringBuilder
    StringBuffer 有synchronized 关键词修饰 表示StringBuffer在多线程下运行是安全的；StringBuilder中没有，表示在多线程下运行是不安全的
* */
public class c_StringBuffer {
    public static void main(String[] args) {
        StringBuffer str = new StringBuffer();

    }
}

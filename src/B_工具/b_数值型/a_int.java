package B_工具.b_数值型;

/*
        整数型   字节数   最大值
        byte    1       127
        short   2       32767
        int     4       2147483647 超过这个范围用long
        long    8

        1个字节 = 8个二进制位
        1byte = 8bit
* */
public class a_int {
    public static void main(String[] args) {
//        十进制
        int a = 10;
        System.out.println(a);
//        八进制
        int b = 010;
        System.out.println(b);
//        十六进制
        int c = 0x10;
        System.out.println(c);
//        二进制
        int d = 0b10;
        System.out.println(d);

//        int赋值给int类型变量，不存在类型转换
        int e = 100;
//        int赋值给long类型变量，存在类型自动转换，后面加个L就不用
        long f = 100;
        long g = 100L;

//        会编译报错，因为2147483647 会被默认当做int来处理，而他超过了int的最大值。加个L就解决了
        long h = 2147483647;

    }
}

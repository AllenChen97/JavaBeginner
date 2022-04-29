package A_Basic.B_数据类型.b_数值型;

/*

* */
public class b_intTransfer {
    public static void main(String[] args) {

//        小容量variable可以直接赋值给大容量
        int a = 100;
        long b = a;

//        但大容量不能传给小容量
//        long c = 100L;
//        int d = c;

//        需要加上强制类型转换，但会损失精度,例如：long(8个字节)转int(4个字节)会自动把前面4个字节砍掉
        long e = 100L;
        int f = (int)e;

//        int byte short char混合计算时，会先各自转换成int再做计算,需要加强制转换.
//        如果有long，则会先各自转换成long再做计算
        char g = 'a';
        byte h = 1;
        short s = (short)(g + h);

//        int/int 结果还是int
        System.out.println(10/3);
        System.out.println(1/2);
    }
}

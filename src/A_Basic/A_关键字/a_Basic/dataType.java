package A_Basic.A_关键字.a_Basic;

import java.math.BigDecimal;

public class dataType {
    /**
     *
     * 内存占用(byte)：byte 1 < shot 2 < int 4 < long 8 < float单精度 4 < double双精度 8 < char n
     * 1. 自动类型转换:byte, int, char混合运算 会统一转换成int在做运算
     *
     * 2. 强制类型转换:从高精度类型转换到低精度,需要加强制转换符，并损失精度
     *
     * 3. 过度类型转换：xx.doubleValue()
     *
     * 4. BigDecimal表示金额
     *
     * 补码、反码
     * */
    public static void main(String[] args){

        System.out.println("<-------------- 1. 基础注意点 -------------->");

        double divided = 10/3;
        System.out.println(divided); //3.0  因为10 和 3都是Int类型

        double divided2 = 10.0/3;
        System.out.println(divided2);// 3.3333333335

        System.out.println("\n<-------------- 2. 强制类型转换 -------------->");

        double d = 10.0/3;
        int i = (int) d;
        System.out.println("double——>int 强制类型转换" + i);

        System.out.println("\n<-------------- 4. BigDecimal 演示 -------------->");
        BigDecimal bd = new BigDecimal(3.25);
        BigDecimal bd1 = new BigDecimal(6.50);

        System.out.println("加：" + bd.add(bd1));
        System.out.println("减：" + bd.subtract(bd1));
        System.out.println("乘：" + bd.multiply(bd1));
        System.out.println("除：" + bd.divide(bd1));
        
        System.out.println("过度转型：" + bd.intValue());
        System.out.println("四舍五入：" + bd1.setScale(0,BigDecimal.ROUND_HALF_UP));
    }
}


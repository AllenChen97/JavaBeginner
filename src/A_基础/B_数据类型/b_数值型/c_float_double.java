package A_基础.B_数据类型.b_数值型;
/*
    类型        字节数
    float       4
    double      8       用在银行、会计方面 远远不够，需要用Bigdecimal

    任意一个float容量都比整数型容量都大，即使long占8个字节

* */

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class c_float_double {
    public static void main(String[] args) {

//        1. 任何一个浮点型数据都当做double处理，如果要当做float处理，在后面加F或者f
//        float a = 3.14;
        float b = 3.14f;

//        2. 先转成double再计算，结果也是double，需要加(int)
//        int c = 10 / 3.33;
        int d = (int)(10 / 3.33);

//        3. BigDecimal类，精度更高 适合财务、银行
        BigDecimal b1 = new BigDecimal(100);
        BigDecimal b2 = new BigDecimal(3);
//        System.out.println(b1.divide(b2));

//        4. 格式化decimal
        DecimalFormat dfm = new DecimalFormat("###,###.0000");
        System.out.println(dfm.format(b2));

    }
}

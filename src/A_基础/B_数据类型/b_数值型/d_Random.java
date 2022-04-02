package A_基础.B_数据类型.b_数值型;


import java.util.Random;

/*

 */


public class d_Random {
    public static void main(String[] args) {
//        Random r = new Random();
//        for (int i = 0; i < 5; i++) {
//            System.out.println(r.nextInt(100));// 100以内随机整数
//        }

//        seed一样的话 出来的数都是一样的，seed不直接对程序产生影响
//        重复运行都是一样的结果

        Random r2 = new Random(100);
        Random r3 = new Random(100);
        Random r4 = new Random(50);
        for (int i = 0; i < 100; i++) {
            String s = r2.nextInt(5) + " " + r3.nextInt(5) + " " + r4.nextInt(5) ;
            System.out.println(s);// 100以内随机整数
        }
    }
}

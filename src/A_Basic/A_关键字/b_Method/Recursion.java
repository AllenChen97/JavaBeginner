package A_Basic.A_关键字.b_Method;

public class Recursion {
    public static void main(String[] args) {
        System.out.println(SumInt(100));
    }
    public static int SumInt(int a) {
        if (a == 1) {                   //当a==1时，recursion停止
            return 1;
        }
        else {
            return a + SumInt(a-1); //在return语句中调用函数自身
        }
    }
}
package A_基础.A_关键字.a_Basic;

public class Loop_For {
    /*九九乘法表*/
    public static void main(String[] args) {
        for (int i = 1; i < 10; i++) {
            for (int j = 1; j <= i; j++) {
                    System.out.print(i+" * "+j+" = "+(i*j)+"\t");
                }
            System.out.println("");
        }
    }
}
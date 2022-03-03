package H_Algorithms.DataStructure.Graph;

public class test {
    public static void main(String[] args) {
        sumUp(2);
    }

    public static void sumUp(int i) {
        while (i > 0){
            System.out.println(i);

            for (int j = 1; j <= i; j++) {
                System.out.println((i--)+"的while循环：" + j + " ");
                sumUp(j);
            }
        }

    }
}

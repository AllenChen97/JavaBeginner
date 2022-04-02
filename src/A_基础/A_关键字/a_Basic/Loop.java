package A_基础.A_关键字.a_Basic;

import java.util.Scanner;

public class Loop {

    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int a = s.nextInt();

        if(a>=100){
            System.out.println("这个数字比100大");
        }
        else if(a>=10){
            System.out.println("这个数字比10大");
        }
        else{
            System.out.println("无法判断数字大小");
        }
    }

    private void Figure(String[] args){
        Scanner s =new Scanner(System.in);
        int a = s.nextInt();
        if(a>=100){
            System.out.println("这个数字比100大");
        }
        else if(a>=10){
            System.out.println("这个数字比10大");
        }
        else{
            System.out.println("无法判断数字大小");
        }
    }
}


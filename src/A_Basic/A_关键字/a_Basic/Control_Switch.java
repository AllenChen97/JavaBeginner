package A_Basic.A_关键字.a_Basic;

public class Control_Switch {
    public static void main(String[] args){
        for(int i=0;i<=10;i++){
            switch(i){
                case 0: case 2: case 4: case 6: case 8: case 10 :
                    System.out.println(i+" 是偶数");
                    break;
                case 3: case 5: case 7: case 9:
                    System.out.println(i+" 是基数");
                    break;
                default:
                    System.out.println("default");
            }
        }
    }
}

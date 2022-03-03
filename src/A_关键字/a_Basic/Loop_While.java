package A_关键字.a_Basic;

public class Loop_While {
    public static void main(String[] args){
        int i = 1;
        int j = 1;
        while(i<10){
            while (j<10){
                System.out.print("*\t");
                j++;
                if(j>5-Math.abs(i-5)){
                    System.out.println("");
                    j=1;
                    break;
                }
            }
            i++;
        }
    }
}

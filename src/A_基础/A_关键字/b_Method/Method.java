package A_基础.A_关键字.b_Method;


public class Method {
    //static 在main方法中，调用类里面其他方法不需要用 类名.
    //void 表示无内容输出。如果写int或其他返回类型，则严格要求一定要有"Return 值;" 且与定义返回的值类型一致。
    //void 里面的return只要是终止该方法的执行
    public static void main(String[] args){
//        Sumit(1,2);
//        Sumit2(2,3);
        Sumit3(3,4);

    }

    public static void Sumit(int a,int b){
        System.out.println(a+" + "+b+" = "+(a+b));
    }
    //研究void 和 return 语句
    public static String Sumit2(int a,int b){
        String output = a+" + "+b+" = "+(a+b);
        return output;
    }


    public static String Sumit3(int a,int b){
        if(a+b>0){
            String output = "两数之和大于0";
            return output;
        }
        else{
            String output = "两数之和小于0";
            return output;
        }
    }
}

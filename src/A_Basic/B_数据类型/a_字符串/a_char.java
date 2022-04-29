package A_Basic.B_数据类型.a_字符串;

/*
    char 的取值范围 0-65535

* */
public class a_char {
    public static void main(String[] args) {

        char c = 97; //'a'

        System.out.println("\n============================================================数组与字符串");
        /*
         * char c = 'abc'; //另外注意'\4e2d'是一个unicode（十六进制的）
         * String str = "abc";
         *
         * char是基础数据类型，不支持泛型
         * String是对象 具有面向对象特征（有属性和方法）
         * */
        char[] str_arr= "abcasdaf".toCharArray();   // 拆分
        System.out.println(new String(str_arr));    // 合并成字符串
        for (char r:str_arr) {
            int Upper_Ascii = r-32;// 转大写
            System.out.println(r + " " + (char)Upper_Ascii);
        }
    }
}

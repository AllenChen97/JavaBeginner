package A_基础.B_数据类型.a_字符串;
//https://docs.oracle.com/javase/8/docs/api/

//https://cloud.tencent.com/developer/article/1705069

public class b_String {
    public static void main(String[] args) {
        System.out.println("============================================================查询!!");

        //1. 长度 length()
        System.out.println("abc".length());

        //2. 抽取: substring(开始位置, 结束位置)
        System.out.println("1. "+"abcdefg".substring(1,3));

        //3.查找位置: indexOf(要查找的字符串)
        System.out.println("3. "+"abcdefg".indexOf("defg"));

        //4. 是否包含: contains()
        System.out.println("8. "+"abcdefg".contains("abc"));

        //5. 是否相等: equals() 和 equalsIgnoreCase()!!
        System.out.println("9. "+"abc".equals("ABC"));
        System.out.println("9. "+"abc".equalsIgnoreCase("ABC"));

        //6. 正则表达式: matches() 判断字符是否与指定的  相匹配
        String str = "123abc";
        String regex = "^[0-9]+[a-c]+$";
        System.out.println("10. "+str.matches(regex));

        //7.hashCode() it is the hashcode of the text but not the String Object
        System.out.println("123abc".hashCode());
        System.out.println("123abc".hashCode());

//        "123abc".regionMatches();
        System.out.println("  123  AbC  ");

        "abc".isEmpty();
        System.out.println("\n============================================================更改");

        //1. 更换: replace(被更换字符串, 新字符串)
        System.out.println("2. "+"abcdefgabc".replace("abc","cba"));

        //2. 大小写转换: toLowerCase()/toUpperCase()
        System.out.println("6. "+"abcdefg".toLowerCase());

        //3. 前后去空格: trim()
        System.out.println("7. "+"  abc  defg  ".trim());

        //4. 拼接: Concat()  少用
        //了解即可：+“” 和 concat拼接的区别:
        // 1.concat底层是根据数组扩容来进行拼接
        // 2.+可以拼接任意数据，但是concat只能拼接字符串
        System.out.println("4. "+"abcdefg".concat("hijk"));

        //5. 切分: split()
        String a[] = "abc,defg,abc".split(",");
        System.out.print("5. ");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+" ");
        }
    }
}

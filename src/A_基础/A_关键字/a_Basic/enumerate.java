package A_基础.A_关键字.a_Basic;


/*
    在程序返回结果有多种时，boolean也不够用了，可以使用枚举来列出结果，
    程序更清楚一点，别人一看到返回的东西：Result.A 就知道是某个程序的返回结果，否则还得在乱78遭的文档中查询你这个返回的12345是啥意思

    枚举是一种引用类型
* */
public class enumerate {
    public static void main(String[] args) {
    }
}

enum Result{
    A,B,C,D,E //五种程序的执行结果
}
package 基础语法关键字._4_This;
/*
* this 只可用在非静态变量/方法中，因为类需要在堆中实例化，才能有自己的内存地址，this才知道自己指向哪个内存地址。
* 用途：
*   1、用来区分函数输入的变量名和实例自身的变量名
*   2、用来overloading constructor this(xxx,xxx,xxx)

* */
public class This {
    public static void main(String[] args) {
        ts a = new ts();
        System.out.println(a.toString()); //改写Object自带的 .toString()

        a.toString2();
    }
}

class ts{

    public String toString() {
        return "aa";
    }

    public void toString2(){
        System.out.println(this); //自动调 .toString()
    }
}
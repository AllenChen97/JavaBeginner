package A_Basic.A_关键字.c_Static;

/*
使用方法：
    static 修饰的变量和方法，不需要实例化都可使用类名.xx 调用

使用场景：
    当该类实例化出来的每一个对象，使用该方法时均产生一样的结果，可以用static修饰方法（定义为类级别的动作），减少代码的空间复杂度。
    如pulic Chinese的类，国籍=Chinese就是这个类的静态变量。

注意：
    static 修饰的静态方法不能直接访问"非static成员变量"，因其需要实例化才能访问。但可以直接访问静态变量，因其在类加载时就储存在类储存区里。

优点：
    1.static 修饰成员变量，则成员变量在实例化（类加载）的时候，就已经在类储存区中开辟了一块储存空间。
    2.在重复创建类的时候，不需要在堆内存中不需要为这个成员变量开辟多个空间。

缺点：
    但该方法灵活性相对低，因为用static修饰的变量是类级别的，是该类所有实例都共有的特征。

* */
public class Static_Class {
    public static void main(String[] args) {
        System.out.println(Chinese.nationality); //使用场景 static修饰所有实例都一样的变量和方法，可以直接用类型.xxx调用

        Humance Jack = new Humance();
        System.out.println(Jack.BMI()); //注意
    }
}

class Humance{
    double heigth = 170.00;
    double weight = 55.00;

    public double BMI(){    // ！！加上static就会报错
        return this.heigth/this.weight;
    }
}

class Chinese extends Humance{
    static String nationality = "Chinese";
}
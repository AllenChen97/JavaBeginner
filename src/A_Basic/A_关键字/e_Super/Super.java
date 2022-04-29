package 基础语法关键字._5_Super;
/*
使用方法：
* 1.可以用.调用父类中的属性和方法， super.xxx
* 2.也可以用在构造方法的第一行中调用父类的构造方法 super(xxx)

注意：
* 1.同this一样在静态方法中不能调用，同样也没有权限使用supper.xxx调用父类private属性
* 2.super只储存父类中含有的属性和方法，不储存地地址

不能省略的情况：
* 1.在父类中有同样的属性和方法，必须以super

* */
public class Super {
    public static void main(String[] args) {
        B test = new B(10,11); // 用法2 构造方法中的super(xxx)

        test.printout();// 用法1 super.xxx
    }
}

class A{
    int num = 1;
    public A(int i){
        System.out.println(i);
    }
}

class B extends A{
    int num = 2;

    public B(int i,int j){
       super(i);
       System.out.println(j);
    }

    public void printout(){  //!加上static就报错
        System.out.println(this.num);
        System.out.println(num);

        System.out.println(super.num);
    }

}
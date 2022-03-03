package C_封装多态继承_面试.c_AbstractClass_Interface;


public class Abstarct_Interface {
    public static void main(String[] args) {
        Animal GuguBird = new Bird();
        GuguBird.eat();
    }
}
/** 接口
 用途
 1. 弥补类单继承的缺点，通常是抽象出类的方法（功能），像内存条即插即用（且一个类可以实现多个接口）
 2. 实现 程序调用者 和 实现者的“解耦合”?
 特点：
 1. 多继承，也可以使用多态！
 2. 接口只包含常量和抽象方法！且所有内容都是抽象和公开的！所以public static final 三个reserved word可以省略
 3. 因接口中方法都是抽象的，不能带有方法体，继承后必须进行重写，不然会报错

 4. 接口之间的强制类型转换，不需要像继承那样 需要有继承关系，编译可以通过 但在运行的时候会报ClassCastException

 * */
interface eatable{
    void eat();
}

/** AbstractC
 用途：
 1. 相当于programmer's documentary, tell the users what kind of function of the abstract class do
 2. 将类的共性进行抽象。同多态功能，在需求变更只需要在重新实现抽象类，降低程序耦合度，更符合OCP原则。

 抽象方法：
 1.没有实现的方法，没有方法体
 2.抽象方法只能出现在抽象类或接口中
 3.继承到子类里，必须"实现"或"重写"，否则报错

 注意：
 1. 抽象类不能实例化，只用于继承，储存类和类之间的共同特征
 2. final 和 abstract 不能同时使用
 3. 可以继承有构造方法的实例 和 抽象类
 * */
abstract class Animal implements eatable{
    public void eat(){
        System.out.println("动物吃肉");
    }
    abstract void shit();
}
class Bird extends Animal{
    @Override
    public void eat(){                      //如果不重写eat()方法 就会报错
        System.out.println("鸟儿吃几把");
    }

    @Override
    public void shit() {
        System.out.println("拉粑粑");
    }

}
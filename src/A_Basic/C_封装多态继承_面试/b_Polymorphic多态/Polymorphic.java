package A_Basic.C_封装多态继承_面试.b_Polymorphic多态;
/**
    转型:
        1. 向上转型 upcasting: 自然转型
        2. 向上转型 downcasting: 强制类型转换
        注：一定要在两个类之间有继承关系才可以通过编译

    instanceof 判断类:
        注：在此案例中，new pussy()或new doggy()出来的实例都是Animal, 但 new Animal()的实例就不是猫狗

    多态语法机制：
        1. 允许父类型引用指向子类型对象，从而实现多种形态的功能。以上机制导致 存在编译阶段绑定、运行阶段绑定。
        2. 如果调用方法为子类别独有，则需要做向下转型。（例子在下面有）

    目的：
        1. 满足程序开发OCP开闭原则，允许程序有更高的扩展性
        2. 在需求改变、升级的时候不会在原来的程序上面修改，在子类里面进行修改。然后 用调用子类独有的方法时，使用向下继承
        3. 充分利用继承的功能来实现OCP

    多态的两种表现形式：
         1. 重载Overload 指在同一类 或 子类中，允许同一方法 输入不同的参数 来实现同样目的的功能
         2. 重写Override 只在子类中，和父类用一样的参数（类型、个数、顺序一样），实现同样目的的功能

    ！！重写Override和重载Overload的区别:
        1. 是否需要有继承关系
        2. 是否要求参数一样
        注：输出类型 和 参数名字均不影响

* */
public class Polymorphic extends Object{
    public static void main(String[] args) {
        Humance Jack = new Humance();
        Animal pussy = new Cat();
        Animal doggy = new Dog();

        System.out.println(Jack.feed(pussy));
        System.out.println(Jack.feed(doggy));
    }
}

class Humance{
    /*
    * 要实现主人喂每一种宠物时，都有不同的效果出来，若不使用多态，则需要给每种动物都创建一种方法。延展性低
    * 高扩展力的体现：多增加一个类，不需要增加一个类。同一个功能 放同一个方法
    *
    *   public String feed(Cat c){
    *       c.eat()
    *   }
    *   public String feed(Dog d){
    *       d.eat()
    *   }
    *   ......
    *
    * 像现在这么写，主人的feed方法就面向抽象的Animal类，不再面向具体类型的宠物(猫,狗,...), 展现出极低的耦合度，提高程序扩展力
    * 能使用多态尽量使用多态
    * */

    public String feed(Animal a){
        if(a instanceof Cat){
            Cat pet = (Cat)a;
            return pet.eat();
        }
        else if (a instanceof Dog){
            Dog pet = (Dog)a;
            return pet.eat();
        }
        else{
            return "既不是猫又不是狗？";
        }
//        return a.eat(); // 编译报错，因为如果不做向下转型,编译器认为a的类型是Animal,而Animal里面没有eat()方法
    }
}

class Animal{
    public String eat(){
        return "动物乜7都吃";
    }
}

// 猫和狗都是继承动物的子类，eat是其独有的方法
class Cat extends Animal{
    @Override
    public String eat(){
        return "猫吃猫粮";
    }
}
class Dog extends Animal{
    @Override
    public String eat(){
        return "狗吃屎";
    }
}
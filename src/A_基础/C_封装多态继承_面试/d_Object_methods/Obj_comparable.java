package A_基础.C_封装多态继承_面试.d_Object_methods;

import java.util.Comparator;
import java.util.TreeSet;
/*
*
* 特点：
*   1.在插入数据的时候，会调用compareTo类用于 将新插入的key和TreeSet中的内容进行主义比较
*   2.对于自定义的类，无法直接进行插入，需要类中impletement Comparable接口,在重写compareTo方法时定义类之间的比较逻辑。
*   3.String能进行比较是因为String有实现Comparable接口
*
* */
public class Obj_comparable {
    public static void main(String[] args) {

        /*
         * compareTo 方法的重写很重要
         * 1. 0 表示两值相同
         * 2. >0 代表往右子树上找
         * 3. <0 代表往左子树上找
         *
         * */
        System.out.println("第一种方法：在自定义类里面重写Comparable的compareTo方法");
//        Teacher tc = new Teacher(50);
//        Teacher tc2 = new Teacher(30);
//        TreeSet<Teacher> tre2 = new TreeSet<>();
//        tre2.add(tc);
//        tre2.add(tc2);
//        for(Teacher t : tre2)
//            System.out.println(t);

        System.out.println("第二种方法：新建TreeSet对象的时候传入一个执行Comparator接口的比较器对象");
        Teacher teacher = new Teacher(50);
        Teacher teacher2 = new Teacher(30);
        TreeSet<Teacher> tre3 = new TreeSet<>(new TeacherComparator());
        tre3.add(teacher);
        tre3.add(teacher2);

        System.out.println("建议在逻辑复杂的时候使用Comparator方法，因其符合OCP原则，可以切换");
    }
}
class Teacher { //implements Comparable<Teacher>

    int age;
    public Teacher(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "age=" + age +
                '}';
    }
//    @Override
//    public int compareTo(Teacher t) {
//        return this.age-t.age;
//        }
}

class TeacherComparator implements Comparator<Teacher>{
    @Override
    public int compare(Teacher o1, Teacher o2) {
        return o1.age-o2.age;
    }
}
package C_封装多态继承_面试.e_Generic泛型;

import java.util.ArrayList;

/**
 * 作用：
 * 1.提前限定类型,避免类型出错做的。可以在类名/接口名后 或 方法的返回类型前
 * 2.Reduce code redundancy，能处理多种类型数据
* */
public class Generic<E extends Number> {
    public static void main(String[] args) {

        ArrayList<String> lst = new ArrayList<>();
        for (char i = 'a'; i < 'a'+ 5; i++) {
            lst.add(i + "");
        }
        System.out.println(lst);
    }


    /**
     * 如果E[]并不是一个在Class中定义好，需要在方法定义<E>
     * <E extends Comparable<? super E>> means: E 必须实现Comparable接口 或 继承了这么做的类
     * */
    public static <E extends Comparable<? super E>> void print(E[] a) {
        E e1 = null;
        for (E e: a) {
            if (e1 == null) {
                e1 = a[0];
            }
            else {
                e1 = e;
            }
            System.out.println(e1);
        }
    }
}

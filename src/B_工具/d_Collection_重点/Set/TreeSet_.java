package B_工具.d_Collection_重点.Set;

import java.util.TreeSet;

/**
 * 特点：
 * 1.实现了SortedSet接口，对集合元素自动排序
 * 2.基于排序实现元素不重复
 * 3.元素必须实现Comparable接口！提供排序规则 和 判断是否重复
 *
 */
public class TreeSet_ {
    public static void main(String[] args) {
        TreeSet<Integer> s = new TreeSet<>();
        s.add(3);
        s.add(2);
        s.add(1);

        for (int i: s) {
            System.out.print(i + " ");
        }

        System.out.println();
        System.out.println("size: " + s.size());
        System.out.println("是否包含1: " + s.contains(1));
    }
}

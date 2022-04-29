package A_Basic.B_数据类型.d_Collection_重点.Set;

import java.util.HashSet;

/**
 * 储存结构：哈希表(数组 + 链表 + 红黑树)
 * 储存过程：
 * 1.hashcode计算保存位置，如果此位置为空就直接保存；
 * 2.equal 判断重复，不重复的话形成链表
 *
 */
public class HashSet_ {
    public static void main(String[] args) {
        HashSet<Integer> s = new HashSet<>();
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

package A_基础.B_数据类型.d_Collection_重点.Map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;


/** HashMap
 * 储存：哈希表（数组 + 链表 + 红黑树）
 * Key是一个Set，用hashcode()和equals()判断键是否重复
 *
 * 参数：
 * 默认大小16个Entry
 * 最大容量 1 << 30
 * 当hashcode相同会形成纵向链表，纵向链表长度>8 && 数组长度>64 时，会把该链表转成红黑树 以提高执行效率
 *     TREEIFY_THRESHOLD = 8;    MIN_TREEIFY_CAPACITY = 64;
 *
 * HashSet在初始化的时候，对象里面生成了一个Hashmap。
 *
 * HashTable 是一种老数据结构，包含很多和proporties配合的流的处理方式。
 * HashTable的键和值都不能为空，HashMap的键和值都允许为空
 * */
public class HashMap_ {
    public static void main(String[] args) {
        System.out.println("\n<--------------- 增删改 --------------->");
        HashMap<Integer,String> m = new HashMap<>();
        m.put(3,"ccc");
        m.put(2,"bbb");
        m.put(1,"aaa");

//        m.remove(2);

        System.out.println("\n<--------------- 查 --------------->");
        System.out.println("索引为2的值是：" + m.get(2));

        System.out.println("map的元素个数为：" + m.size());

        System.out.println("是否含有该key：" + m.containsKey(999));
        System.out.println("是否含有该value：" + m.containsValue("bbb"));

        System.out.println("所有键:" + m.keySet());
        System.out.println("所有值：" + m.values());

//        HashMap_.printer(m);
        Set<Map.Entry<Integer,String>> nodes = m.entrySet();
        for (Map.Entry<Integer,String> node: nodes){
            System.out.println(node.getKey() + " = " + node.getValue());
        }


    }
    public static void printer(Map m){
        Set<Map.Entry<Integer,String>> nodes = m.entrySet();
        for (Map.Entry<Integer,String> node: nodes){
            System.out.println(node.getKey() + " = " + node.getValue());
        }
    }
}

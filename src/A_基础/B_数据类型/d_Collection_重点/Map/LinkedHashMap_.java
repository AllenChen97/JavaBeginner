package A_基础.B_数据类型.d_Collection_重点.Map;

import java.util.LinkedHashMap;


/** LinkedHashMap
 * 对比Hashmap，linkedhashmap会保留插入时的顺序，而不是按照key排序
 *
 * */
public class LinkedHashMap_ {
    public static void main(String[] args) {
        System.out.println("\n<--------------- 增删改 --------------->");
        LinkedHashMap<Integer,String> m = new LinkedHashMap<>();
        m.put(3,"ccc");
        m.put(2,"bbb");
        m.put(1,"aaa");

//        m.remove(2);
        System.out.println("索引为2的值是：" + m.get(2));

        System.out.println("\n<--------------- 查 --------------->");
        System.out.println("map的元素个数为：" + m.size());

        System.out.println("是否含有该key：" + m.containsKey(999));
        System.out.println("是否含有该value：" + m.containsValue("bbb"));

        System.out.println("所有键:" + m.keySet());
        System.out.println("所有值：" + m.values());

        HashMap_.printer(m);
    }
}

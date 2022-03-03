package B_工具.d_Collection_重点.Map;



import java.util.TreeMap;

/** TreeMap
 * Key可以使实现排序，Key元素需要实现Comparable<>接口
 *
 * TreeSet在初始化的时候，对象里面生成了一个Treemap。
 *
 * */
public class TreeMap_ {
    public static void main(String[] args) {
        System.out.println("\n<--------------- 增删改 --------------->");
        TreeMap<Integer,String> m = new TreeMap<>();
        m.put(1,"aaa");
        m.put(2,"bbb");
        m.put(3,"ccc");

        m.remove(2);
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

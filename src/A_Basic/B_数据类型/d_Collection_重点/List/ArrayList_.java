package A_Basic.B_数据类型.d_Collection_重点.List;
import java.util.ListIterator;
import java.util.TreeSet;


/**
 * ArrayList_特点：
 * 1.底层是数组，有序可重复
 * 2.每次扩容是原来的1.5倍
 *
 * 优点：
 * 1.查询效率高：因底层是数组，内存地址连续
 * 2.底层是数组，增加在后面 高效
 *
 * 缺点：
 * 1.能难找到一块大内存来存储较大的数据
 * 2.删改慢
 *
 * LinkedList 相反：删改容易，查询慢
 * */
public class ArrayList_ {
    public static void main(String[] args) {
        System.out.println("一、数组创建--------------------------------------->");
        java.util.ArrayList list = new java.util.ArrayList();

        java.util.ArrayList<TreeSet> list2 = new java.util.ArrayList<>(new TreeSet());

        System.out.println("\n二、增加、删除-------------------------------------->");
        list.add("add2");

        list.add("bb");
        list.add("bb");
        list.set(1,"cc");
        System.out.println(list);
        list.remove(0);


        System.out.println("\n三、查询---------------------------------->");
        System.out.println("第一个\"bb\"的位置: " + list.indexOf("bb"));
        System.out.println("最后一个\"bb\"的位置: " + list.lastIndexOf("bb"));

        System.out.println("第二个位置上的值: " + list.get(1));

        System.out.println("元素个数: " + list.size());
        System.out.println("是否为空: " + list.isEmpty());
        System.out.println("是否包含: " + list.contains("1"));

        System.out.print("子集：");
        for (Object s: list.subList(1,2)) {
            System.out.print(s + " ");
        }

        System.out.println("\n五、遍历内容----------------------------------------->");

        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();

        // ListIterator 可以从前往后遍历，也可以从后往前
        ListIterator it = list.listIterator();
        while(it.hasNext()){
            System.out.print(it.next() + " ");
        }
        while(it.hasPrevious()){
            System.out.print(it.previous() + " ");
        }
        System.out.println();

        //要在ArrayList创建的时候使用泛型，才能在foreach中使用String
        for (Object s: list) {
            System.out.print(s + " ");
        }


    }
}

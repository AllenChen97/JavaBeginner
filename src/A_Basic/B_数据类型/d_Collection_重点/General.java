package A_Basic.B_数据类型.d_Collection_重点;

import java.util.*;

/**
 * 特点：
 * 1.集合长度不固定，数组长度固定
 * 2.集合只能使用引用类型，数组可以使用基础/引用类型
 * 3.
 * 4.
 * */

public class General {
    public static void main(String[] args) {
        ArrayList<Integer> c = new ArrayList();
        c.add(3);
        c.add(2);
        c.add(1);
        c.add(0);
        c.remove(new Integer(0));

        System.out.println("<--------------- 1.线程安全 --------------->");
        Collections.synchronizedList(c);

        System.out.println("\n<--------------- 2.数组处理 --------------->");
        Collections.sort(c);        // Collections.sort(list,比较器); 也可以
        Collections.reverse(c);     // 倒序
        Collections.shuffle(c);     // 随机打散

        ArrayList<Integer> c1 = new ArrayList();
        Collections.copy(c,c1);     // 复制

        //数组转列表
        Integer[] arr = {3,2,1};    //如果是int[]，List的泛型就要写List<int[]>
        List<Integer> c2 = Arrays.asList(arr);
        c2.add(2);      //因List是受限集合，不能修改 或增删，所以此处会报错！
        System.out.println(c2);

        System.out.println("\n<--------------- 3.遍历 --------------->");
//        Iterator it = c.iterator();
//        while(it.hasNext()){
//            System.out.println(it.next());
//            c.remove(2);//会报错
//            it.remove();
//        }
        System.out.println(c);
        System.out.println("二分查找：？？" + Collections.binarySearch(c,1));


        System.out.println("\n<--------------- 4.判断 --------------->");
        System.out.println("c是否包含2：" + c.contains(2));
        System.out.println("c是否为空：" + c.isEmpty());
    }
}

package B_工具.d_Collection_重点.List;

/*
特征：
    1.因为数组是引用类型，所以储存在堆内存，且实际上储存的是数组内容的内存地址 不直接存储java对象
    2.一旦创建长度不可变，要求数组内元素的类型统一
    3.元素的内存地址是连续的，取第一个元素的内存地址作为整个数组的内存地址

优点：
    1.类型类型统一，占用内存空间小
    2.元素内存地址连续，查询效率高
缺点：
    1.修改效率低
    2.不能存储特别大的数据，因为很难找到一块特别大的连续内存空间

* */

public class Array_ {
    public static void main(String[] args) {
        int[] a = {100,9,12,50};            //静态创建：直接创建数组

        String[] s = new String[100];         //动态创建:后期赋值,里面存默认值
        s[0] = "a";
        s[1] = "b";                         //赋值

        for (String i: s) {
            System.out.print(i + " ");
        }

        System.out.println("\n<--------------- 复制 --------------->");
        int[] arr1 = {100,12,-1,5,50};
        int[] arr2 =  new int[10];
        System.arraycopy(arr1,0,arr2,5,arr1.length);

        for (int i : arr2) {
            System.out.print(i + " ");
        }
    }
}

package C_算法.Sorting.simpleSorting;

/*
* 思想：默认i左边的元素是有序的，右侧是无序的。逐个即将无序元素往左边插入，构成最终有序数组。
*
* */
public class insertionSort {
    public static void main(String[] args) {
        int[] array = {99,22,55,99,33};

        //排序
        insertionSort.sort(array);
        //检验
        check(array);
    }
    public static void sort(int[] array){
        for (int i = 1; i < array.length; i++) {
            int target = array[i];
            int tmp;
            //每次将i位置的元素 与左边所有元素进行对比，如有比i位置元素大的，就往该元素前面插入。
            for (int j = i-1; j >= 0; j--){
//                insertionSort.check(array);
                if (array[j] > target){
                    // 一直往前找位置，顺面把元素往后挪1位
                    tmp = array[j+1];
                    array[j+1] = array[j];
                    array[j] = tmp;
                }
                else{
                    // 找到位置就把target放到j+1位置上
                    break;
                }
            }
        }
    }

    public static void check(int[] array) {
        for (int i: array) {
            System.out.print(i + " ");
        }
        System.out.println(" ");
    }
}

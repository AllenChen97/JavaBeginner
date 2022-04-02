package C_算法.Sorting.simpleSorting;

public class selectionSort {
    public static void main(String[] args) {
        int[] array = {99,22,55,33,99};
        int temp;

        //5遍循环
        for (int i = 0; i < array.length; i++) {

            //每次找出一个最小值放最前，然后该最小值不参与下一次的比较
            int minIndex = i;
            for (int j = minIndex + 1; j < array.length; j++) {
                if (array[j] < array[minIndex]){
                    minIndex = j;
                }
            }
            if (minIndex > i){
                temp = array[i];
                array[i] = array[minIndex];
                array[minIndex] = temp;
            }
        }

        //检验
        for (int i: array) {
            System.out.println(i);
        }
    }
}

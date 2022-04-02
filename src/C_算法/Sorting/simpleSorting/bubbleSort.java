package C_算法.Sorting.simpleSorting;

public class bubbleSort {
    public static void main(String[] args) {
        int[] array = {99,22,55,33,99};
        int temp;

        //5遍循环
        for (int i = 0; i < array.length; i++) {

            //每次找出一个最大值放最后，然后该最大值不参与下一次的比较
            int maxIndex = 0;
            for (int j = 0; j < array.length-i; j++) {
                if (array[j] > array[maxIndex]){
                    maxIndex = j;
                }
            }
            if (maxIndex < array.length-i){
                temp = array[array.length - i - 1];
                array[array.length - i - 1] = array[maxIndex];
                array[maxIndex] = temp;
            }
        }
        //检验
        for (int i: array) {
            System.out.println(i);
        }
    }
}

package C_算法.Sorting.complexSorting;

/*
*   设定跨度h 对数据进行分组并排序，每一趟排序的hn=ceil(hn+1/2)，初始h=元素个数/2
* */


public class shellSort {
    int[] array = {99,22,55,33,99};
    public static void main(String[] args) {
        shellSort s = new shellSort();
        s.sort(1);
        s.check();
    }

    private void sort(int distance) {
        // 1.stop
        if(distance > array.length/2) return;
        // 2.recursively
        sort(distance*2);

        // 3.sort in groups (divided into groups)
        int tmp;
        // 按间距distance循环，distance=2时 执行两组排序
        for (int i = 0; i <= distance; i++) {
            // 分组后，遍历组内元素，进行插入排序
            for (int j = i + distance; j < array.length; j += distance) {
                // 插入排序
                for (int k = j-distance; k>=0; k -= distance) {
//                    System.out.println(k);
                    if(array[k + distance] < array[k]){
                        tmp = array[k + distance];
                        array[k + distance] = array[k];
                        array[k] = tmp;
                    }
                    else{
                        break;
                    }
                }
            }
        }
    }

    public void check() {
        //检验
        for (int i: array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}

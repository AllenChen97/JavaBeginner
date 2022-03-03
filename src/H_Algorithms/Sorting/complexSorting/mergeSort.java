package H_Algorithms.Sorting.complexSorting;

/*
* 思想：一直两两往下拆，拆到不能拆 就开始两两排序、再合并，构成最后有序数组。
* */
public class mergeSort {
    int[] array = {99,22,55,33,99};


    public static void main(String[] args) {
        mergeSort m = new mergeSort();
        m.sort(0,m.array.length - 1);
        m.check();
    }

    public void sort(int start,int end){
        // 制定递归停止规则
        if(start == end){
            return;
        }

        // 计算拆分位置，并拆分成两组 分别递归
        int mid = (start + end)/2;
        sort(start, mid);
        sort(mid+1, end);

        // 合并、排序
        merge(start, mid, end);
        System.out.println();
        }

    public void merge(int start,int mid,int end) {
        int[] temp = array.clone();
        int p1 = start;
        int p2 = mid+1;
        for (int i = start; i < end+1; i++) {
            if(p1 == mid+1){
                temp[i] = array[p2];
                p2++;
            }
            else if(p2 == end+1){
                temp[i] = array[p1];
                p1++;
            }
            else if (array[p1] > array[p2]){
                temp[i] = array[p2];
                p2++;
            }
            else if (array[p1] < array[p2]){
                temp[i] = array[p1];
                p1++;
            }
        }
        //数组合并
        array = temp.clone();
    }

    public void check() {
        //检验
        for (int i: array) {
            System.out.println(i);
        }
    }
}

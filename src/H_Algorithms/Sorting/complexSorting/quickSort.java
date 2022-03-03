package H_Algorithms.Sorting.complexSorting;

/*
*   思想：选定第一个数值，将小于该元素的放左边、大于的放右边，然后左右两边分别再做同样的排序。
* */

public class quickSort {
    int[] array = {99,22,33,55,99};
    public static void main(String[] args) {
        quickSort q = new quickSort();
        q.sort(0,q.array.length-1);
        q.check();
    }

    private void sort(int start,int end) {
        int[] tmp = array.clone();
        int target = array[start];
        int p1 = start;
        int p2 = end;

        // 1.Compare the first element in each loop
        for (int i = start + 1; i < end+1; i++) {
            if(array[i] < target){
                tmp[p1] = array[i];
                p1++;
            }
            else{
                tmp[p2] = array[i];
                p2--;
            }
        }
        tmp[p1] = target;
        array = tmp;

        // check up
        System.out.print("target " + target + "；position " + p1 + ". ");
        check();

        // 2.sort recursively，如果p1 p2指针没动过就不用进入递归，或只有1个元素
        if (p1 != start && p1+1 != start) sort(start,p1-1);
        if (p2 != end && p1+1 != end) sort(p1+1,end);
    }

    public void check() {
        //检验
        for (int i: array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

}

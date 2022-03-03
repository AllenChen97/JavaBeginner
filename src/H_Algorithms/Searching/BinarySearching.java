package H_Algorithms.Searching;

public class BinarySearching {
    public static void main(String[] args) {
        int[] a = {1,2,3,4};
        System.out.println(binarySearching(a,3));
    }

    public static int binarySearching(int[] arr,int target) {
        return binarySearching(arr,target,0,arr.length);
    }


    public static int binarySearching(int[] arr,int target,int start,int end) {
        int mid = (start + end) / 2 ;
        if (arr[mid] == target) return mid;
        if (start==end) return start;

        if(target > arr[mid]) return binarySearching(arr, target, mid++, end);
        else return binarySearching(arr, target, start, mid--);
    }
}

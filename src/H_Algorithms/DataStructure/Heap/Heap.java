package H_Algorithms.DataStructure.Heap;


/**
* 特点
 * 1.完全二叉树，即除最后一层都是满的，且最后一层左满 右可不满
 * 2.数组实现，索引位置从1开始，！！左右子树位置是2k 和 2k+1
 * 3.父节点比子树大
* */

public class Heap <T extends Comparable<T>>{
    public T[] items;
    public int N;

    public Heap(int capacity) {
        this.items = (T[]) new Comparable[capacity + 1] ;
        this.N = 0;
    }

    /**
     * 传入无序数组，利用sort方法构建有序的堆
     * */
    public Heap(T[] items) {
        this.items = (T[]) new Comparable[items.length + 1];
        System.arraycopy(items,0,this.items,1,items.length);
        N = items.length;
        sort();
    }

    public T getItems(int i){
        return items[i];
    }

    public void sort() {
        for (int i = N/2; i > 0 ; i--) {
            sink(i);
        }
    }

    public boolean less(int i, int j){
        return items[i].compareTo(items[j]) < 0;
    }
    public void exchange(int i, int j){
        T tmp = items[i];
        items[i] = items[j];
        items[j] = tmp;
    }

    public void insert(T value){
        items[++N] = value;
        swim(N);
    }
    public void swim(int i){
        while(i>1){
            if(!less(i,i/2)) exchange(i,i/2);
            i /= 2;
        }
    }

    public T delMax(){
        // 第1位(max)和最后一位元素交换
        exchange(1,N);
        T max = items[N];
        items[N--] = null;

        // 此时第1位并非最大值，需要下沉找到该元素合适的位置
        sink(1);
        return max;
    }

    public void delete(int i){
        exchange(i,N);
        N--;
        sink(i);
    }

    /**
     * 1. 先找出两个子节点的较大值索引max，只有左节点时 默认左节点索引2i为max
     * 2. 然后用i位置的值，跟两个子节点的较大值max比较
     *      ① 若i位置的值 比子节点都大则break；
     *      ② 否则就交换i 和 max位置上的值，并让 子节点的较大值索引max update 变量i的值
     * */
    public void sink(int i){
        int max;
        while(i*2 <= N) {
            if(i*2 + 1 <= N){
                max = less(i*2, i*2+1)? i*2+1: i*2;
            }
            else {
                max = i * 2;
            }

            if(!less(i, max)){
                break;
            }
            exchange(i,max);
            i = max;
        }
    }
}

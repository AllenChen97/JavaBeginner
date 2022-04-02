package C_算法.DataStructure.Heap;

public class test {
    public static void main(String[] args) {
        String [] itgs = {"E","B","A"};
        HeapReverse<String> h = new HeapReverse<>(itgs);
//        h.insert("B");
//        h.insert("E");
//        h.insert("A");


//        String result = "";
//        while((result = h.delMax()) != null){
//            System.out.println(result);
//        }

        for (int i = 1; i <= h.N; i++) {
            System.out.print(h.getItems(i)+ " ");
        }


    }
}

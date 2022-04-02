package C_算法.DataStructure.LinearTable;

public class testQueue {
    public static void main(String[] args) {
        Queue<Integer> q = new Queue<>();
        q.add(5);
        q.add(1);
        q.add(2);
        q.add(6);

        Integer i;
        while((i = q.remove()) != null){
            System.out.println("dequeue:" + i);
        }
    }
}

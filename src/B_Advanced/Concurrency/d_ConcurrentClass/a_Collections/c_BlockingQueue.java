package B_Advanced.Concurrency.d_ConcurrentClass.a_Collections;


import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;

public class c_BlockingQueue {
    public static void main(String[] args) {
        ArrayBlockingQueue<Object> ABQ = new ArrayBlockingQueue<>(3);
        LinkedBlockingQueue<Object> LBQ = new LinkedBlockingQueue<>();
        LinkedBlockingDeque<Object> LBD = new LinkedBlockingDeque<>();

    }
}

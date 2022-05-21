package B_Advanced.Concurrency.d_ConcurrentClass.c_Auxiliary;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class c_Semaphore {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);
        for (int i = 0; i < 6; i++) {
            new Thread(()->{
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName() + " 抢到车位");
                    TimeUnit.SECONDS.sleep(2);
                    System.out.println(Thread.currentThread().getName() + " 离开车位");

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                finally {
                    semaphore.release();
                }
            },String.valueOf(i) ).start();
        }

    }
}

package B_Advanced.Concurrency.d_ConcurrentClass.c_Auxiliary;

import java.util.concurrent.CountDownLatch;

public class a_CountDownLatch {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(6);

        for (int i = 0; i < 6; i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName());
                countDownLatch.countDown(); //在方法体的底部，完成所有操作后 -1
            },String.valueOf(i) ).start();
        }

        countDownLatch.await(); // 等待计数器减到0，再向下执行

        System.out.println("Close!!");
    }
}

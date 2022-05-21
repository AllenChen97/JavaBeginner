package B_Advanced.Concurrency.d_ConcurrentClass.c_Auxiliary;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class b_CyclicBarrier {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(7,()->{
            System.out.println("凑齐7龙珠，召唤神龙");
        });

        for (int i = 0; i < 7; i++) {
            final int tmp = i;
            new Thread(()->{
                // 面试点：lambda里面获取不到 i， 需要加个变量来存
                System.out.println(tmp); // i

                try {
                    cyclicBarrier.await(); //在方法体的底部，完成所有操作后 -1
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            },String.valueOf(i) ).start();
        }
    }
}

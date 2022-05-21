package B_Advanced.Concurrency.z_Advanced_Concurrent;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class b_Asyn {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 没有返回值的 runAsync() 异步回调
        CompletableFuture<Void> task1 = new CompletableFuture().runAsync(()->{
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        task1.get();

        CompletableFuture<Integer> task2 = new CompletableFuture().supplyAsync(()->{
            System.out.println(Thread.currentThread().getName());
            int i = 10/0;
            return 200;
        });

        task2.whenComplete((p1, p2)->{
            System.out.println(p1);     // 正常返回结果
            System.out.println(p2);     // 异常返回结果       // java.util.concurrent.CompletionException: java.lang.ArithmeticException: / by zero
        }).exceptionally((e)->{
            System.out.println(e.getMessage());             // java.lang.ArithmeticException: / by zero
            return 404;
        }).get();

    }
}

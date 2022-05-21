package B_Advanced.Concurrency.z_Advanced_Concurrent;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.stream.LongStream;

public class a_ForkJoin {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Long i = 10_0000_0000L;     //10_0000_0000
        // 1. 原始程序: 6924微秒
        Long start;
        Long result;
        Long end;

        start = System.currentTimeMillis();
        result = recursive(i);
        end = System.currentTimeMillis();
        System.out.println("耗时: " + (end - start) + ", result: " + result);

        // 2. forkjoin:
//        start = System.currentTimeMillis();
//        result = forkjoin(i);
//        end = System.currentTimeMillis();
//        System.out.println("耗时: " + (end - start) + ", result: " + result);

        // 3. stream: 182微秒
        start = System.currentTimeMillis();
        result = stream(i);
        end = System.currentTimeMillis();
        System.out.println("耗时: " + (end - start) + ", result: " + result);

    }
    public static Long recursive(Long i) {
        Long sum = 0L;
        for (Long j = 0L; j < i; j++) {
            sum += j;
        }
        return sum;
    }

    public static Long forkjoin(Long i) throws ExecutionException, InterruptedException {
        ForkJoinPool forkJoinPool = new ForkJoinPool();

        ForkJoinTask<Long> task = new ForkJoinRecursive(0L, i);
        ForkJoinTask<Long> result = forkJoinPool.submit(task);

        return result.get();
    }

    public static Long stream(Long i) {
        Long sum = LongStream.rangeClosed(0L,i)     // 闭区间的 从0-i
                .parallel()                         // 并行
                .reduce(0, Long::sum);       // 求和

        return sum;
    }


}
class ForkJoinRecursive extends RecursiveTask<Long> {
    Long start;
    Long end;

    public ForkJoinRecursive(Long start, Long end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        long mid = (start - end) / 2;

        ForkJoinRecursive task1 = new ForkJoinRecursive(start, mid);
        task1.fork();       // 把任务压入线程队列

        ForkJoinRecursive task2 = new ForkJoinRecursive(mid + 1, end);
        task2.fork();

        return task1.join() + task2.join();
    }
}

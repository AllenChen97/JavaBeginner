package B_Advanced.Concurrency.e_ThreadPool;

import java.util.concurrent.*;

public class a_ThreadPool<T> {

    int CPUCore;
    ExecutorService pool;

    public a_ThreadPool() {
        CPUCore = Runtime.getRuntime().availableProcessors();
        pool = new ThreadPoolExecutor(
                CPUCore, CPUCore * 2,    // corePool and maxPoolSize池大小
                60L, TimeUnit.SECONDS,      // 线程消亡时间
                new LinkedBlockingQueue<>(),
                new ThreadPoolExecutor.CallerRunsPolicy()); // 多出来的线程让main线程执行
    }

    public void setPool(Runnable runnable) {
        pool.submit(runnable);
    }

    public Object setPool(Callable callable, Class<T> resultType) throws ExecutionException, InterruptedException, TimeoutException {

        Future result = pool.submit(callable);

        return result.get(30, TimeUnit.SECONDS);
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        a_ThreadPool requestPool = new a_ThreadPool();
        Object i = requestPool.setPool(()-> new Integer("1"), Integer.class);
        System.out.println(i);

    }
}

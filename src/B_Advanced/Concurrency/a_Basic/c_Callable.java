package B_Advanced.Concurrency.a_Basic;

import java.util.concurrent.*;

/*
 * 创建线程的第三种方法：
 *   写一个类实现Callable,重写call方法，放在FutureTask里面，最后再放在Thread
 * 特点：
 *   有具体的返回值。但效率较低，ft.get()在主线程执行，如果thread阻塞同时也会吧主线程给卡住了
 * */

public class c_Callable implements Callable<Boolean> {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 方法1：
//        FutureTask ft = new FutureTask(new c_Callable());
//        Thread t = new Thread(ft);
//        t.start();
//        ft.get();   //JDK8之后才有的新特性

        // 方法2：
        c_Callable c1 = new c_Callable();
        c_Callable c2 = new c_Callable();
        c_Callable c3 = new c_Callable();

        // 创建执行服务
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        // 提交执行
        Future<Boolean> result1 = executorService.submit(c1);
        Future<Boolean> result2 = executorService.submit(c2);
        Future<Boolean> result3 = executorService.submit(c3);

        System.out.println("" + result1.get() + result2.get() + result3.get());
        executorService.shutdownNow();

    }

    @Override
    public Boolean call()  {
        System.out.println("begin");

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("end");
        return true;
    }
}

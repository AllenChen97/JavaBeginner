package E_多线程;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/*
 * 创建线程的第三种方法：
 *   写一个类实现Callable,重写call方法，放在FutureTask里面，最后再放在Thread
 * 特点：
 *   有具体的返回值。但效率较低，ft.get()在主线程执行，如果thread阻塞同时也会吧主线程给卡住了
 * */

public class Synchronize3{
    public static void main(String[] args) {
        FutureTask ft = new FutureTask(new Callable() {
            @Override
            public Object call() throws Exception {
                System.out.println("begin");
                Thread.sleep(100);
                System.out.println("end");
                return 10+1;
            }
        });

        Thread t = new Thread(ft);
        t.start();
//        ft.get();   //JDK8之后才有的新特性
    }
}

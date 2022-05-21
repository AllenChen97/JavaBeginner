package B_Advanced.Concurrency.b_Producer_Consumer;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class a_sychronized_notify {
    public static void main(String[] args) {

        ArrayList list = new ArrayList();

        new Thread(()->{
            while(true){
                // 放方法也可以，只需要锁住list 用代码块更高效
                synchronized (list){
                    // 有货 就等
                    if(list.size() > 0){
                        try {
                            list.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    else{
                        list.add(Thread.currentThread().getName());      // 生产
                        System.out.println("生产" + "-->" + list.size());

                        try {
                            TimeUnit.SECONDS.sleep(3);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        list.notifyAll();
                    }

                }
            }
        },"producer").start();

        new Thread(()->{
            while(true){
                synchronized (list){
                    // 没货 就等
                    if(list.size() == 0){
                        try {
                            list.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    else{
                        list.remove(0);     // 消费
                        System.out.println("消费" + "-->" + list.size());

                        try {
                            TimeUnit.SECONDS.sleep(3);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        list.notifyAll();
                    }
                }
            }
        },"consumer").start();
    }
}






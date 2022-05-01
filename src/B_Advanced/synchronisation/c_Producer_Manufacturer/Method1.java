package B_Advanced.synchronisation.c_Producer_Manufacturer;

import java.util.ArrayList;

public class Method1 {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        Producer p = new Producer(list);
        Consumer m = new Consumer(list);

        p.start();
        m.start();

    }

    // 消费者
    static class Consumer extends Thread{
        ArrayList list;

        public Consumer(ArrayList list) {
            this.list = list;
        }

        @Override
        public void run() {
            while(true){
                synchronized (list){
                    if(list.size()==0){
                        try {
                            list.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    list.remove(0);
                    System.out.println("消费" + "-->" + list.size());

                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    list.notifyAll();
                }
            }
        }
    }
    // 生产者
    static class Producer extends Thread{
        ArrayList list;

        public Producer(ArrayList list) {
            this.list = list;
        }

        @Override
        public void run() {
            while(true){
                // 放方法也可以，只需要锁住list 用代码块更高效
                synchronized (list){
//                     有货 就等
                    if(list.size()>0){
                        try {
                            list.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    list.add(this.getName());
                    System.out.println("生产" + "-->" + list.size());

                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    list.notifyAll();
                }
            }
        }
    }

}






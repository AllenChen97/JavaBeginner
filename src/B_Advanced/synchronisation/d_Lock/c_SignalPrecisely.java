package B_Advanced.synchronisation.d_Lock;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class c_SignalPrecisely {
    public static void main(String[] args) {
        Data data = new Data();
        thread(data,"A",1);
        thread(data,"B",2);
        thread(data,"C",3);
    }

    public static void thread(Data data, String name, int num){
        new Thread(() -> {
            while (true) {
                try {
                    if (num == 1) data.printA();    // 生产
                    else if (num == 2) data.printB();
                    else if (num == 3) data.printC();                // 消费
                    else System.out.println("num出错 超出3，num: " + num);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },name).start();
    }

    static class Data{
        int num = 1;
        Lock lock = new ReentrantLock();
        Condition con1 = lock.newCondition();
        Condition con2 = lock.newCondition();
        Condition con3 = lock.newCondition();

        public void printA() throws InterruptedException {
            try {
                lock.lock();
                while (num != 1){
                    try {
                        con1.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName() + ", num: " + num);
                Thread.sleep(300);
                num = 2;
                con2.signal();
            } finally {
                lock.unlock();
            }
        }
        public void printB() throws InterruptedException {
            try {
                lock.lock();
                while (num != 2) {
                    try {
                        con2.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName() + ", num: " + num);
                Thread.sleep(300);
                num = 3;
                con3.signal();
            } finally {
                lock.unlock();
            }
        }

        public void printC() throws InterruptedException {
            try {
                lock.lock();
                while (num != 3) {
                    try {
                        con3.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName() + ", num: " + num);
                Thread.sleep(300);
                num = 1;
                con1.signal();
            } finally {
                lock.unlock();
            }
        }
    }

}



package B_Advanced.synchronisation.d_Lock;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class b_Condition {
    public static void main(String[] args) {
        Data data = new Data();
        producer(data);
        consumer(data);
        producer(data);
        consumer(data);
    }
    // 生产
    public static void producer(Data data){
        new Thread(() -> {
            while (true) {
                try {
                    data.produced();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"生产者").start();
    }
    // 消费
    public static void consumer(Data data){
        new Thread(() -> {
            while (true) {
                try {
                    data.consumed();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"消费者").start();
    }

    static class Data{
        int num = 0;
        Lock lock = new ReentrantLock();
        java.util.concurrent.locks.Condition con = lock.newCondition();

        public void consumed() throws InterruptedException {
            try {
                lock.lock();
                while(num == 0){
                    try {
                        con.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                num--;
                System.out.println(Thread.currentThread().getName() + " --> num: " + num);
                Thread.sleep(200);
                con.signalAll();
            } finally {
                lock.unlock();
            }
        }
        public void produced() throws InterruptedException {
            try {
                lock.lock();
                while (num > 10) {
                    try {
                        con.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                num++;
                System.out.println(Thread.currentThread().getName() + " --> num: " + num);
                Thread.sleep(200);
                con.signalAll();
            } finally {
                lock.unlock();
            }
        }
    }
}



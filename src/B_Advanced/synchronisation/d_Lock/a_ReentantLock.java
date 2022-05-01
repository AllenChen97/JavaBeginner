package B_Advanced.synchronisation.d_Lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class a_ReentantLock {
    public static void main(String[] args) throws InterruptedException {
        Account acc = new Account(1000);    // 创建一个银行账户，余额1000

        new Thread(()->acc.withDraw(600)).start();
        new Thread(()->acc.withDraw(600)).start();

    }


    static class Account{
        Integer balance;
        Lock lock = new ReentrantLock();

        public Account(int balance) {
            this.balance = balance;
        }

        public void withDraw(int amount){
            try {
                lock.lock();
                if(balance >= amount){
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }//模仿网络延迟

                    balance -= amount;
                    System.out.println(Thread.currentThread().getName() + " 取款600，余额：" + balance);
                }
                else{
                    System.out.println(Thread.currentThread().getName() + " 余额不足，余额：" + balance);
                }
            }
            finally {
                lock.unlock();
            }
        }
    }
}

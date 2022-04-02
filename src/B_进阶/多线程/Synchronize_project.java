package B_进阶.多线程;

public class Synchronize_project {
    public static void main(String[] args) throws InterruptedException {
        Account ac = new Account(1000);           //余额1000
        Thread01 t1 = new Thread01(ac);
        Thread01 t2 = new Thread01(ac);
        System.out.println("余额：" + ac.getBalance());

        t1.start();
        t2.start();

    }
}

class Thread01 extends Thread{
    Account ac;
    public Thread01(Account ac){
        this.ac = ac;
    }

    @Override
    public void run() {
        ac.withDraw(500);
        System.out.println(Thread.currentThread().getName() + "取款500，" + "余额：" + ac.getBalance());
    }
}

class Account{
    int Balance;
    public Account() {
    }

    public Account(int balance) {
        Balance = balance;
    }

    public int getBalance() {
        return Balance;
    }

    public void setBalance(int balance) {
        Balance = balance;
    }

    // 一、还能写成 public synchronized void withDraw(int amount)
    // 优点：简单
    // 缺点：①锁的只能是this 缺失灵活性；②如果共享对象锁住，整个方法体都等等待影响效率

    // 二、还能写在静态方法上 public static synchronized void withDraw(int amount) 变成类锁，就算创建了100个实例对象，锁也只有1把
    //
    // 缺点：①锁的只能是this 缺失灵活性；②如果共享对象锁住，整个方法体都等等待影响效率
    public void withDraw(int amount){
        // 三、synchronized里面放共享对象
        // this 和 this.balance都可以，因为实例变量只有1个
        // 但写在withDraw方法里面的变量不行，属于局部变量，不是共享对象
        synchronized (this){
            if(Balance-amount>=0){

                try {
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }//模仿网络延迟

                setBalance(Balance-amount);
            }
            else{
                System.out.println("余额不足");
            }
        }
    }
}

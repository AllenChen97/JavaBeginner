package B_Advanced.Concurrency.a_Basic;

public class Synchronize_BankAccount {
    public static void main(String[] args) throws InterruptedException {
        Account acc = new Account(1000);    // 创建一个银行账户，余额1000

        User u1 = new User(acc); User u2 = new User(acc);

        u1.start(); u2.start();

    }
    static class User extends Thread{
        Account ac;
        public User(Account ac){
            this.ac = ac;
        }

        @Override
        public void run() {
            ac.withDraw(600);
        }
    }

    static class Account{
        Integer balance;

        public Account(int balance) {
            this.balance = balance;
        }

        // 一、还能写成 public synchronized void withDraw(int amount)
        // 优点：简单
        // 缺点：①锁的只能是this 缺失灵活性；②如果共享对象锁住，整个方法体都等等待影响效率

        // 二、还能写在静态方法上 public static synchronized void withDraw(int amount) 变成类锁，就算创建了100个实例对象，锁也只有1把
        // 缺点：①锁的只能是this 缺失灵活性；②如果共享对象锁住，整个方法体都等等待影响效率
        public void withDraw(int amount){
            // 三、synchronized里面放共享对象
            // this 和 this.balance都可以，因为实例变量只有1个
            // 但写在withDraw方法里面的变量不行，属于局部变量，不是共享对象
            synchronized (this.balance){
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
        }
    }
}



package B_Advanced.Concurrency.a_Basic;

/*
 * 创建线程的第二种方法(推荐)：
 *   写一个类实现Runnable接口,重写run方法，放在Thread对象里
 * 特点：
 *   因接口可以多继承，保留类的继承位置
 * */

public class b_Runable {

    public static void main(String[] args) {
        loopRunable loopRunable = new loopRunable();

        Thread t1 = new Thread(loopRunable,"线程1");
        Thread t2 = new Thread(loopRunable,"线程2");
        Thread t3 = new Thread(loopRunable,"线程3");

        t1.start();
        t2.start();
        t3.start();
    }

    static class loopRunable implements Runnable{
        int num; //如果多个线程同时对num操作会出现 write-write 等问题
        @Override
        public void run(){
            for (int i=0;i<10;i++) {
                System.out.println(Thread.currentThread().getName() + "--> 走到第" + i + "步");

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}



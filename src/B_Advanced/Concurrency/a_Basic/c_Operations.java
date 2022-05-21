package B_Advanced.Concurrency.a_Basic;

/*
* setPriorities 优先级越高 抢到时间片的概率就越高
* Thread.yield() 静态方法，当前线程让位给其他线程，暂不抢夺时间片
* t.join() t合并到当前线程，当前线程阻塞，直到t处理完
* ac1.setDaemon(true);  //设置为守护线程，其他线程执行完就自动结束
* */
public class c_Operations {
    public static void main(String[] args) throws InterruptedException {
        loopThread ac1 = new loopThread();
        ac1.start();

        for (int i=0;i<10;i++) {
            System.out.println("Main" + " -->" + i);
            Thread.sleep(300);
//            if (i==7) Thread.yield(); //静态方法，当前线程让位给其他线程，暂不抢夺时间片
            if (i==7) ac1.join(); //t合并到当前线程，当前线程阻塞，直到t处理完

        }
    }

    static class loopThread extends Thread{
        @Override
        public void run(){
            try {
                loop("Thread");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public static void loop(String method) throws InterruptedException {
        for (int i=0;i<10;i++) {
            System.out.println(method + " -->" + i);
            Thread.sleep(300);
        }
    }

}

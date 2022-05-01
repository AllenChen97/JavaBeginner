package B_Advanced.synchronisation.b_Interruption;

public class Interrupt {
    public static void main(String[] args) {
        Thread t = new Thread(new Count_100s());
        t.start();
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("线程休息:"+i);
        }
        t.interrupt();  // 方法1：强行中断线程
    }

    static class Count_100s implements Runnable{

        boolean flag = true; // 设置flag，在run方法中套一个while(flag)的死循环，并设置时机改为false让其停止

        @Override
        public void run(){
            try {
                Thread.sleep(1000000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}

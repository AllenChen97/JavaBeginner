package E_多线程;
/*
* 创建线程的第一种方法：
*   写一个类继承Thread,重写run方法，然后new这个类 就是一个线程
* 特点：
*   编写简单
* https://blog.csdn.net/weixin_45393094/article/details/106426281
* */
public class Synchronize1 {
    public static void main(String[] args) {
        Test ac1 = new Test();
        System.out.println(ac1.getName());      //打印线程名称
        ac1.setName("测试线程");                  //修改线程名称
        System.out.println(ac1.getName());      //打印线程名称

        ac1.setDaemon(true);                    //设置为守护线程，用户线程执行完就自动结束
        ac1.start();

        int j = 0;
        for (int i=0;j<10;j++) {
            System.out.println("Main -->" + j++);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Test extends Thread{
    int i = 0;
    public void run(){
        for (int i=0;i<10;i++) {
            System.out.println("Thread -->" + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

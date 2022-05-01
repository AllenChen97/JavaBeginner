package B_Advanced.synchronisation.a_Basic;
/*
* 创建线程的第一种方法：
*   写一个类继承Thread,重写run方法，然后new这个类 就是一个线程
* 特点：
*   编写简单
* https://blog.csdn.net/weixin_45393094/article/details/106426281
* */
public class a_Thread {
    public static void main(String[] args) {
        loopThread ac1 = new loopThread();
        System.out.println(ac1.getName());      //打印线程名称
        ac1.setName("测试线程");                  //修改线程名称
        System.out.println(ac1.getName());      //打印线程名称

        ac1.start();

        loop("Main");

    }
    static class loopThread extends Thread{
        @Override
        public void run(){
            loop("Thread");
        }
    }
    public static void loop(String method){
        for (int i=0;i<10;i++) {
            System.out.println(method + " -->" + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}



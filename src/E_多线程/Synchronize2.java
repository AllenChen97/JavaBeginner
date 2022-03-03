package E_多线程;

/*
 * 创建线程的第二种方法(推荐)：
 *   写一个类实现Runnable接口,重写run方法，放在Thread对象里
 * 特点：
 *   因接口可以多继承，保留类的继承位置
 * */

public class Synchronize2 {
    public static void main(String[] args) {
        Thread ft = new Thread(new Test2());

        Thread t = new Thread(ft);
        t.start();
    }
}

class Test2 implements Runnable{
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

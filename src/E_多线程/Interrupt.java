package E_多线程;

public class Interrupt {
    public static void main(String[] args) {
        Count_100s t = new Count_100s();
        t.start();
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("线程休息:"+i);
        }
        t.interrupt();//终端睡眠

    }
}
class Count_100s extends Thread{
    public void run(){
        try {
            Thread.sleep(10000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
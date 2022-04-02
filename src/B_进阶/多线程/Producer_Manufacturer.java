package B_进阶.多线程;

import java.util.ArrayList;

public class Producer_Manufacturer {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        Producer p = new Producer(list);
        Manufacturer m = new Manufacturer(list);

        p.start();
        m.start();

    }
}

class Producer extends Thread{
    ArrayList list;
    public Producer() {
    }

    public Producer(ArrayList list) {
        this.list = list;
    }

    @Override
    public void run() {
        while(true){
            synchronized (this.list){
                if(this.list.size()>0){
                    try {
                        this.list.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                this.list.add(new Object());
                System.out.println(Thread.currentThread().getName() + "-->" + this.list.size());

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                list.notifyAll();
            }
        }
    }
}

class Manufacturer extends Thread{
    ArrayList list;
    public Manufacturer() {
    }

    public Manufacturer(ArrayList list) {
        this.list = list;
    }

    @Override
    public void run() {
        while(true){
            synchronized (this.list){
                if(this.list.size()==0){
                    try {
                        this.list.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                this.list.remove(0);
                System.out.println(Thread.currentThread().getName() + "-->" + this.list.size());

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                list.notifyAll();
            }
        }
    }
}


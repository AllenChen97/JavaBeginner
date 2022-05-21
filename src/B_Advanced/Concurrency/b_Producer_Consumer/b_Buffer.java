package B_Advanced.Concurrency.b_Producer_Consumer;

import java.util.concurrent.TimeUnit;

/**
 * 生产一个消费一个，利用synchronize来锁住共享的操作对象，
 * 信号控制法：利用product中的flag信号来控制
 * */
public class b_Buffer {
    public static void main(String[] args) {

        Product prd = new Product("草莓挞");

        new Thread(() -> {
            while(true){
                try {
                    prd.consumed();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "Consumer").start();
        new Thread(() -> {
            while(true) {
                try {
                    prd.produced();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "Producer").start();

    }

    static class Product{
        String single_product;
        Boolean flag;

        public Product(String single_product) {
            this.single_product = single_product;
            flag = false; // 默认没货
        }

        public void consumed() throws InterruptedException {
            // 有货就消费
            synchronized(this.flag){
                if(flag){
                    try {
                        flag.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                flag = !flag;
                System.out.println("消费1个" + " --> " + single_product);
                TimeUnit.SECONDS.sleep(3);
                flag.notifyAll();
            }
        }
        public void produced() throws InterruptedException {
            // 没货就生产
            synchronized(this.flag) {
                if (!flag) {
                    try {
                        flag.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                flag = !flag;
                System.out.println("生产1个" + " --> " + single_product);
                TimeUnit.SECONDS.sleep(3);
                flag.notifyAll();
            }
        }
    }


//        public synchronized void consumed() throws InterruptedException {
//            // 有货就消费
//            while(true){
//                if(flag){
//                    try {
//                        this.wait();
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//                flag = !flag;
//                System.out.println("消费1个" + " --> " + single_product);
//                Thread.sleep(300);
//                this.notifyAll();
//            }
//        }
//        public synchronized void produced() throws InterruptedException {
//            // 没货就生产
//            while(true){
//                if(!flag){
//                    try {
//                        this.wait();
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//                flag = !flag;
//                System.out.println("生产1个" + " --> " + single_product);
//                Thread.sleep(300);
//                this.notifyAll();
//            }
//        }
//    }

}






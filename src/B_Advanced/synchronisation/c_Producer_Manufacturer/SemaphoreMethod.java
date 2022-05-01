package B_Advanced.synchronisation.c_Producer_Manufacturer;

/**
 * 生产一个消费一个，利用synchronize来锁住共享的操作对象，
 * 信号控制法：利用product中的flag信号来控制
 * */
public class SemaphoreMethod {
    public static void main(String[] args) {
        Product prd = new Product("草莓挞");
        Producer p = new Producer(prd);
        Consumer m = new Consumer(prd);

        p.start();
        m.start();

    }

    // 消费者
    static class Consumer extends Thread{
        Product prd;
        public Consumer(Product prd) {
            this.prd = prd;
        }
        @Override
        public void run() {
            while(true){
                try {
                    prd.consumed();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    // 生产者
    static class Producer extends Thread{
        Product prd;
        public Producer(Product prd) {
            this.prd = prd;
        }
        @Override
        public void run() {
            while(true) {
                try {
                    prd.produced();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
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
                Thread.sleep(400);
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
                Thread.sleep(400);
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






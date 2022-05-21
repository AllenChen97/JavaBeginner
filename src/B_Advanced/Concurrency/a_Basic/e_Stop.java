package B_Advanced.Concurrency.a_Basic;

/*
* t.stop已过时，不能再继续使用，要结束线程建议用一个布尔值去判断线程是否该停止，
* 好处：
*   t.stop()是直接把线程给干掉，不能保存线程执行的数据
*   而布尔判断可以在else后面 return之前进行保存
* */
@Deprecated
public class e_Stop {
    public static void main(String[] args) {
        Count_100s_optimized t = new Count_100s_optimized();//创建线程
        t.start();
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("线程休息:" + i);
        }
        t.stop(); // 方法2：thread.stop 已过时

    }
    // 方法3：flag控制
    static class Count_100s_optimized extends Thread{
        boolean flag = true;
        public void run(){
            if(flag) {               //什么时候先结束线程吧run改成false就可以了
                try {
                    Thread.sleep(10000000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            else{
                //！！此处可以进行保存数据等操作
                return;
            }
        }
    }

}


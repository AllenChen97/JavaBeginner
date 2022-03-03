package E_多线程;
/*
* setPriorities 优先级越高 抢到时间片的概率就越高
* Thread.yield() 静态方法，当前线程让位给其他线程，暂不抢夺时间片
* t.join() t合并到当前线程，当前线程阻塞，直到t处理完
* */
public class Priority {
    public static void main(String[] args) {
        Count_100s t = new Count_100s();

    }
}

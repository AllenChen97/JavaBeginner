package B_Advanced.Concurrency.c_Lock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class d_ReentrantReadWriteLock {
    public static void main(String[] args) {
        Buffer buffer = new Buffer();
        for (int i = 0; i < 10; i++) {
            final int tmp = i;
            new Thread(() -> {
                buffer.put(tmp+"", tmp+"");
            }, String.valueOf(i)).start();
        }

        for (int i = 0; i < 10; i++) {
            final int tmp = i;
            new Thread(() -> {
                buffer.read(tmp+"");
            }, String.valueOf(i)).start();
        }
    }

    static class Buffer{
        private volatile Map<String,Object> map = new HashMap<>();
        private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
        public void put(String key, String value){
            lock.writeLock().lock();
            try {
                map.put(key,value);
                System.out.println(key + "写入成功");
            } finally {
                lock.writeLock().unlock();
            }
        }
        public void read(String key){
            lock.readLock().lock();
            try {
                System.out.println(map.get(key) + "读取成功");
                ;
            } finally {
                lock.readLock().unlock();
            }
        }

    }
}

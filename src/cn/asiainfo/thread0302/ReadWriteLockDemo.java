package cn.asiainfo.thread0302;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 读写锁测试
 */
public class ReadWriteLockDemo {
    //建立一个重入锁对象
    private static Lock lock = new ReentrantLock();
    //建立一个读写锁对象
    private static ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    //建立一个读锁对象
    private static Lock readLock = readWriteLock.readLock();
    //建立一个写锁对象
    private static Lock writeLock = readWriteLock.writeLock();

    private int value;

    public Object handleRead(Lock lock) throws InterruptedException{
        try{
            lock.lock();    //模拟读操作
            Thread.sleep(1000); //读操作耗时越多，读写锁优势越明显
            return value;
        }finally {
            lock.unlock();
        }
    }

    public  void handleWrite(Lock lock, int index) throws InterruptedException{
        try{
            lock.lock();    //模拟写操作
            Thread.sleep(1000);
            value = index;
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        final ReadWriteLockDemo demo = new ReadWriteLockDemo();
        Runnable readRunnable = new Runnable() {
            @Override
            public void run() {
                try {
                    demo.handleRead(readLock);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Runnable  writeRunnable = new Runnable() {
            @Override
            public void run() {
                try {
                    demo.handleWrite(lock, new Random().nextInt());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        for (int i=0; i<18; i++){
            new Thread(readRunnable).start();
        }

        for(int i=18; i<20; i++){
            new Thread(writeRunnable).start();
        }
    }
}

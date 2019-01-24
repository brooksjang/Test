package cn.asiainfo.thread0301;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 测试重入锁的lockInterrupt()方法
 */
public class ReentrantLockTest03 implements Runnable{

    public static ReentrantLock rtLock = new ReentrantLock();

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        try{
            System.out.println(threadName + "：使用lockInterruptibly()开始获取锁");
            //获取锁
            rtLock.lockInterruptibly();
            //rtLock.lock();
            System.out.println(threadName + "：获取到了锁");
            System.out.println(threadName + "：睡了2秒钟");
            Thread.sleep(2000);
            System.out.println(threadName + "：睡醒了开始干活");
            for(int i=0; i<5; i++){
                System.out.println(threadName + "：" + i);
            }
        }catch (Exception e){
            System.out.println(threadName + "（我好像被中断了！！！）");
            e.printStackTrace();
        }finally {
            rtLock.unlock();
            System.out.println(threadName + "：释放了锁");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ReentrantLockTest03 rl = new ReentrantLockTest03();
        //建立3个线程进行测试
        Thread t1 = new Thread(rl);
        Thread t2 = new Thread(rl);
        Thread t3 = new Thread(rl);
        t1.start();
        t2.start();
        t3.start();
        t1.join();
        t2.join();
        t3.join();
    }
    /**
     * 结论：
     *  刚开始3个线程同时强锁
     *  但一个线程抢到锁之后，他会在释放锁之前的所有执行完后后才会释放锁，
     *  剩下两个线程中的一个抢到锁的时候，也会执行完所有操作才会释放锁，
     *  剩下最后一个线程再执行剩下的动作
     */
}

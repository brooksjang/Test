package cn.asiainfo.thread0301;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 重入锁测试1：重入锁的加锁和释放锁
 */
public class ReentrantLockTest01 implements Runnable{

    //建立重入锁对象
    public static ReentrantLock rtLock = new ReentrantLock();

    public static int i = 0;

    @Override
    public void run() {
        for (int j=0; j<100000; j++){
            //加锁
            rtLock.lock();
            try{
                i++;
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                //释放锁
                rtLock.unlock();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException{
        ReentrantLockTest01 tl = new ReentrantLockTest01();
        Thread t1 = new Thread(tl);
        Thread t2 = new Thread(tl);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(i);
        //最终输出结果为：200000
    }
}

package cn.asiainfo.thread0301;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 测试：重入锁申请等待限时01：
 * boolean  tryLock(long timeout, TimeUnit unit)
 */
public class ReentrantLockTest04 implements  Runnable{

    public static ReentrantLock rtLock = new ReentrantLock();

    @Override
    public void run() {
        try{
            if(rtLock.tryLock(5, TimeUnit.SECONDS)){
                System.out.println(Thread.currentThread().getName() + "：拿到锁！");
                //拿到锁，睡5秒钟
                Thread.sleep(5000);
            }else {
                System.out.println(Thread.currentThread().getName() + "：获取线程失败！");
            }
        }catch(InterruptedException e){
            e.printStackTrace();
        }finally {
            if(rtLock.isHeldByCurrentThread()){
                System.out.println(Thread.currentThread().getName() + "：释放锁！");
                rtLock.unlock();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException{
        ReentrantLockTest04 rl = new ReentrantLockTest04();
        Thread t1 = new Thread(rl);
        Thread t2 = new Thread(rl);
        t1.start();
        t2.start();
    }
}

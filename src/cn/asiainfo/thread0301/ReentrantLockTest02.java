package cn.asiainfo.thread0301;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 重入锁测试2：中断响应
 * 如果一个线程在等待锁，它可以收到一个通知，被告知无须再等待，可以停止工作
 */
public class ReentrantLockTest02 implements Runnable{
    //建立重入锁对象trLock1
    public static ReentrantLock rtLock1 = new ReentrantLock();
    //建立重入锁对象trLock2
    public static ReentrantLock rtLock2 = new ReentrantLock();

    int lock;

    //利用构造方法，控制加锁顺序，方便造成死锁
    public ReentrantLockTest02(int lock){
        this.lock = lock;
    }

    @Override
    public void run() {
        try{
            if(lock == 1){
                /**
                 *ReentrantLock.lockInterruptibly允许线程在等待时由其它线程调用等待线程的Thread.interrupt方法来中断等待线程的等待而直接返回，
                 * 这时不用获取锁，而会抛出一个InterruptedException。
                 */
                rtLock1.lockInterruptibly();
                try{
                    Thread.sleep(500);
                }catch (InterruptedException e){
                    e.printStackTrace();
                    rtLock2.lockInterruptibly();
                }
            }else{
                rtLock2.lockInterruptibly();
                try{
                    Thread.sleep(500);
                }catch (InterruptedException e){
                    e.printStackTrace();
                    rtLock1.lockInterruptibly();
                }
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            /**
             * isHeldByCurrentThread()：查询当前线程是否保持此锁
             */
            if(rtLock1.isHeldByCurrentThread()){
                rtLock1.unlock();
            }
            if(rtLock2.isHeldByCurrentThread()){
                rtLock2.unlock();
            }
            System.out.println(Thread.currentThread().getName() + "：线程退出");
        }
    }

    public static void main(String[] args) {
        //Runnable接口实现类构造方法里的数字是干什么用的？？
        ReentrantLockTest02 r1 = new ReentrantLockTest02(1);
        ReentrantLockTest02 r2 = new ReentrantLockTest02(2);
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        t1.start();
        t2.start();
        /**
         * 中断其中一个线程
         * 如果一个占用锁的线程被interrupt()打断，则该线程释放锁
         */
        t2.interrupt();
    }
}

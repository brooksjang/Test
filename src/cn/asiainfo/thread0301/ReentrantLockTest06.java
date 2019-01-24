package cn.asiainfo.thread0301;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 测试公平锁
 */
public class ReentrantLockTest06 implements Runnable{
    int i;

    //创建公平锁
    public static ReentrantLock fairLock = new ReentrantLock(true);

    @Override
    public void run() {
        while (true){
            try{
                fairLock.lockInterruptibly();
                System.out.println(Thread.currentThread().getName() + "：获得公平锁！");
                for(int j=0; j<5; j++){
                    i++;
                    System.out.println(Thread.currentThread().getName() + "：" + i);
                }
                Thread.sleep(3000);
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                System.out.println(Thread.currentThread().getName() + "：释放公平锁！");
                fairLock.unlock();
            }
        }
    }

    public static void main(String[] args) throws  InterruptedException{
        ReentrantLockTest06 rl = new ReentrantLockTest06();
        Thread t1 = new Thread(rl);
        Thread t2 = new Thread(rl);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }
}

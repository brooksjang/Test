package cn.asiainfo.thread0301;

import java.util.concurrent.locks.ReentrantLock;

/**
 *  未完待续
 * 测试：重入锁申请等待无时间限制02：
 *  boolean  tryLock()
 */
public class ReentrantLockTest05 implements Runnable{

    //新建两个锁对象
   public static ReentrantLock rtLock1 =  new ReentrantLock();
   public static ReentrantLock rtLock2 =  new ReentrantLock();

   int lock;

   //构造方法
    public ReentrantLockTest05(int lock){
        this.lock = lock;
    }

    @Override
    public void run() {
        if(lock == 1){
            while (true){
                if(rtLock1.tryLock()){
                    System.out.println(Thread.currentThread().getName() + "：获取锁");
                    try{
                        try{
                            System.out.println(Thread.currentThread().getName() + "：睡3秒钟");
                            Thread.sleep(3000);
                        }catch (InterruptedException e){
                            e.printStackTrace();
                        }
                        if(rtLock2.tryLock()){

                        }
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }
        }

    }
}

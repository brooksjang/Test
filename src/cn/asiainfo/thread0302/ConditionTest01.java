package cn.asiainfo.thread0302;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Condition类方法测试
 */
public class ConditionTest01 implements Runnable{

    public static ReentrantLock rtLock = new ReentrantLock();

    //创建Condition对象
    public static Condition condition = rtLock.newCondition();

    @Override
    public void run() {
        try{
            rtLock.lock();
            System.out.println(Thread.currentThread().getName() + "：获取锁");
            condition.await();
            System.out.println(Thread.currentThread().getName() + "：等待");
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            rtLock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException{
        ConditionTest01 ct = new ConditionTest01();
        Thread t1 = new Thread(ct);
        t1.start();
        Thread.sleep(2000);
        System.out.println(Thread.currentThread().getName() + "：获取锁");
        //通知t1线程继续执行
        rtLock.lock();
        condition.signal();
        System.out.println(Thread.currentThread().getName() + "：释放锁");
        rtLock.unlock();
    }
}

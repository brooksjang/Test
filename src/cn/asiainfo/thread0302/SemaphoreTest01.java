package cn.asiainfo.thread0302;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * 信号量的测试：Semaphore
 */
public class SemaphoreTest01 implements Runnable{

    //创建一个许可数为5的信号量对象
    final Semaphore semp = new Semaphore(5);

    @Override
    public void run() {
        try{
            //获取许可
            semp.acquire();
            System.out.println(Thread.currentThread().getName() + "：线程获得许可！" + Thread.currentThread().getId());
            //模拟耗时操作
            System.out.println(Thread.currentThread().getName() + "：线程睡2秒钟");
            Thread.sleep(2000);
            //释放许可
            System.out.println(Thread.currentThread().getName() + "：线程释放许可！");
            semp.release();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        //建立一个有20个线程的线程池
        ExecutorService exec = Executors.newFixedThreadPool(20);
       final  SemaphoreTest01 demo = new SemaphoreTest01();
       for(int i=0; i<20; i++){
           exec.submit(demo);
       }
    }
}

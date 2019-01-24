package cn.asiainfo.thread0201;

class Thread01 extends  Thread{
    @Override
    public void run(){
        while (true){
            System.out.println(Thread.currentThread() + "running...");
            //如果当前线程被中断，则退出当前循环
            if (Thread.currentThread().isInterrupted()){
                System.out.println(Thread.currentThread() + "interrupted");
            }
            //Thread.yield();
        }
    }
}

public class TestThread{
    public static void main(String[] args) {
        Thread01 t1 = new Thread01();
        t1.start();
        Thread01 t2 = new Thread01();
        t2.start();
    }
}

package cn.asiainfo.thread0201;

/**
 * wait()与notify()测试
 */
public class WaitNotifyTest {
    private static final Object obj = new Object();

    //线程1
    public static class T1 extends  Thread{
        @Override
        public void run(){
            //wait和notify的使用都需要加锁
            synchronized (obj){
                System.out.println(System.currentTimeMillis() + "：T1 start!");
                try{
                    //手动停止T1
                    System.out.println(System.currentTimeMillis() + "：T1 wait for object");
                    obj.wait();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                System.out.println(System.currentTimeMillis() + "：T1 end") ;
            }
        }
    }

    //线程2
    public static class T2 extends  Thread{
        @Override
        public void run(){
            synchronized (obj){
                System.out.println(System.currentTimeMillis() + "：T2 start! notify one");
                //唤醒其他线程
                obj.notify();
                System.out.println(System.currentTimeMillis() + "：T2 end");
                try{
                    //该线程进入休眠状态
                    Thread.sleep(2000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }

    //main方法
    public static void main(String[] args) {
        Thread t1 = new T1();
        Thread t2 = new T2();
        t1.start();
        t2.start();
    }
}

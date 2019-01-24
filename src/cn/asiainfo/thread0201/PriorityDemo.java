package cn.asiainfo.thread0201;

/**
 * 测试线程的优先级
 */
public class PriorityDemo {
    //设置一个优先级较高的线程类
    public static class HighPriority extends Thread{
        static int count = 0;
        @Override
        public void run(){
            while(true){
                synchronized (PriorityDemo.class){
                    count++;
                    if(count > 10000){
                        System.out.println("HighPriority is complete");
                        break;
                    }
                }
            }
        }
    }

    //设置一个优先级比较低的线程
    public  static class LowPriority extends Thread{
        static  int count = 0;
        @Override
        public void run(){
            while(true){
                synchronized (PriorityDemo.class){
                    count++;
                    if(count > 10000){
                        System.out.println("LowPriority is complete");
                        break;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException{
        Thread high = new HighPriority();
        Thread low = new LowPriority();
        //给high线程设置最高优先级
        high.setPriority(Thread.MAX_PRIORITY);
        //给low线程设置最高优先级
        low.setPriority(Thread.MIN_PRIORITY);

        low.start();
        high.start();
    }
}

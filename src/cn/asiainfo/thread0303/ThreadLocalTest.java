package cn.asiainfo.thread0303;

public class ThreadLocalTest {

    public static  class MyRunnale implements  Runnable{
        private ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>();

        @Override
        public void run() {
            threadLocal.set((int)(Math.random() * 100D));
            System.out.println(Thread.currentThread().getName() + ":" + threadLocal.get());
        }
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new MyRunnale(), "A");
        Thread t2 = new Thread(new MyRunnale(), "B");
        t1.start();
        t2.start();
    }
}

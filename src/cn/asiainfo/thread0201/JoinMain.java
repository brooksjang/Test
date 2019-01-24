package cn.asiainfo.thread0201;

/**
 * 多线程join练习
 */
public class JoinMain {
    public volatile static int i=0;

    public static class AddThread extends Thread{
        @Override
        public void run(){
            //内部循环遍历i
            for (i=0; i<1000; i++);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        AddThread addThread = new AddThread();
        addThread.start();
        //addThread.join();是让main线程等待着addThread线程执行完么？？？
        addThread.join();
        System.out.println(i);
    }
}

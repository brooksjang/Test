package cn.asiainfo.thread0201;

/**
 * 测试ThreadGroup
 */
public class ThreadGroupTest implements  Runnable{

    public static void main(String[] args) {
        //创建一个线程组
        ThreadGroup tg = new ThreadGroup("PrintGroup");
        Thread t1 = new Thread(tg, new ThreadGroupTest(), "T1");
        Thread t2 = new Thread(tg, new ThreadGroupTest(), "T2");
        t1.start();
        t2.start();
        System.out.println("活动线程总数为：" + tg.activeCount());
        tg.list();
    }

    @Override
    public void run() {
        String groupAndName = Thread.currentThread().getThreadGroup().getName() + "-" + Thread.currentThread().getName();
        while (true){
            System.out.println("I am " + groupAndName);
            try {
                Thread.sleep(3000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

}

package cn.asiainfo.threadLocalTest;

/**
 * ThreadLocal类测试
 */
public class ThreadLocalTest01 {
    ThreadLocal<Long> longLocal = new ThreadLocal<Long>();
    ThreadLocal<String> strLocal = new ThreadLocal<String>();

    /**
     * 设置当前线程中变量的副本
     */
    public void set(){
        longLocal.set(Thread.currentThread().getId());
        strLocal.set(Thread.currentThread().getName());
    }

    /**
     * 获取ThreadLocal在当前线程中保存的变量副本
     */
    public long getLong(){
        return longLocal.get();
    }

    public String getStr(){
        return strLocal.get();
    }

    public static void main(String[] args) throws InterruptedException {
        final ThreadLocalTest01 test = new ThreadLocalTest01();

        //执行为当前线程中副本变量赋值
        test.set();
        System.out.println(test.getLong());
        System.out.println(test.getStr());

        //另启一个线程
        Thread thread1 = new Thread(){
          @Override
          public void run(){
              test.set();
              System.out.println(test.getLong());
              System.out.println(test.getStr());
          };
        };
        thread1.start();
        thread1.join();

        System.out.println(test.getLong());
        System.out.println(test.getStr());
    }
}

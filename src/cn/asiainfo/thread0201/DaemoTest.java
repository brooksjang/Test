package cn.asiainfo.thread0201;

/**
 * 守护线程测试
 */
public class DaemoTest {

    public static class DemoT extends Thread{
        @Override
        public void run(){
            while(true){
                System.out.println("I am alive!");
                try{
                    Thread.sleep(1000);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        }

        public static void main(String[] args) throws InterruptedException{
            Thread t = new DemoT();
            //将t设置为守护线程
            t.setDaemon(true);
            t.start();

            Thread.sleep(1000);
        }
    }
}

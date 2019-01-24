package cn.asiainfo.thread0201;

/**
 * volatile可以保证数据的可见性和有序性
 */
public class VolatileTest02 {
    private static boolean ready;
    private static int number;

    private static class ReadThread extends Thread{
        @Override
        public void run(){
            while(!ready){
                System.out.println(number);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new ReadThread().start();
        Thread.sleep(1000);
        number = 42;
        ready = true;
        Thread.sleep(1000);
    }
}
/**
 *  最终结果：打印一堆0
 *  在虚拟机的Client模式下，由于JIT并没有做足够的优化，在主线程修改ready变量的状态后，ReaderThread可以发现这个改动，并退出程序
 * 但是在Server模式下，由于系统优化的结果，ReaderThread线程无法“看到”主线程中的修改，导致ReaderThread永远无法退出（因为代码第13行判断永远不会成立）
 */

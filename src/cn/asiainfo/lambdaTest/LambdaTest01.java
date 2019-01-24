package cn.asiainfo.lambdaTest;

/**
 * Lambda表达式测试
 */
public class LambdaTest01 {
    public static void main(String[] args) {
        runThreadByLambda();    //用Lambda实现的多线程
        runThreadByInnerClass();    //匿名内部类实现的多线程
    }

    /**
     * 用Lambda实现的多线程
     */
    public static  void runThreadByLambda(){
        /**
         *  Runnable就是一个函数式接口：他只有一个方法run()方法。
         *          1、因为run()方法没有参数，所以   ->前面的()中不需要声明形参
         *          2、run返回的是void，所以不需要return。
         *          3、->后面写的代码其实就是定义在run方法内的代码。因为此处代码只有一行，所以{}也可以省略。如果此处多与一行，则无法省略。
         */
        Runnable runnable = () -> System.out.println("这是个用lambda实现的线程！");
        new Thread(runnable).start();
    }

    /**
     *  匿名内部类实现的多线程
     */
    public static void runThreadByInnerClass(){
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("这是个用匿名内部类实现的线程！");
            }
        };
        new Thread(runnable).start();
    }

}

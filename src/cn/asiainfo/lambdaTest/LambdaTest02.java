package cn.asiainfo.lambdaTest;

/**
 * Lambda表达式方法引用
 */
public class LambdaTest02 {
    public static void main(String[] args) {
        Runnable runnable = LambdaTest02 :: run;
        new Thread(runnable).start();
    }
    public  static void run(){
        System.out.println("Lambda表达式引用代码");
    }
}

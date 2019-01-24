package cn.asiainfo.others;

public class TryCathTest {
    public static void main(String[] args) {
        int[] in = {1,2,3,4,5};
        try{
            int a = in[5];
            System.out.println(a);
        }catch (ArrayIndexOutOfBoundsException e){
            //e.printStackTrace();
            System.out.println("数组越界异常");
        }
        int b = in[0] + in[3];
        System.out.println("检测catch后的代码是否执行");
        System.out.println(b);
    }
}

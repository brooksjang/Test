package cn.asiainfo.Test;

import java.util.Arrays;

/**
 * 测试StringBuilder的append()方法
 */
public class Test01 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        System.out.println(sb);
        for (int i=0; i<10; i++){
            sb.append("@" + i);
        }
        System.out.println(sb   );
        /**
         * 截串
         */
        String str = String.valueOf(sb);
        String[] strList = str.split("@");
        System.out.println(Arrays.toString(strList));
    }
}

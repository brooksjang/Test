package cn.asiainfo.others;

import java.util.Arrays;

public class Test {
    public static void main (String[] args){
        String str = "A1,A2,A3,A4,A5";
        String[] strings = str.split(",");
        System.out.println(Arrays.toString(strings));
        for (String s: strings) {
            System.out.println(s);
        }
    }
}
package cn.asiainfo.lambdaTest;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class LambdaTest07 {
    public static void main(String[] args) {
        //给出一个String类型的数组，找出其中所有大于2的元素并转成Integer类型
        distinctPrimary("1", "2", "3", "4", "5");

        //给出一个String类型的数组，找出其中各个素数，并统计其出现次数
        primaryOccurrence("1", "2", "3", "3", "4", "4", "5", "6", "6", "6");

        //reduce例子1：给出一个String类型的数组，求其中所有不重复素数的和
        distinctPrimarySum("1", "2", "3", "3", "4", "4", "5", "6", "6", "6");
    }

    /**
     * reduce例子1：给出一个String类型的数组，求其中所有不重复素数的和
     * @param number
     */
    private static void distinctPrimarySum(String... number) {
        List<String> listStr = Arrays.asList(number);
        Integer sum = listStr.stream()
                .map(e -> new Integer(e))
                .filter((Integer e) -> e > 1)
                .distinct()
                //计算所有不重复元素之和
                .reduce(0, (x, y) -> x + y);
        System.out.println("distinctPrimarySum result is: " + sum);
        //distinctPrimarySum result is: 20
    }

    /**
     * 给出一个String类型的数组，找出其中各个素数，并统计其出现次数
     * @param numbers
     */
    private static void primaryOccurrence(String... numbers) {
        List<String > listStr = Arrays.asList(numbers);
        Map<Integer, Integer> map = listStr.stream()
                .map(e -> new Integer(e))
                .filter((Integer i) -> i > 1)
                //数自身作为键，其出现次数作为值
                .collect(Collectors.groupingBy(p -> p, Collectors.summingInt(p -> 1)));
        System.out.println("primaryOccurrence result is: " + map);
        //primaryOccurrence result is: {2=1, 3=2, 4=2, 5=1, 6=3}
    }

    /**
     * 给出一个String类型的数组，找出其中所有大于2的元素并转成Integer类型
     * @param numbers
     */
    public static void distinctPrimary(String... numbers) {
        List<String> listStr = Arrays.asList(numbers);
        List<Integer> listIng = listStr.stream()    //调用stream()方法生成流
                .map(e -> new Integer(e))   //调用流的map方法把每个元素由String转成Integer，得到一个新的流
                .filter((Integer i) -> i > 2)   //过滤出新元素中值大于2的元素
                .distinct() //去掉重复元素，并得到一个新流
                .collect(Collectors.toList());  //将最终结果收集到一个List里面去
        System.out.println("distinctPrimary result is: " + listIng);
        //distinctPrimary result is: [3, 4, 5]
    }


}

package cn.asiainfo.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Test02 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        list.add("f");
        System.out.println(list.toString());
        Stream<String> stream = list.stream();
        System.out.println(stream.toString());
        Stream<String> distinctStream = stream.distinct();
        System.out.println(distinctStream);
        long count = distinctStream.count();
        System.out.println(count);
    }
}

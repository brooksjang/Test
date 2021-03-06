package cn.asiainfo.lambdaTest;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * Lambda表达式：filter过滤条件测试
 */
public class LambdaTest04 {
    public static void main(String[] args) {
        List<User> userList = new ArrayList<User>();
        userList.add(new User(18, "哈士奇"));
        userList.add(new User(16, "萨摩耶"));
        userList.add(new User(14, "杜宾犬"));
        userList.add(new User(12, "拉不拉多"));
        userList.add(new User(10, "比熊"));

        /**
         * 利用Lambda表达式集合中的元素进行条件过滤
         */
        Stream<User> userSTream = userList.stream();
        //过滤年龄大于14的
        Stream<User> stream = userSTream.filter(p -> p.getAge() > 10);
        System.out.println(stream.count());//4
    }

}


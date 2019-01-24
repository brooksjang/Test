package cn.asiainfo.lambdaTest;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * Lambda表达式：filter过滤条件测试并进行map转流操作
 */
public class LambdaTest05 {
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
        //所有的年龄大于12岁的User对象，转换为字符串50对象。现在流中只有字符串对象了。
        Stream<String> stream = userSTream.filter((User user) -> user.getAge() > 20).map((User user) -> {
            return "10";
        });
        System.out.println(stream);
        System.out.println(stream.count()); //0
    }

}


package cn.asiainfo.lambdaTest;

import java.util.ArrayList;
import java.util.List;

/**
 * Lambda表达式：foreach循环测试
 */
public class LambdaTest03 {
    public static void main(String[] args) {
        List<User> userList = new ArrayList<User>();
        userList.add(new User(18, "哈士奇"));
        userList.add(new User(16, "萨摩耶"));
        userList.add(new User(14, "杜宾犬"));
        userList.add(new User(12, "拉不拉多"));
        userList.add(new User(10, "比熊"));

        /**
         * 利用Lambda表达式对集合进行遍历
         */
        userList.forEach((User user) -> System.out.println("姓名：" + user.getName()));
    }

}

class User{
    private int age;
    private  String name;

    public User() {
    }

    public User(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
package section1.classloader;

/**
 * 应用模块名称<p>
 * 代码描述<p>
 *
 * @Author: Yummyxl
 * @Date: 2020/2/15
 */

public class Test10 {

    static {
        System.out.println("Test10 static block");
    }
    public static void main(String[] args) {

        Parent10 parent10;

        System.out.println("========");

        parent10 = new Parent10();

        System.out.println("========");

        System.out.println(parent10.a);

        System.out.println("========");

        System.out.println(Child10.b);
    }
}

class Parent10 {
    public static int a = 1;

    static {
        System.out.println("parent10 static block");
    }
}

class Child10 extends Parent10 {
    public static int b = 2;

    static {
        System.out.println("child10 static block");
    }
}

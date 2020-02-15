package section1.classloader;

/**
 * 应用模块名称<p>
 * 代码描述<p>
 *
 * @Author: Yummyxl
 * @Date: 2020/2/15
 */

public class Test11 {
    public static void main(String[] args) {
        System.out.println(Child11.a);
        Child11.doSomething();
    }
}

class Parent11 {
    public static int a = 1;

    public static void doSomething() {
        System.out.println("parent11 do something");
    }

    static {
        System.out.println("Parent11 static block");
    }
}

class Child11 extends Parent11 {

    static {
        System.out.println("Child11 static block");
    }
}

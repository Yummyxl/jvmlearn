package section1.classloader;

/**
 * 应用模块名称<p>
 * 代码描述<p>
 *
 * @Author: Yummyxl
 * @Date: 2020/2/15
 */

public class Test9 {

    static {
        System.out.println("Test 9 static boock");
    }

    public static void main(String[] args) {
        System.out.println(Child9.b);
    }
}

class Parent9 {
    public static int a = 1;

    static {
        System.out.println("Parent 9 static boock");
    }
}

class Child9 extends Parent9 {
    public static int b = 2;

    static {
        System.out.println("Child 9 static boock");
    }
}

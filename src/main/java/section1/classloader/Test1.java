package section1.classloader;

/**
 * 应用模块名称<p>
 * 代码描述<p>
 *
 * @Author: Yummyxl
 * @Date: 2020/2/14
 *
 * 对于静态字段，只有定义了该字段的类才会被初始化
 * 当类初始化要求父类全部被初始化完毕
 *
 * -XX:+TraceClassLording 用户追踪类当加载信息并打印出来
 * -XX:+TraceClassUnLording
 *
 * 最早加载Test1 因为这是main方法所在当类，入口
 */
public class Test1 {
    public static void main(String[] args) {

//        p1 static block
//        p1 hello world
        System.out.println(Child1.str);

//        p1 static block
//        c1 static block
//        c1 hello world
//        System.out.println(Child1.str2);
    }
}

class Parent1 {
    public static String str = "p1 hello world";

    static {
        System.out.println("p1 static block");
    }
}

class Child1 extends Parent1 {
    public static String str2 = "c1 hello world";

    static {
        System.out.println("c1 static block");
    }
}

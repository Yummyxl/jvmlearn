package section1.classloader;

/**
 * 应用模块名称<p>
 * 代码描述<p>
 *
 * @Author: Yummyxl
 * @Date: 2020/2/15
 *
 * 初始化一个类不会初始化它实现的接口
 * 可以把Parent7修改成class验证父类会被初始化
 * 也可以把Child7修改成接口来验证接口初始化会不会带来父接口的初始化
 * 都可以通过查看反编译代码来验证
 */

public class Test7 {

    public static void main(String[] args) {
        System.out.println(Child7.b);
    }
}

interface GraParent7 {
    public static final Thread t = new Thread() {
        {
            // 如果有输出，说明t被赋予了实例值，即Parent7类被初始化了
            System.out.println("graparent7 invoke");

        }
    };
}

interface Parent7 extends GraParent7 {

    public static final Thread t = new Thread() {
        {
            // 如果有输出，说明t被赋予了实例值，即Parent7类被初始化了
            System.out.println("parent7 invoke");

        }
    };
}

class Child7 implements Parent7 {
    public static int b = 7;

    static {
        System.out.println("child7 invoke");
    }

}

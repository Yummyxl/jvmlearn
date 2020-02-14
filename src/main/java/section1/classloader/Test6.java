package section1.classloader;

/**
 * 应用模块名称<p>
 * 代码描述<p>
 *
 * @Author: Yummyxl
 * @Date: 2020/2/14
 */

public class Test6 {
    public static void main(String[] args) {
        Singleton getinstance = Singleton.getinstance();
        System.out.println(Singleton.a);
        System.out.println(Singleton.b);
    }
}

class Singleton {

    public static int a;
//    public static int b = 0;
    public static Singleton singleton = new Singleton();

    private Singleton() {
        a++;
        b++; //准备阶段的意义 如果没准备阶段赋初值的话，在这里b是没有值的
    }
    public static int b = 0;
    public static Singleton getinstance() {
        return singleton;
    }
}

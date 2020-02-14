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
//    public static Singleton singleton = new Singleton();
    public static int b = 0;
    public static Singleton singleton = new Singleton();

    private Singleton() {
        a++;
        b++;
    }

    public static Singleton getinstance() {
        return singleton;
    }
}

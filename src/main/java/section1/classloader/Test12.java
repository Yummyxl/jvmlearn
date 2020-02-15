package section1.classloader;

/**
 * 应用模块名称<p>
 * 代码描述<p>
 *
 * @Author: Yummyxl
 * @Date: 2020/2/15
 * 调用ClassLoader的loadClass方法并不是对类对主动使用，不会导致类对初始化
 *
 */

public class Test12 {

    public static void main(String[] args) throws Exception {
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        // 不会导致CL类的初始化
        Class<?> aClass = classLoader.loadClass("section1.classloader.CL");
        System.out.println(aClass);
        System.out.println("============");
        // 导致CL类初始化
        aClass = Class.forName("section1.classloader.CL");
        System.out.println(aClass);
    }
}

class CL {
    static {
        System.out.println("CL static block");
    }
}

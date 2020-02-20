package section1.classloader;

/**
 * 应用模块名称<p>
 * 代码描述<p>
 *
 * @Author: Yummyxl
 * @Date: 2020/2/20
 *
 * 当前类加载器（CurrentClassLoader）
 *
 * 每个类都会使用自己的类加载器（加载自身类的类加载器）来加载其他类（值依赖的类）
 *
 * 线程上线文类加载器（Context ClassLoader）
 *    - jdk1.2开始引入，类Thread的getContextClassLoader和setContextClassLoader分别用来获取和设置上下文类加载器
 *    - 如果没有通过setContextClassLoader来设置classLoader的话，线程将继承父线程的上下文类加载器
 *    - java应用运行时的上下文类加载器就是系统类加载器，在线程中运行的代码可以通过该类加载器来加载类和资源
 *    - 重要性
 */

public class Test22 {

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getContextClassLoader());
        System.out.println(Thread.class.getClassLoader());
    }
}

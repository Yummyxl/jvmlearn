package section1.classloader;

import sun.misc.Launcher;

/**
 * 应用模块名称<p>
 * 代码描述<p>
 *
 * @Author: Yummyxl
 * @Date: 2020/2/17
 *
 * 在运行期，一个java类是由该类的完全限定名（binary 二进制名称）和用于加载该类的定义类加载器（defining loader）所共同决定的，如果同样
 * 名字（即完全相同的完全限定名）是由两个不同的类加载器加载的，那么这些类是不同的，即使.class类完全一样，是从一个地方加载
 */

public class Test20 {

    public static void main(String[] args) {
        System.out.println(System.getProperty("sun.boot.class.path"));
        System.out.println(System.getProperty("java.ext.dirs"));
        System.out.println(System.getProperty("java.class.path"));

        System.out.println(ClassLoader.class.getClassLoader());

        // 扩展类加载器和系统类加载器也是由启动类加载器 所加载
        System.out.println(Launcher.class.getClassLoader());
    }
}

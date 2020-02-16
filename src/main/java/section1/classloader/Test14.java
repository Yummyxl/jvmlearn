package section1.classloader;

import java.net.URL;
import java.util.Enumeration;

/**
 * 应用模块名称<p>
 * 代码描述<p>
 *
 * @Author: Yummyxl
 * @Date: 2020/2/15
 */

public class Test14 {

    public static void main(String[] args) throws Exception {

        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        System.out.println(contextClassLoader);
        String resourceName = "section1/classloader/Test14.class";
        Enumeration<URL> resources = contextClassLoader.getResources(resourceName);

        while (resources.hasMoreElements()) {
            URL url = resources.nextElement();
            System.out.println(url);
        }

        System.out.println("-----------------");

        ClassLoader testClassLoader = Test14.class.getClassLoader();
        // 系统类加载器 加载的
        System.out.println(testClassLoader);

        // 根类加载器 加载的
        System.out.println(String.class.getClassLoader());

    }
}

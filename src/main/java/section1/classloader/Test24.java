package section1.classloader;

import java.sql.Driver;
import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * 应用模块名称<p>
 * 代码描述<p>
 *
 * @Author: Yummyxl
 * @Date: 2020/2/20
 *
 * 线程上下文类加载器一般使用模式 （获取 -》 使用 -》 还原）
 * ClassLoader classLoader = Thread.currentThread.getContextCLassLoader();
 * try {
 *     Thread.currentThread.setContextClassLoader(targetTCCL);
 *     myMethod();
 * } finally {
 *     Thread.currentThread.setContextClassLoader(classLoader);
 * }
 *
 * myMethod() 调用了 Thread.currentThread.getContextCLassLoader() 来获取类加载器来做某些事情
 *
 * 如果一个类1是由类加载器A加载，那么类1的依赖类也是由相同的类加载器加载
 * ContextCLassLoader就是为了破坏Java的类加载委托机制
 * 在SPI中，通过设置上下文类加载器就可以加载SPI的实现类
 *
 * 当高层提供了统一的接口让低层去实现，同时又要在高层加载（或实例化）低层的类时，就必须要通过线程上下文类加载器来帮助高层的classLoader找到并加载低层的类
 */

public class Test24 {
    public static void main(String[] args) {

        // extClassLoader无法加载mysql驱动
        //Thread.currentThread().setContextClassLoader(Test24.class.getClassLoader().getParent());


        ServiceLoader<Driver> serviceLoader = ServiceLoader.load(Driver.class);
        Iterator<Driver> iterator = serviceLoader.iterator();

        while (iterator.hasNext()) {
            Driver driver = iterator.next();
            System.out.println("Driver : " + driver.getClass() + " classLoader : " + driver.getClass().getClassLoader());
        }
        System.out.println("当前上下文类加载器:" + Thread.currentThread().getContextClassLoader());
        System.out.println("serviceLoader 类加载器 : " + serviceLoader.getClass().getClassLoader());
        System.out.println(Driver.class.getName());
    }
}

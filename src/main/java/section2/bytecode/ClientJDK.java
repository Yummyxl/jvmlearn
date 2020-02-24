package section2.bytecode;

import java.lang.reflect.Proxy;

/**
 * 应用模块名称<p>
 * 代码描述<p>
 *
 * @Author: Yummyxl
 * @Date: 2020/2/24
 */

public class ClientJDK {

    public static void main(String[] args) {
        System.getProperties().setProperty("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        RealSubject realSubject = new RealSubject();
        DynamicSubject dynamicSubject = new DynamicSubject(realSubject);
        Class<? extends RealSubject> aClass = realSubject.getClass();
        Subject subject = (Subject) Proxy.newProxyInstance(aClass.getClassLoader(), aClass.getInterfaces(), dynamicSubject);
        System.out.println(subject.getClass()); // class在程序运行期间动态创建出来的
        System.out.println(subject.getClass().getSuperclass());
        subject.request();
    }
}
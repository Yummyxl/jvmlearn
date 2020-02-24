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
        // 添加属性可以在项目中生成 运行期生成的.class文件
        System.getProperties().setProperty("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        RealSubjectJDK realSubject = new RealSubjectJDK();
        DynamicSubjectJDK dynamicSubject = new DynamicSubjectJDK(realSubject);
        Class<? extends RealSubjectJDK> aClass = realSubject.getClass();
        SubjectJDK subject = (SubjectJDK) Proxy.newProxyInstance(aClass.getClassLoader(), aClass.getInterfaces(), dynamicSubject);
        System.out.println(subject.getClass()); // class在程序运行期间动态创建出来的
        System.out.println(subject.getClass().getSuperclass());
        subject.request();
    }
}
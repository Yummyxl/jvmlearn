package section1.classloader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * 应用模块名称<p>
 * 代码描述<p>
 *
 * @Author: Yummyxl
 * @Date: 2020/2/16
 *
 * 类的双亲 及 命名空间
 */

public class Test17 extends ClassLoader {

    private String classLoaderName;

    private final String fileExtension = ".class";

    private String path;

    public void setPath(String path) {
        this.path = path;
    }

    public Test17(String classLoaderName) {
        // 将系统类加载器作为这个类加载器的父类加载器
        super();
        this.classLoaderName = classLoaderName;
    }

    public Test17(ClassLoader classLoader, String classLoaderName) {
        // 显式指定该类加载器的父类加载器（classLoader）
        super(classLoader);
        this.classLoaderName = classLoaderName;
    }

    @Override
    public String toString() {
        return "Test16{" +
                "classLoaderName='" + classLoaderName + '\'' +
                ", fileExtension='" + fileExtension + '\'' +
                '}';
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        System.out.println("load class " + name);
        System.out.println("this classLoader is  " + classLoaderName);
        byte[] bytes = loadClassData(name);
        return defineClass(name, bytes, 0, bytes.length);
    }

    private byte[] loadClassData(String name) {
        InputStream is = null;
        byte[] data = null;
        ByteArrayOutputStream byteArrayOutputStream = null;

        try {
            name = name.replaceAll("\\.", "/");
            String fileName = path + name + fileExtension;
            is = new FileInputStream(new File(fileName));
            byteArrayOutputStream = new ByteArrayOutputStream();
            int ch = 0;
            while (-1 != (ch = is.read())) {
                byteArrayOutputStream.write(ch);
            }
            data = byteArrayOutputStream.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
                byteArrayOutputStream.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return data;
    }

    public static void main(String[] args) throws Exception {
//        Test17 test17 = new Test17("TestClassLoader17");
//        test17.setPath("/Users/bjhl/Desktop/");
//        Class<?> aClass = test17.loadClass("section1.classloader.Test1");
//        Object o = aClass.newInstance();
//        System.out.println(o);
//        System.out.println(aClass.getClassLoader());

        /*Test17 test17 = new Test17("TestClassLoader17");
        test17.setPath("/Users/bjhl/Desktop/");
        Class<?> aClass = test17.loadClass("section1.classloader.Test1");
        Object o = aClass.newInstance();
        System.out.println(o);
        System.out.println(aClass.hashCode());
        System.out.println(aClass.getClassLoader());

        System.out.println("===========");

        Test17 test171 = new Test17("TestClassLoader171");
        test171.setPath("/Users/bjhl/Desktop/");
        Class<?> aClass1 = test171.loadClass("section1.classloader.Test1");
        Object o1 = aClass.newInstance();
        System.out.println(o1);
        System.out.println(aClass1.hashCode());
        System.out.println(aClass1.getClassLoader());*/

        /*Test17 test17 = new Test17("TestClassLoader17");
        test17.setPath("/Users/bjhl/Desktop/");
        Class<?> aClass = test17.loadClass("section1.classloader.Test1");
        Object o = aClass.newInstance();
        System.out.println(o);
        System.out.println(aClass.hashCode());
        System.out.println(aClass.getClassLoader());

        System.out.println("===========");

        // 在表现形式上类加载器是继承关系，实际上类加载器是包含关系，test171和test17都是类Test17的实例，用包含关系构成了表现形式上的父子关系
        Test17 test171 = new Test17(test17,"TestClassLoader171");
        test171.setPath("/Users/bjhl/Desktop/");
        Class<?> aClass1 = test171.loadClass("section1.classloader.Test1");
        Object o1 = aClass.newInstance();
        System.out.println(o1);
        System.out.println(aClass1.hashCode());
        System.out.println(aClass1.getClassLoader());*/

        Test17 test17 = new Test17("TestClassLoader17");
        test17.setPath("/Users/bjhl/Desktop/");
        Class<?> aClass = test17.loadClass("section1.classloader.Test1");
        Object o = aClass.newInstance();
        System.out.println(o);
        System.out.println(aClass.hashCode());
        System.out.println(aClass.getClassLoader());

        System.out.println("===========");

        Test17 test171 = new Test17(test17, "TestClassLoader171");
        test171.setPath("/Users/bjhl/Desktop/");
        Class<?> aClass1 = test171.loadClass("section1.classloader.Test1");
        Object o1 = aClass.newInstance();
        System.out.println(o1);
        System.out.println(aClass1.hashCode());
        System.out.println(aClass1.getClassLoader());

        System.out.println("===========");

        Test17 test172 = new Test17(test171,"TestClassLoader172");
        test172.setPath("/Users/bjhl/Desktop/");
        Class<?> aClass2 = test172.loadClass("section1.classloader.Test1");
        Object o2 = aClass.newInstance();
        System.out.println(o2);
        System.out.println(aClass2.hashCode());
        System.out.println(aClass2.getClassLoader());
    }
}

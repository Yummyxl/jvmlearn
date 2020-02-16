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
 * 类的 卸载 -XX:+TraceClassUnloading
 */

public class Test18 extends ClassLoader {

    private String classLoaderName;

    private final String fileExtension = ".class";

    private String path;

    public void setPath(String path) {
        this.path = path;
    }

    public Test18(String classLoaderName) {
        // 将系统类加载器作为这个类加载器的父类加载器
        super();
        this.classLoaderName = classLoaderName;
    }

    public Test18(ClassLoader classLoader, String classLoaderName) {
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

        Test18 test17 = new Test18("TestClassLoader17");
        test17.setPath("/Users/bjhl/Desktop/");
        Class<?> aClass = test17.loadClass("section1.classloader.Test1");
        Object o = aClass.newInstance();
        System.out.println(o);
        System.out.println(aClass.hashCode());
        System.out.println(aClass.getClassLoader());

        test17 = null;
        aClass = null;
        o = null;

        System.gc();
        System.gc();
        System.gc();

        System.out.println("===========");

        Test18 test171 = new Test18("TestClassLoader171");
        test171.setPath("/Users/bjhl/Desktop/");
        aClass = test171.loadClass("section1.classloader.Test1");
        o = aClass.newInstance();
        System.out.println(o);
        System.out.println(aClass.hashCode());
        System.out.println(aClass.getClassLoader());
    }
}

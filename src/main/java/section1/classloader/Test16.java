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
 */

public class Test16 extends ClassLoader {

    private String classLoaderName;

    private final String fileExtension = ".class";

    public Test16(String classLoaderName) {
        // 将系统类加载器作为这个类加载器的父类加载器
        super();
        this.classLoaderName = classLoaderName;
    }

    public Test16(ClassLoader classLoader, String classLoaderName) {
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
        byte[] bytes = loadClassData(name);
        return defineClass(name, bytes, 0, bytes.length);
    }

    private byte[] loadClassData(String name) {
        InputStream is = null;
        byte[] data = null;
        ByteArrayOutputStream byteArrayOutputStream = null;

        try {
            name = name.replaceAll(".", "/");
            is = new FileInputStream(new File(name + fileExtension));
            byteArrayOutputStream = new ByteArrayOutputStream();
            int ch = 0;
            while (-1 != (ch = is.read())) {
                byteArrayOutputStream.write(ch);
            }
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
        Test16 test16 = new Test16("TestClassLoader");
        test(test16);
    }

    public static void test(ClassLoader classLoader) throws Exception {
        Class<?> aClass = classLoader.loadClass("section1.classloader.Test1");
        Object o = aClass.newInstance();
        // 此时由于双亲委托机制 还是由系统类加载器加载的
        System.out.println(o);
        System.out.println(aClass.getClassLoader());
    }
}

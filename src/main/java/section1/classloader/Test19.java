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
 */

public class Test19 extends ClassLoader {

    private String classLoaderName;

    private final String fileExtension = ".class";

    private String path;

    public void setPath(String path) {
        this.path = path;
    }

    public Test19(String classLoaderName) {
        // 将系统类加载器作为这个类加载器的父类加载器
        super();
        this.classLoaderName = classLoaderName;
    }

    public Test19(ClassLoader classLoader, String classLoaderName) {
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
        Test19 test19 = new Test19("TestClassLoader19");
        test19.setPath("/Users/bjhl/Desktop/");
        Class<?> aClass = test19.loadClass("section1.classloader.MySample");

        // 如果注释掉，那么并不会实例话MySample对象，MySample构造方法不会被调用，因此不会实例MyCat对象，就是没有对MyCat对象主动使用，不会加载MyCat对象
//        Object o = aClass.newInstance();
    }
}
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
 * 分别删掉工程target下的class文件，来查看效果
 * 1 MySample和MyCat都删除，应用类加载器加载不到，会交给自定义的类加载器Test19_1的实例加载，都加载到了
 * 2 只删除MyCat，可以正常加载MySample，由应用类加载器加载，然后加载MyCat对象，这里需要注意，是加了MySample的类加载器区加载MyCat类，（定义类加载器）是
 *   应用类加载器，所以找不到MyCat 的class文件，报错
 * 3 只删除MySample ，MySample可以被自定义加载器加载，然后自定义加载器去加载MyCat类，会先委托父类加载器去加载，最终由应用类加载器加载
 *
 *
 * 然后在MyCat中添加一句话，然后再分别实验
 *
 * 然后在MySample再添加一句,把MyCat中新加的注释掉  然后再分别实验
 */

public class Test19_1 extends ClassLoader {

    private String classLoaderName;

    private final String fileExtension = ".class";

    private String path;

    public void setPath(String path) {
        this.path = path;
    }

    public Test19_1(String classLoaderName) {
        // 将系统类加载器作为这个类加载器的父类加载器
        super();
        this.classLoaderName = classLoaderName;
    }

    public Test19_1(ClassLoader classLoader, String classLoaderName) {
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
        Test19_1 test19_1 = new Test19_1("TestClassLoader19");
        test19_1.setPath("/Users/bjhl/Desktop/");
        Class<?> aClass = test19_1.loadClass("section1.classloader.MySample");

        // 如果注释掉，那么并不会实例话MySample对象，MySample构造方法不会被调用，因此不会实例MyCat对象，就是没有对MyCat对象主动使用，不会加载MyCat对象
        Object o = aClass.newInstance();
    }
}
package section1.classloader;

/**
 * 应用模块名称<p>
 * 代码描述<p>
 *
 * @Author: Yummyxl
 * @Date: 2020/2/15
 */

public class Test8 {

    public static void main(String[] args) throws Exception {
        Class<?> aClass = Class.forName("java.lang.String");
        System.out.println(aClass.getClassLoader());

        Class<?> class2 = Class.forName("section1.classloader.C");
        System.out.println(class2.getClassLoader());
    }
}

class C {

}

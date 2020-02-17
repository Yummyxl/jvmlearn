package section1.classloader;

import java.lang.reflect.Method;

/**
 * 应用模块名称<p>
 * 代码描述<p>
 *
 * @Author: Yummyxl
 * @Date: 2020/2/17
 */

public class Test21 {

    public static void main(String[] args) throws Exception {
        Test19_1 loader1 = new Test19_1("loader1");
        Test19_1 loader2 = new Test19_1( "loader2");

        loader1.setPath("/Users/bjhl/Desktop/");
        loader2.setPath("/Users/bjhl/Desktop/");

        Class<?> aClass = loader1.loadClass("section1.classloader.MyPerson");
        Class<?> aClass1 = loader2.loadClass("section1.classloader.MyPerson");

        System.out.println(aClass == aClass1);

        Object object1 = aClass.newInstance();
        Object object2 = aClass1.newInstance();

        Method setMyPerson = aClass.getMethod("setMyPerson", Object.class);
        setMyPerson.invoke(object1, object2);

    }
}

package section1.classloader;

/**
 * 应用模块名称<p>
 * 代码描述<p>
 *
 * @Author: Yummyxl
 * @Date: 2020/2/15
 *
 * 数组的类型是jvm运行期动态生产的，但是类加载器是数组元素一样的（这是指的引用类型），如果是基本类型，没有classLoader
 */

public class Test15 {

    public static void main(String[] args) {
        String[] strings = new String[5];
        // null 根加载器
        System.out.println(strings.getClass().getClassLoader());

        System.out.println("=========");

        Test15[] test15s = new Test15[5];
        System.out.println(test15s.getClass().getClassLoader());

        System.out.println("=========");

        int[] ints = new int[5];
        // null 没有 类加载器
        System.out.println(ints.getClass().getClassLoader());

        System.out.println("=========");

        Integer[] integers = new Integer[5];
        System.out.println(integers.getClass().getClassLoader());
    }
}

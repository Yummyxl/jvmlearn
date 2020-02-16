package section1.classloader;

/**
 * 应用模块名称<p>
 * 代码描述<p>
 *
 * @Author: Yummyxl
 * @Date: 2020/2/16
 */

public class MyCat {
    public MyCat() {
        System.out.println("MyCat is loaded by " + this.getClass().getClassLoader());

        // 新添加
//        System.out.println("from my cat " + MySample.class);
    }
}

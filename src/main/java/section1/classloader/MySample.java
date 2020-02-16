package section1.classloader;

/**
 * 应用模块名称<p>
 * 代码描述<p>
 *
 * @Author: Yummyxl
 * @Date: 2020/2/16
 */

public class MySample {

    public MySample() {

        System.out.println("MySample is loaded by " + this.getClass().getClassLoader());

        new MyCat();

        // 新添加
        System.out.println("from MySample " + MyCat.class);
    }
}

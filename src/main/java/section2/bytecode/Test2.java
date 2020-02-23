package section2.bytecode;

import java.io.Serializable;

/**
 * 应用模块名称<p>
 * 代码描述<p>
 *
 * @Author: Yummyxl
 * @Date: 2020/2/22
 *
 * 自己做下这个类的.class文件解析
 */

public class Test2 implements Serializable {

    String str = "Welcome";

    private int x = 5;

    public static Integer in = 10;

    public static void main(String[] args) {
        Test2 test2 = new Test2();

        test2.setX(8);

        in = 20;
    }

    private synchronized void setX(int x) {
        this.x = x;
    }

    private void test(String str) {
        synchronized (str) {
            System.out.println("hello world");
        }
    }

    private synchronized void test2() {

    }
}
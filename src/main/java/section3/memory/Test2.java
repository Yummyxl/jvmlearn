package section3.memory;

/**
 * 应用模块名称<p>
 * 代码描述<p>
 *
 * @Author: Yummyxl
 * @Date: 2020/2/25
 *
 * 虚拟机栈溢出
 * -Xss100k
 */

public class Test2 {

    private int length;

    private void test() {
        length++;
        try {
            Thread.sleep(300L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        test();
    }

    public int getLength() {
        return length;
    }

    public static void main(String[] args) {
        Test2 test2 = new Test2();

        try {
            test2.test();
        } catch (Throwable throwable) {
            System.out.println(test2.getLength());
            System.out.println("=======================");
//            throwable.printStackTrace();
        }
    }
}

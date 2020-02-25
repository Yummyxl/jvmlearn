package section3.memory;

/**
 * 应用模块名称<p>
 * 代码描述<p>
 *
 * @Author: Yummyxl
 * @Date: 2020/2/25
 */

public class Test3 {

    public static void main(String[] args) {

        new Thread(A::method,"AAAAAAAAAAA").start();
        new Thread(B::method, "BBBBBBBBBBB").start();
    }
}

class A {

    public static synchronized void method() {
        System.out.println("method from A");
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        B.method();
    }
}

class B {
    public static synchronized void method() {
        System.out.println("method from B");
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        A.method();
    }
}

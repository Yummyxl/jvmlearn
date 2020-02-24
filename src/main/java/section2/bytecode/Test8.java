package section2.bytecode;

/**
 * 应用模块名称<p>
 * 代码描述<p>
 *
 * @Author: Yummyxl
 * @Date: 2020/2/23
 *
 * 验证静态分派和动态分派
 */

public class Test8 {

    public void test(Test8 test8) {
        System.out.println("test8 invoke test8");
    }

    public void test(Test81 test81) {
        System.out.println("test8 invoke test81");
    }

    public void test(Test811 test811) {
        System.out.println("test8 invoke test811");
    }

    public static void main(String[] args) {
        Test8 test8 = new Test81();
        Test8 test81 = new Test81();
        Test8 test811 = new Test811();
        test811.test(test81);
    }
}

class Test81 extends Test8 {

//    @Override
//    public void test(Test8 test8) {
//        System.out.println("test81 invoke test8");
//    }

    @Override
    public void test(Test81 test81) {
        System.out.println("test81 invoke test81");
    }

    @Override
    public void test(Test811 test811) {
        System.out.println("test81 invoke test811");
    }
}

class Test811 extends Test81 {

//    @Override
//    public void test(Test8 test8) {
//        System.out.println("test811 invoke test8");
//    }

    @Override
    public void test(Test81 test81) {
        System.out.println("test811 invoke test81");
    }

    @Override
    public void test(Test811 test811) {
        System.out.println("test811 invoke test811");
    }
}



package section2.bytecode;

import java.util.Date;

/**
 * 应用模块名称<p>
 * 代码描述<p>
 *
 * @Author: Yummyxl
 * @Date: 2020/2/23
 *
 * 这个例子和Test8类似 验证了静态分派和动态分派
 *
 * 针对于方法调用动态分派的过程，虚拟机会在类的方法区建立一个虚方法表的数据结构（virtual method table， vtable） 子类直接指向没有实现的父类方法入口
 * 针对于invokeinterface指令来说，虚拟机会建立接口方法表数据结构（interface method table， itable）
 *
 */

public class Test9 {

    public static void main(String[] args) {
        Animal animal = new Animal();
        Animal dog = new Dog();

        animal.test("hello");
        dog.test(new Date());
    }
}

class Animal {

    public void test(String str) {
        System.out.println("animal str");
    }

    public void test(Date date) {
        System.out.println("animal date");
    }
}

class Dog extends Animal {

    @Override
    public void test(String str) {
        System.out.println("Dog str");
    }

    @Override
    public void test(Date date) {
        System.out.println("Dog date");
    }
}
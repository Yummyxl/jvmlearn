package section2.bytecode;

/**
 * 应用模块名称<p>
 * 代码描述<p>
 *
 * @Author: Yummyxl
 * @Date: 2020/2/23
 *
 * 动态分派
 *
 * 方法动态分派涉及到一个重要概念：方法接受者。
 * invokevirtual字节码指令的多态查找流程：
 *    1 找到操作数栈顶的第一个元素所指向对象的实际类型
 *    2 如果找到实际类型与常量池当中的方法名称和方法描述符都完全相同的方法，那么就找到了正确的方法，返回
 *    3 如果没找到就沿着继承体系按照 2 中规则寻找，
 *
 */

public class Test7 {

    public static void main(String[] args) {
        Fruit apple = new Apple();

        Fruit orange = new Orange();

        apple.test(); // Method section2/bytecode/Fruit.test:()V

        orange.test(); // Method section2/bytecode/Fruit.test:()V

        apple = new Orange();

        apple.test(); // Method section2/bytecode/Fruit.test:()V
    }
}

class Fruit {

    public void test() {
        System.out.println("Fruit");
    }
}

class Apple extends Fruit {

    @Override
    public void test() {
        System.out.println("Apple");
    }
}

class Orange extends Fruit {
    @Override
    public void test() {
        System.out.println("Orange");
    }
}

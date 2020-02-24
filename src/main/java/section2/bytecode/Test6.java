package section2.bytecode;

/**
 * 应用模块名称<p>
 * 代码描述<p>
 *
 * @Author: Yummyxl
 * @Date: 2020/2/23
 *
 * 看字节码
 * 方法的静态分配
 * Grandpa g1 = new Father();
 * 以上代码中 g1 的静态类型是 Grandpa，实际类型（真正指向的类型）是 Father
 *
 * 可以得出 变量的静态类型是不会发生变化，实际类型是可以发生变化（多态的一种体现），实际类型在运行期才能确定。
 *
 * 方法重载是一种静态行为，jvm唯一能判断的依据是方法接受的参数，是根据传进的参数的静态类型来判断，来决定调用哪个版本的方法，在编译器就可以完全确定
 */

public class Test6 {

    public void test(Grandpa grandpa) {
        System.out.println("grandpa");
    }

    public void test(Father father) {
        System.out.println("father");
    }

    public void test(Son son) {
        System.out.println("son");
    }

    public static void main(String[] args) {
        Grandpa g1 = new Father();
        Grandpa g2 = new Son();

        Father father = new Son();
        Test6 test6 = new Test6();
        test6.test(g1);
        test6.test(g2);
        test6.test(father);
    }
}

class Grandpa {

}

class Father extends Grandpa{

}

class Son extends Father{

}

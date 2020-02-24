package section2.bytecode;

/**
 * 应用模块名称<p>
 * 代码描述<p>
 *
 * @Author: Yummyxl
 * @Date: 2020/2/24
 */

public class RealSubject implements Subject {

    @Override
    public void request() {
        System.out.println("real subject");
    }

    @Override
    public void request1() {
        System.out.println("real subject1");
    }
}

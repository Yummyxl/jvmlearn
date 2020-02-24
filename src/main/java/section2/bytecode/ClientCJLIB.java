package section2.bytecode;

import net.sf.cglib.proxy.Enhancer;

/**
 * 应用模块名称<p>
 * 代码描述<p>
 *
 * @Author: Yummyxl
 * @Date: 2020/2/24
 */

public class ClientCJLIB {

    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(SubjectCJLIB.class);
        enhancer.setCallback(new DynamicSubjectCJLIB());
        SubjectCJLIB subjectCJLIB = (SubjectCJLIB) enhancer.create();
        System.out.println(subjectCJLIB.getClass());
        System.out.println(subjectCJLIB.getClass().getSuperclass());
        subjectCJLIB.test1();
    }
}
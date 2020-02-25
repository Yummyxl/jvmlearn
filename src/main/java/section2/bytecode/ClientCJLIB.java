package section2.bytecode;

import net.sf.cglib.proxy.Enhancer;

import java.lang.reflect.Method;

/**
 * 应用模块名称<p>
 * 代码描述<p>
 *
 * @Author: Yummyxl
 * @Date: 2020/2/24
 */

public class ClientCJLIB {

    public static void main(String[] args) {
//        System.getProperties().setProperty("cglib.debugLocation", "/Users/bjhl/IdeaProjects/jvmlearn/src/main/java/section2");
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(SubjectCJLIB.class);
        enhancer.setCallback(new DynamicSubjectCJLIB());
        SubjectCJLIB subjectCJLIB = (SubjectCJLIB) enhancer.create();
        System.out.println(subjectCJLIB.getClass());
        System.out.println(subjectCJLIB.getClass().getSuperclass());
        subjectCJLIB.test1();

        Method[] methods = SubjectCJLIB.class.getMethods();
        for (Method method: methods) {
            System.out.println(method.getName());
        }
    }
}
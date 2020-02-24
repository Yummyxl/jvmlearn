package section2.bytecode;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 应用模块名称<p>
 * 代码描述<p>
 *
 * @Author: Yummyxl
 * @Date: 2020/2/24
 */

public class DynamicSubjectJDK implements InvocationHandler {

    private Object subject;

    public DynamicSubjectJDK(Object subject) {
        this.subject = subject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before calling " + method);

        method.invoke(subject, args);

        System.out.println("after calling " + method);

        return null;
    }
}

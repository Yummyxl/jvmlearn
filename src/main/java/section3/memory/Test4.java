package section3.memory;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;

/**
 * 应用模块名称<p>
 * 代码描述<p>
 *
 * @Author: Yummyxl
 * @Date: 2020/2/25
 *
 * 元空间溢出
 * -XX:MaxMetaspaceSize=10m 设置元空间最大为10M
 */

public class Test4 {

    public static void main(String[] args) {

        try {
            for (;;) {
                Enhancer enhancer = new Enhancer();
                enhancer.setSuperclass(Test4.class);
                enhancer.setUseCache(false);
                enhancer.setCallback((MethodInterceptor) (object, method, args1, proxy) ->
                        proxy.invokeSuper(object, args1));
                System.out.println("hello world");
                enhancer.create();
            }
        } catch (Throwable e) {
            System.out.println(1);
            e.printStackTrace();
        }

        System.out.println(2);

        try {
            for (;;) {
                Enhancer enhancer = new Enhancer();
                enhancer.setSuperclass(Test4.class);
                enhancer.setUseCache(false);
                enhancer.setCallback((MethodInterceptor) (object, method, args1, proxy) ->
                        proxy.invokeSuper(object, args1));
                System.out.println("hello world");
                enhancer.create();
            }
        } catch (Throwable e) {
            System.out.println(1);
            e.printStackTrace();
        }
    }
}

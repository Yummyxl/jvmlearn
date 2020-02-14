package section1.classloader;

/**
 * 应用模块名称<p>
 * 代码描述<p>
 *
 * @Author: Yummyxl
 * @Date: 2020/2/14
 * 常量在编译阶段会存入到调用这个常量的方法所在的类的常量池中
 * 本质上，调用的类并没有直接引用到定义常量到类，因此不会触发定义常量类到初始化
 * 注意： 这里指的是放入到Test2类到常量池中，之后Test2就和Parent2没有任何联系了
 * 甚至可以将 Parent2编译后到class文件删除
 *
 * javap 反编译class文件
 * public class type1.classloader.Test2 {
 *   public type1.classloader.Test2();
 *     Code:
 *        0: aload_0
 *        1: invokespecial #1                  // Method java/lang/Object."<init>":()V
 *        4: return
 *
 *   public static void main(java.lang.String[]);
 *     Code:
 *        0: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
 *        3: ldc           #4                  // String hello wrold
 *        5: invokevirtual #5                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
 *        8: return
 * }
 *
 * 助记符
 *  ldc 标示将 int float 或是 String 类型的常量值从常量池推送到栈顶
 *  bipush 标示将单字节 （-128 ～ 127）的常量值推送至栈顶
 *  sipush 标示将一个短整型常量值 （-32768 ～ 32767）推送至栈顶
 *  iconst_1 标示将int类型数字1推送至栈顶（iconst_m1 ~ iconst_5）
 *
 *  ICONST - Push value between -1, ..., 5, other values cause an exception
 */

public class Test2 {

    public static void main(String[] args) {

//        hello wrold
        System.out.println(Parent2.str);
    }
}

class Parent2 {

    public static final String str = "hello wrold";

    static {
        System.out.println("parent2 invoke static");
    }
}

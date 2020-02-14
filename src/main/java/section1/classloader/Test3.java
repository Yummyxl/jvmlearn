package section1.classloader;

import java.util.UUID;

/**
 * 应用模块名称<p>
 * 代码描述<p>
 *
 * @Author: Yummyxl
 * @Date: 2020/2/14
 *
 * Yummyxl-3:jvmlearn bjhl$ javap -c  target/classes/section1/classloader/Test3.class
 * Compiled from "Test3.java"
 * public class section1.classloader.Test3 {
 *   public section1.classloader.Test3();
 *     Code:
 *        0: aload_0
 *        1: invokespecial #1                  // Method java/lang/Object."<init>":()V
 *        4: return
 *
 *   public static void main(java.lang.String[]);
 *     Code:
 *        0: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
 *        3: getstatic     #3                  // Field section1/classloader/Parent3.str:Ljava/lang/String;
 *        6: invokevirtual #4                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
 *        9: return
 * }
 *
 * 常量在编译期间无法确定，那么这个值不会被放入到调用类的常量池中，
 * 这时在程序运行时，会导致主动使用这个常量所在的类，显然导致这个类的初始化。 getstatic 了 Parent3
 */

public class Test3 {
    public static void main(String[] args) {

//        parent3 invoke
//        b3ac765f-1e28-4b30-a64f-e52ccd2788e7
        System.out.println(Parent3.str);
    }
}

class Parent3 {

    public static final String str = UUID.randomUUID().toString();

    static {
        System.out.println("parent3 invoke");
    }
}

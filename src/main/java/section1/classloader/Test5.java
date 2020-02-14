package section1.classloader;

import java.util.Random;

/**
 * 应用模块名称<p>
 * 代码描述<p>
 *
 * @Author: Yummyxl
 * @Date: 2020/2/14
 * 当一个接口初始化时候不要求父接口都初始化
 * 只有在真正使用到父接口的时候（如引用接口中定义的常量）才初始化
 */

public class Test5 {

    public static void main(String[] args) {
        // 删掉编译后的Parent5 class文件 正常输出 2
        // 删掉编译后的Parent5和Child5的class文件 正常输出 2
        System.out.println(Child5.str2);
    }
}

interface Parent5 {
    int str1 = 1;
}

interface Child5 extends Parent5 {
    /**
     * Compiled from "Test5.java"
     * public class section1.classloader.Test5 {
     *   public section1.classloader.Test5();
     *     Code:
     *        0: aload_0
     *        1: invokespecial #1                  // Method java/lang/Object."<init>":()V
     *        4: return
     *
     *   public static void main(java.lang.String[]);
     *     Code:
     *        0: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
     *        3: iconst_2
     *        4: invokevirtual #4                  // Method java/io/PrintStream.println:(I)V
     *        7: return
     * }
     */
//    int str2 = 2;

    /**
     * Compiled from "Test5.java"
     * public class section1.classloader.Test5 {
     *   public section1.classloader.Test5();
     *     Code:
     *        0: aload_0
     *        1: invokespecial #1                  // Method java/lang/Object."<init>":()V
     *        4: return
     *
     *   public static void main(java.lang.String[]);
     *     Code:
     *        0: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
     *        3: getstatic     #3                  // Field section1/classloader/Child5.str2:I
     *        6: invokevirtual #4                  // Method java/io/PrintStream.println:(I)V
     *        9: return
     * }
     */
    int str2 = new Random(5).nextInt();
}


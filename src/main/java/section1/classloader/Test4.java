package section1.classloader;

/**
 * 应用模块名称<p>
 * 代码描述<p>
 *
 * @Author: Yummyxl
 * @Date: 2020/2/14
 *
 * 对于数组实例来说，其类型是jvm在运行期动态生产的，标示为 class [Lsection1.classloader.Parent4 这种形式
 * 这种生产类型的父类是Object
 * 对于数组来说，JavaDoc经常将构成数组的元素称为Component，实际上就是将数组降低一个维度后的类型
 *
 * anewarray: 标示 创建一个引用类型的数组并将其引用值压入栈顶
 * newarray: 标示 创建一个指定原始类型（int char byte float等）的数组，并将其引用值压入栈顶
 */

public class Test4 {

    public static void main(String[] args) {

//        parent4 invoke
        /*
         * public class section1.classloader.Test4 {
         *   public section1.classloader.Test4();
         *     Code:
         *        0: aload_0
         *        1: invokespecial #1                  // Method java/lang/Object."<init>":()V
         *        4: return
         *
         *   public static void main(java.lang.String[]);
         *     Code:
         *        0: new           #2                  // class section1/classloader/Parent4
         *        3: dup
         *        4: invokespecial #3                  // Method section1/classloader/Parent4."<init>":()V
         *        7: astore_1
         *        8: return
         * }
         */
//        Parent4 parent4 = new Parent4();

        //无输出
        /*
         * Compiled from "Test4.java"
         * public class section1.classloader.Test4 {
         *   public section1.classloader.Test4();
         *     Code:
         *        0: aload_0
         *        1: invokespecial #1                  // Method java/lang/Object."<init>":()V
         *        4: return
         *
         *   public static void main(java.lang.String[]);
         *     Code:
         *        0: iconst_4
         *        1: anewarray     #2                  // class section1/classloader/Parent4
         *        4: astore_1
         *        5: getstatic     #3                  // Field java/lang/System.out:Ljava/io/PrintStream;
         *        8: aload_1
         *        9: invokevirtual #4                  // Method java/lang/Object.getClass:()Ljava/lang/Class;
         *       12: invokevirtual #5                  // Method java/io/PrintStream.println:(Ljava/lang/Object;)V
         *       15: iconst_1
         *       16: newarray       int
         *       18: astore_2
         *       19: getstatic     #3                  // Field java/lang/System.out:Ljava/io/PrintStream;
         *       22: aload_2
         *       23: invokevirtual #4                  // Method java/lang/Object.getClass:()Ljava/lang/Class;
         *       26: invokevirtual #5                  // Method java/io/PrintStream.println:(Ljava/lang/Object;)V
         *       29: getstatic     #3                  // Field java/lang/System.out:Ljava/io/PrintStream;
         *       32: aload_2
         *       33: invokevirtual #4                  // Method java/lang/Object.getClass:()Ljava/lang/Class;
         *       36: invokevirtual #6                  // Method java/lang/Class.getSuperclass:()Ljava/lang/Class;
         *       39: invokevirtual #5                  // Method java/io/PrintStream.println:(Ljava/lang/Object;)V
         *       42: return
         * }
         */
        Parent4[] parent4s = new Parent4[4];

//        class [Lsection1.classloader.Parent4; jvm动态生成
        System.out.println(parent4s.getClass());

        int[] ints = new int[1];
        System.out.println(ints.getClass());
        System.out.println(ints.getClass().getSuperclass());
    }
}

class Parent4 {

    static {
        System.out.println("parent4 invoke ");
    }
}

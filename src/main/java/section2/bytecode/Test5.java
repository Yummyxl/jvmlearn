package section2.bytecode;

/**
 * 应用模块名称<p>
 * 代码描述<p>
 *
 * @Author: Yummyxl
 * @Date: 2020/2/23
 *
 * invokestatic 详解
 *
 * Classfile /Users/bjhl/IdeaProjects/jvmlearn/target/classes/section2/bytecode/Test5.class
 *   Last modified 2020-2-23; size 619 bytes
 *   MD5 checksum 86074cd222ff66c909f2be0d7d226c26
 *   Compiled from "Test5.java"
 * public class section2.bytecode.Test5
 *   minor version: 0
 *   major version: 52
 *   flags: ACC_PUBLIC, ACC_SUPER
 * Constant pool:
 *    #1 = Methodref          #7.#22         // java/lang/Object."<init>":()V
 *    #2 = Fieldref           #23.#24        // java/lang/System.out:Ljava/io/PrintStream;
 *    #3 = String             #25            // invoke static
 *    #4 = Methodref          #26.#27        // java/io/PrintStream.println:(Ljava/lang/String;)V
 *    #5 = Methodref          #6.#28         // section2/bytecode/Test5.test:()V
 *    #6 = Class              #29            // section2/bytecode/Test5
 *    #7 = Class              #30            // java/lang/Object
 *    #8 = Utf8               <init>
 *    #9 = Utf8               ()V
 *   #10 = Utf8               Code
 *   #11 = Utf8               LineNumberTable
 *   #12 = Utf8               LocalVariableTable
 *   #13 = Utf8               this
 *   #14 = Utf8               Lsection2/bytecode/Test5;
 *   #15 = Utf8               test
 *   #16 = Utf8               main
 *   #17 = Utf8               ([Ljava/lang/String;)V
 *   #18 = Utf8               args
 *   #19 = Utf8               [Ljava/lang/String;
 *   #20 = Utf8               SourceFile
 *   #21 = Utf8               Test5.java
 *   #22 = NameAndType        #8:#9          // "<init>":()V
 *   #23 = Class              #31            // java/lang/System
 *   #24 = NameAndType        #32:#33        // out:Ljava/io/PrintStream;
 *   #25 = Utf8               invoke static
 *   #26 = Class              #34            // java/io/PrintStream
 *   #27 = NameAndType        #35:#36        // println:(Ljava/lang/String;)V
 *   #28 = NameAndType        #15:#9         // test:()V
 *   #29 = Utf8               section2/bytecode/Test5
 *   #30 = Utf8               java/lang/Object
 *   #31 = Utf8               java/lang/System
 *   #32 = Utf8               out
 *   #33 = Utf8               Ljava/io/PrintStream;
 *   #34 = Utf8               java/io/PrintStream
 *   #35 = Utf8               println
 *   #36 = Utf8               (Ljava/lang/String;)V
 * {
 *   public section2.bytecode.Test5();
 *     descriptor: ()V
 *     flags: ACC_PUBLIC
 *     Code:
 *       stack=1, locals=1, args_size=1
 *          0: aload_0
 *          1: invokespecial #1                  // Method java/lang/Object."<init>":()V
 *          4: return
 *       LineNumberTable:
 *         line 13: 0
 *       LocalVariableTable:
 *         Start  Length  Slot  Name   Signature
 *             0       5     0  this   Lsection2/bytecode/Test5;
 *
 *   public static void test();
 *     descriptor: ()V
 *     flags: ACC_PUBLIC, ACC_STATIC
 *     Code:
 *       stack=2, locals=0, args_size=0
 *          0: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
 *          3: ldc           #3                  // String invoke static
 *          5: invokevirtual #4                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
 *          8: return
 *       LineNumberTable:
 *         line 16: 0
 *         line 17: 8
 *
 *   public static void main(java.lang.String[]);
 *     descriptor: ([Ljava/lang/String;)V
 *     flags: ACC_PUBLIC, ACC_STATIC
 *     Code:
 *       stack=0, locals=1, args_size=1
 *          0: invokestatic  #5                  // Method test:()V       这里main方法调用了static的test方法
 *          3: return
 *       LineNumberTable:
 *         line 20: 0
 *         line 21: 3
 *       LocalVariableTable:
 *         Start  Length  Slot  Name   Signature
 *             0       4     0  args   [Ljava/lang/String;
 * }
 * SourceFile: "Test5.java"
 *
 * + 静态解析的4种情形
 *    - 静态方法
 *    - 父类方法
 *    - 构造方法
 *    - 私有方法 （共有方法可以被重写），所以私有方法在类加载阶段可以被唯一确定
 *    - 以上四种方法成为非虚方法，他们在类加载阶段就可以将符号引用解析为直接引用（连接阶段的解析阶段），统一成为静态解析
 */

public class Test5 {

    public static void test() {
        System.out.println("invoke static");
    }

    public static void main(String[] args) {
        test();
    }
}

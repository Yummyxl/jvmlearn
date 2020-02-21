package section2.bytecode;

/**
 * 应用模块名称<p>
 * 代码描述<p>
 *
 * @Author: Yummyxl
 * @Date: 2020/2/21
 *
 * Classfile /Users/bjhl/IdeaProjects/jvmlearn/target/classes/section2/bytecode/Test1.class
 *   Last modified 2020-2-21; size 475 bytes
 *   MD5 checksum fdfd98cf30b0fe0b628de81fae962def
 *   Compiled from "Test1.java"
 * public class section2.bytecode.Test1
 *   minor version: 0
 *   major version: 52
 *   flags: ACC_PUBLIC, ACC_SUPER
 * Constant pool:
 *    #1 = Methodref          #4.#20         // java/lang/Object."<init>":()V
 *    #2 = Fieldref           #3.#21         // section2/bytecode/Test1.a:I
 *    #3 = Class              #22            // section2/bytecode/Test1
 *    #4 = Class              #23            // java/lang/Object
 *    #5 = Utf8               a
 *    #6 = Utf8               I
 *    #7 = Utf8               <init>
 *    #8 = Utf8               ()V
 *    #9 = Utf8               Code
 *   #10 = Utf8               LineNumberTable
 *   #11 = Utf8               LocalVariableTable
 *   #12 = Utf8               this
 *   #13 = Utf8               Lsection2/bytecode/Test1;
 *   #14 = Utf8               getA
 *   #15 = Utf8               ()I
 *   #16 = Utf8               setA
 *   #17 = Utf8               (I)V
 *   #18 = Utf8               SourceFile
 *   #19 = Utf8               Test1.java
 *   #20 = NameAndType        #7:#8          // "<init>":()V
 *   #21 = NameAndType        #5:#6          // a:I
 *   #22 = Utf8               section2/bytecode/Test1
 *   #23 = Utf8               java/lang/Object
 * {
 *   public section2.bytecode.Test1();
 *     descriptor: ()V
 *     flags: ACC_PUBLIC
 *     Code:
 *       stack=2, locals=1, args_size=1
 *          0: aload_0
 *          1: invokespecial #1                  // Method java/lang/Object."<init>":()V
 *          4: aload_0
 *          5: iconst_1
 *          6: putfield      #2                  // Field a:I
 *          9: return
 *       LineNumberTable:
 *         line 11: 0
 *         line 13: 4
 *       LocalVariableTable:
 *         Start  Length  Slot  Name   Signature
 *             0      10     0  this   Lsection2/bytecode/Test1;
 *
 *   public int getA();
 *     descriptor: ()I
 *     flags: ACC_PUBLIC
 *     Code:
 *       stack=1, locals=1, args_size=1
 *          0: aload_0
 *          1: getfield      #2                  // Field a:I
 *          4: ireturn
 *       LineNumberTable:
 *         line 16: 0
 *       LocalVariableTable:
 *         Start  Length  Slot  Name   Signature
 *             0       5     0  this   Lsection2/bytecode/Test1;
 *
 *   public void setA(int);
 *     descriptor: (I)V
 *     flags: ACC_PUBLIC
 *     Code:
 *       stack=2, locals=2, args_size=2
 *          0: aload_0
 *          1: iload_1
 *          2: putfield      #2                  // Field a:I
 *          5: return
 *       LineNumberTable:
 *         line 20: 0
 *         line 21: 5
 *       LocalVariableTable:
 *         Start  Length  Slot  Name   Signature
 *             0       6     0  this   Lsection2/bytecode/Test1;
 *             0       6     1     a   I
 * }
 * SourceFile: "Test1.java"
 */

public class Test1 {

    private int a = 1;

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }
}

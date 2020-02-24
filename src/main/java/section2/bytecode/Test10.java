package section2.bytecode;

/**
 * 应用模块名称<p>
 * 代码描述<p> 操作数栈详解
 *
 * @Author: Yummyxl
 * @Date: 2020/2/24
 *
 * Classfile /Users/bjhl/IdeaProjects/jvmlearn/target/classes/section2/bytecode/Test10.class
 *   Last modified 2020-2-24; size 474 bytes
 *   MD5 checksum a9ca9e5783cae3e787183072d2efa65a
 *   Compiled from "Test10.java"
 * public class section2.bytecode.Test10
 *   minor version: 0
 *   major version: 52
 *   flags: ACC_PUBLIC, ACC_SUPER
 * Constant pool:
 *    #1 = Methodref          #3.#21         // java/lang/Object."<init>":()V
 *    #2 = Class              #22            // section2/bytecode/Test10
 *    #3 = Class              #23            // java/lang/Object
 *    #4 = Utf8               <init>
 *    #5 = Utf8               ()V
 *    #6 = Utf8               Code
 *    #7 = Utf8               LineNumberTable
 *    #8 = Utf8               LocalVariableTable
 *    #9 = Utf8               this
 *   #10 = Utf8               Lsection2/bytecode/Test10;
 *   #11 = Utf8               calculate
 *   #12 = Utf8               ()I
 *   #13 = Utf8               a
 *   #14 = Utf8               I
 *   #15 = Utf8               b
 *   #16 = Utf8               c
 *   #17 = Utf8               d
 *   #18 = Utf8               result
 *   #19 = Utf8               SourceFile
 *   #20 = Utf8               Test10.java
 *   #21 = NameAndType        #4:#5          // "<init>":()V
 *   #22 = Utf8               section2/bytecode/Test10
 *   #23 = Utf8               java/lang/Object
 * {
 *   public section2.bytecode.Test10();
 *     descriptor: ()V
 *     flags: ACC_PUBLIC
 *     Code:
 *       stack=1, locals=1, args_size=1
 *          0: aload_0
 *          1: invokespecial #1                  // Method java/lang/Object."<init>":()V
 *          4: return
 *       LineNumberTable:
 *         line 11: 0
 *       LocalVariableTable:
 *         Start  Length  Slot  Name   Signature
 *             0       5     0  this   Lsection2/bytecode/Test10;
 *
 *   public int calculate();
 *     descriptor: ()I
 *     flags: ACC_PUBLIC
 *     Code:
 *       stack=2, locals=6, args_size=1    // 栈最大深度是2，表示栈最多容纳两个元素；局部变量最多为6； 参数数量是1，是默认的this。
 *                                            意思是操作数栈深度为2，方法中code局部变量表6个slot
 *          0: iconst_1                    // 将int1推到操作数栈栈顶
 *          1: istore_1                    // 将操作数栈栈顶int型数值弹出放置在局部变量表位置为1的slot
 *          2: iconst_2                    // 将int2推到操作数栈栈顶
 *          3: istore_2                    // 将操作数栈栈顶int型数值弹出放在在局部变量表位置为2的slot
 *          4: iconst_3                    // 将int3推到操作数栈栈顶
 *          5: istore_3                    // 将操作数栈栈顶int型数值弹出放在在局部变量表位置为3的slot
 *          6: iconst_4                    // 将int4推到操作数栈栈顶
 *          7: istore        4             // 将操作数栈栈顶int型数值弹出，然后放入局部变量表位置为4的slot
 *          9: iload_1                     // 将局部变量表位置为1的slot的值加载到栈顶（这里是复制）| 这也就解释了java的值传递，因为参数都存放在局部变量表，真正的操作是操作数栈，
 *         10: iload_2                     // 将局部变量表位置为2的slot的值加载到栈顶（这里是复制）| 局部变量表到操作数栈是复制局部变量内容，是基本数据类型就是基本数据类型，是引用就是复制引用过去
 *         11: iadd                        // 弹出操作数栈栈顶两个元素，执行加法，将结果压入操作数栈栈顶
 *         12: iload_3                     // 将局部变量表位置为3的slot的值加载到栈顶（这里是复制）
 *         13: isub                        // 弹出操作数栈栈顶两个元素，执行减法，将结果压入操作数栈栈顶
 *         14: iload         4             // 将局部变量表位置为3的slot的值加载到栈顶（这里是复制）
 *         16: imul                        // 弹出操作数栈栈顶两个元素，执行乘法，将结果压入操作数栈栈顶
 *         17: istore        5             // 将操作数栈栈顶int型数值弹出，然后放入局部变量表位置为5的slot
 *         19: iload         5             // 将局部变量表位置为5的slot的值加载到栈顶（这里是复制）
 *         21: ireturn                     // 将栈顶元素返回，如果操作数栈还有其他值，丢弃
 *       LineNumberTable:
 *         line 14: 0
 *         line 15: 2
 *         line 16: 4
 *         line 17: 6
 *         line 19: 9
 *         line 21: 19
 *       LocalVariableTable:
 *         Start  Length  Slot  Name   Signature
 *             0      22     0  this   Lsection2/bytecode/Test10;
 *             2      20     1     a   I
 *             4      18     2     b   I
 *             6      16     3     c   I
 *             9      13     4     d   I
 *            19       3     5 result   I
 * }
 * SourceFile: "Test10.java"
 */

public class Test10 {

    public int calculate() {
        int a = 1;
        int b = 2;
        int c = 3;
        int d = 4;

        int result = (a + b -c) * d;

        return result;
    }
}

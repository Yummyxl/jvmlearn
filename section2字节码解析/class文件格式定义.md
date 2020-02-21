```
package section2.bytecode;

public class Test1 {

    private int a = 1;

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }
}

CA FE BA BE 00 00 00 34 00 18 0A 00 04 00 14 09 00 03 00 15 07 00 16 07 00 17 01 00 01 61 01 00 01 49 01 00 
06 3C 69 6E 69 74 3E 01 00 03 28 29 56 01 00 04 43 6F 64 65 01 00 0F 4C 69 6E 65 4E 75 6D 62 65 72 54 61 62 
6C 65 01 00 12 4C 6F 63 61 6C 56 61 72 69 61 62 6C 65 54 61 62 6C 65 01 00 04 74 68 69 73 01 00 19 4C 73 65 
63 74 69 6F 6E 32 2F 62 79 74 65 63 6F 64 65 2F 54 65 73 74 31 3B 01 00 04 67 65 74 41 01 00 03 28 29 49 01 
00 04 73 65 74 41 01 00 04 28 49 29 56 01 00 0A 53 6F 75 72 63 65 46 69 6C 65 01 00 0A 54 65 73 74 31 2E 6A 
61 76 61 0C 00 07 00 08 0C 00 05 00 06 01 00 17 73 65 63 74 69 6F 6E 32 2F 62 79 74 65 63 6F 64 65 2F 54 65 
73 74 31 01 00 10 6A 61 76 61 2F 6C 61 6E 67 2F 4F 62 6A 65 63 74 00 21 00 03 00 04 00 00 00 01 00 02 00 05 
00 06 00 00 00 03 00 01 00 07 00 08 00 01 00 09 00 00 00 38 00 02 00 01 00 00 00 0A 2A B7 00 01 2A 04 B5 00 
02 B1 00 00 00 02 00 0A 00 00 00 0A 00 02 00 00 00 0B 00 04 00 0D 00 0B 00 00 00 0C 00 01 00 00 00 0A 00 0C 
00 0D 00 00 00 01 00 0E 00 0F 00 01 00 09 00 00 00 2F 00 01 00 01 00 00 00 05 2A B4 00 02 AC 00 00 00 02 00 
0A 00 00 00 06 00 01 00 00 00 10 00 0B 00 00 00 0C 00 01 00 00 00 05 00 0C 00 0D 00 00 00 01 00 10 00 11 00 
01 00 09 00 00 00 3E 00 02 00 02 00 00 00 06 2A 1B B5 00 02 B1 00 00 00 02 00 0A 00 00 00 0A 00 02 00 00 00 
14 00 05 00 15 00 0B 00 00 00 16 00 02 00 00 00 06 00 0C 00 0D 00 00 00 00 00 06 00 05 00 06 00 01 00 01 00 
12 00 00 00 02 00 13


Classfile /Users/bjhl/IdeaProjects/jvmlearn/target/classes/section2/bytecode/Test1.class
  Last modified 2020-2-21; size 475 bytes
  MD5 checksum fdfd98cf30b0fe0b628de81fae962def
  Compiled from "Test1.java"
public class section2.bytecode.Test1
  minor version: 0
  major version: 52
  flags: ACC_PUBLIC, ACC_SUPER
Constant pool:
   #1 = Methodref          #4.#20         // java/lang/Object."<init>":()V
   #2 = Fieldref           #3.#21         // section2/bytecode/Test1.a:I
   #3 = Class              #22            // section2/bytecode/Test1
   #4 = Class              #23            // java/lang/Object
   #5 = Utf8               a
   #6 = Utf8               I
   #7 = Utf8               <init>
   #8 = Utf8               ()V
   #9 = Utf8               Code
  #10 = Utf8               LineNumberTable
  #11 = Utf8               LocalVariableTable
  #12 = Utf8               this
  #13 = Utf8               Lsection2/bytecode/Test1;
  #14 = Utf8               getA
  #15 = Utf8               ()I
  #16 = Utf8               setA
  #17 = Utf8               (I)V
  #18 = Utf8               SourceFile
  #19 = Utf8               Test1.java
  #20 = NameAndType        #7:#8          // "<init>":()V
  #21 = NameAndType        #5:#6          // a:I
  #22 = Utf8               section2/bytecode/Test1
  #23 = Utf8               java/lang/Object
{
  public section2.bytecode.Test1();
    descriptor: ()V
    flags: ACC_PUBLIC
    Code:
      stack=2, locals=1, args_size=1
         0: aload_0
         1: invokespecial #1                  // Method java/lang/Object."<init>":()V
         4: aload_0
         5: iconst_1
         6: putfield      #2                  // Field a:I
         9: return
      LineNumberTable:
        line 11: 0
        line 13: 4
      LocalVariableTable:
        Start  Length  Slot  Name   Signature
            0      10     0  this   Lsection2/bytecode/Test1;

  public int getA();
    descriptor: ()I
    flags: ACC_PUBLIC
    Code:
      stack=1, locals=1, args_size=1
         0: aload_0
         1: getfield      #2                  // Field a:I
         4: ireturn
      LineNumberTable:
        line 16: 0
      LocalVariableTable:
        Start  Length  Slot  Name   Signature
            0       5     0  this   Lsection2/bytecode/Test1;

  public void setA(int);
    descriptor: (I)V
    flags: ACC_PUBLIC
    Code:
      stack=2, locals=2, args_size=2
         0: aload_0
         1: iload_1
         2: putfield      #2                  // Field a:I
         5: return
      LineNumberTable:
        line 20: 0
        line 21: 5
      LocalVariableTable:
        Start  Length  Slot  Name   Signature
            0       6     0  this   Lsection2/bytecode/Test1;
            0       6     1     a   I
}
SourceFile: "Test1.java"

```

1. 使用javap -verbose命令分析一个字节码文件时，将会分析该字节码文件的魔数，版本号，常量池，类信息，类的构造方法，类的方法信息，类变量及成员变量等信息

2.  魔数: 所有的.class文件字节码文件的***前四个字节***都是魔数，魔术值为固定值 ***0xCAFEBABE***

3. 然后 minor version ***两个字节*** 然后major version ***两个字节*** 这里 00 00 00 34，00 00 代表次版本号，十进制 0，00 34 主版本号换成十进制是52

4. 常量池（constant pool）然后就是***常量池（一个java类定义的很多信息都是由常量池来维护和描述，可以将常量池看作是class文件的资源仓库，比如说java类中
定义的方法和变量信息，都是存储在常量池中。常量池中主要存储两类变量，字面量和符号引用，字面量如文本字符串，java类中生命为final的常量值等；而符号引用，比如说
类和接口的全局限定名，字段的名称和描述符，方法的名称和描述符等）***入口 第九个字节开始，然后具体成都不确定。

5. 常量池的总体结构：java类所对应的常量池主要由常量池数量和常量池数组（常量表）两部分构成。常量池数量紧根在主版本后面，占***两个字节***，常量池数组紧跟在常量池
数量后边，常量池数组中不同的元素的类型、结构都是不同的，长度当然也不同，但是每一种元素的第一个数据都是***u1类型***，该字节是标志为，占据一个字节，jvm在解析
常量池时，会根据这个u1类型来获取元素的具体类型。***需要注意的是，常量池中数组元素的个数是 常量池数 - 1 （0号暂时不实用）***，目的是满足某些常量池索引值
数据在特定情况下需要表达不引用任何一个常量池的含义，根本原因是，索引值为0也是一个常量（保留常量），只不过他不位于常量池中，这个常量对应null值，所以常量池索引从
1开始而不是0。常量池数据类型如图所示


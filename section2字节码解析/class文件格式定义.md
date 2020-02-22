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

以上分别为源代码、class文件十六进制数据 和 十六进制文件反解析代码
以下分别对照（需要查类型对照表）

***魔数***             CA FE BA BE （以上为固定魔数 四个字节） 
***次版本号***         00 00 （次版本号 两个字节）
***主版本号***         00 34 （主版本号 两个字节）
***常量池数组长度***    00 18 （常量池数组长度24 说明常量池数组23个元素）
***常池一***           0A（第一个常量标志位 值 10 代表 methodref） 00 04 （索引值为4 代表声明方法类描述符的索引项） 00 14（索引值为20 代表名称及类型描述符的索引项） 
***常池二***           09 (值为9 代表 fieldref) 00 03 （索引值为3 代表声明字段的类描述符索引项） 00 15 （21 代表字段描述符的索引项） 
***常池三***           07 (值为7 代表 class) 00 16 （22 代表 类全限定名常量的索引项） 
***常池四***           07 (值为7 代表 class) 00 17  (23 代表 类全限定名常量的索引项) 
***常池五***           01 (值为1 代表 utf8 字符串常量) 00 01 (长度为1 个字节) 61 （utf8编码的字符串） 
***常池六***           01 (值为1 代表utf8的字符串常量) 00 01 (长度为1 个字节) 49  (utf8编码的字符串) 
***常池七***           01 (值为1 代表utf8的字符串常量) 00 06 (长度为6 个字节) 3C 69 6E 69 74 3E (utf8编码的字符串)
***常池八***           01 00 03 28 29 56 
***常池九***           01 00 04 43 6F 64 65 
***常池十***           01 00 0F 4C 69 6E 65 4E 75 6D 62 65 72 54 61 62 6C 65 
***常池十一***         01 00 12 4C 6F 63 61 6C 56 61 72 69 61 62 6C 65 54 61 62 6C 65 
***常池十二***         01 00 04 74 68 69 73 
***常池十三***         01 00 19 4C 73 65 63 74 69 6F 6E 32 2F 62 79 74 65 63 6F 64 65 2F 54 65 73 74 31 3B 
***常池十四***         01 00 04 67 65 74 41 
***常池十五***         01 00 03 28 29 49 
***常池十六***         01 00 04 73 65 74 41 
***常池十七***         01 00 04 28 49 29 56 
***常池十八***         01 00 0A 53 6F 75 72 63 65 46 69 6C 65 
***常池十九***         01 00 0A 54 65 73 74 31 2E 6A 61 76 61 
***常池二十***         0C (值为12 代表nameAndType) 00 07 （7 代表字段或方法的名称的常量的索引项） 00 08 (8 代表字段或方法的描述符的常量的索引项) 
***常池二一***         0C (值为12 代表nameAndType) 00 05 （5 代表字段或方法的名称的常量的索引项） 00 06 (6 代表字段或方法的描述符的常量的索引项) 
***常池二二***         01 00 17 73 65 63 74 69 6F 6E 32 2F 62 79 74 65 63 6F 64 65 2F 54 65 73 74 31 
***常池二三***         01 00 10 6A 61 76 61 2F 6C 61 6E 67 2F 4F 62 6A 65 63 74 
***访问标志***         00 21 （00 01 和 00 21 的并集）
***当前类名***         00 03 (当前类 指向常量池中 索引为3的项)
***父类名字***         00 04 (父类 指向常量池中 索引为4的项)
***接口数量***         00 00（0 无接口）
***接口数组***
***字段数量***         00 01 （1 代表一个字段）
***字段一***           00 02 （访问标志 图中没有列出，代表private）00 05 （5 名字在常量池中索引项） 
                      00 06 （6 描述符在常量池中索引）00 00 (0 attributes count 为 0) 数量为0 所以attribute没有描述信息
***方法数量***         00 03 （3 代表三个方法）
***方法一***           00 01 （访问标志 ACC_PUBLIC）00 07 (7 名字索引指向常量池中索引项7 init) 00 08 （8 描述符 指向常量池中索引项8）
                      00 01 （1 attributes count 为 1）
                      属性一 00 09 （9 名字 指向常量池中索引项9 code）00 00 00 38 （56 占据56字节作为code的值） 00 02 (2 max_stack) 00 01 (1 max_local) 
                             00 00 00 0A ( 10 code_length ) 2A B7 00 01 2A 04 B5 00 02 B1 (code[10] 指令码)
                             00 00 (0 exception_table长度) 
                             00 02（2 方法属性长度） 
                             line一 00 0A （10 名字索引 常量池中索引为10） 00 00 00 0A （长度为10） 00 02 00 00 00 0B 00 04 00 0D 
                             line二 00 0B （11 名字索引 常量池中索引为11） 00 00 00 0C （长度为12） 00 01 00 00 00 0A 00 0C 00 0D 00 00 
***方法二***           00 01（访问标志 ACC_PUBLIC） 00 0E (14 名字索引指向常量池中索引项14 getA) 00 0F (15 描述符 指向常量池中索引15) 
                      00 01 （1 attributes count 为 1）
                      属性一 00 09（9 名字 指向常量池中索引项9 code）00 00 00 2F （47 占据47字节作为code值） 00 01 (1 max_stack) 00 01 (1 max_local) 
                            00 00 00 05 ( 5 code_length ) 2A B4 00 02 AC (code[5] 指令码) 
                            00 00 (0 exception_table长度) 
                            00 02 （2 方法属性长度） 
                            line一 00 0A （10 名字索引 常量池中索引为10） 00 00 00 06 （长度为6） 00 01 00 00 00 10 
                            line二 00 0B （11 名字索引 常量池中索引为11） 00 00 00 0C （长度为12）00 01 00 00 00 05 00 0C 00 0D 00 00 
***方法三***           00 01（访问标志 ACC_PUBLIC） 00 10(16 名字索引指向常量池中索引项16 setA) 00 11 (17 描述符 指向常量池中索引17) 
                      00 01 （1 attributes count 为 1）
                      00 09 （9 名字 指向常量池中索引项9 code）00 00 00 3E （63 占据63字节作为code值）00 02 (2 max_stack) 00 02 (1 max_local) 
                      00 00 00 06 ( 6 code_length ) 2A 1B B5 00 02 B1  (code[6] 指令码)
                      00 00 (0 exception_table长度) 
                      00 02 （2 方法属性长度）
                            line一 00 0A（10 名字索引 常量池中索引为10） 00 00 00 0A（长度为10） 00 02 00 00 00 14 00 05 00 15 
                            line二 00 0B（10 名字索引 常量池中索引为10） 00 00 00 16（长度为22） 00 02 00 00 00 06 00 0C 00 0D 00 00 00 00 00 06 00 05 00 06 00 01 
***attribute数量***   00 01 (1 代表1个)
***属性一***           00 12 （18 名字引用 指向常量池索引项18）00 00 00 02 （2 长度2个字节） 00 13 （19 具体内容，指向常量池中缩影项19）


Classfile /Users/bjhl/IdeaProjects/jvmlearn/target/classes/section2/bytecode/Test1.class
  Last modified 2020-2-21; size 475 bytes
  MD5 checksum fdfd98cf30b0fe0b628de81fae962def
  Compiled from "Test1.java"
public class section2.bytecode.Test1
  minor version: 0                                                             00 00 
  major version: 52                                                            00 34
  flags: ACC_PUBLIC, ACC_SUPER                                                 00 21 
Constant pool:                                                                 00 18
   #1 = Methodref          #4.#20         // java/lang/Object."<init>":()V     0A \ 00 04 : 00 14
   #2 = Fieldref           #3.#21         // section2/bytecode/Test1.a:I       09 \ 00 03 : 00 15
   #3 = Class              #22            // section2/bytecode/Test1           07 \ 00 16
   #4 = Class              #23            // java/lang/Object                  07 \ 00 17
   #5 = Utf8               a                                                   01 \ 00 01 : 61
   #6 = Utf8               I                                                   01 \ 00 01 : 49
   #7 = Utf8               <init>                                              01 \ 00 06 : 3C 69 6E 69 74 3E
   #8 = Utf8               ()V                                                 01 \ 00 03 : 28 29 56
   #9 = Utf8               Code                                                01 \ 00 04 : 43 6F 64 65
  #10 = Utf8               LineNumberTable                                     01 \ 00 0F : 4C 69 6E 65 4E 75 6D 62 65 72 54 61 62 6C 65
  #11 = Utf8               LocalVariableTable                                  01 \ 00 12 : 4C 6F 63 61 6C 56 61 72 69 61 62 6C 65 54 61 62 6C 65
  #12 = Utf8               this                                                01 \ 00 04 : 74 68 69 73
  #13 = Utf8               Lsection2/bytecode/Test1;                           01 \ 00 19 : 4C 73 65 63 74 69 6F 6E 32 2F 62 79 74 65 63 6F 64 65 2F 54 65 73 74 31 3B
  #14 = Utf8               getA                                                01 \ 00 04 : 67 65 74 41
  #15 = Utf8               ()I                                                 01 \ 00 03 : 28 29 49
  #16 = Utf8               setA                                                01 \ 00 04 : 73 65 74 41
  #17 = Utf8               (I)V                                                01 \ 00 04 : 28 49 29 56
  #18 = Utf8               SourceFile                                          01 \ 00 0A : 53 6F 75 72 63 65 46 69 6C 65
  #19 = Utf8               Test1.java                                          01 \ 00 0A : 54 65 73 74 31 2E 6A 61 76 61
  #20 = NameAndType        #7:#8          // "<init>":()V                      0C \ 00 07 : 00 08 
  #21 = NameAndType        #5:#6          // a:I                               0C \ 00 05 : 00 06
  #22 = Utf8               section2/bytecode/Test1                             01 \ 00 17 : 73 65 63 74 69 6F 6E 32 2F 62 79 74 65 63 6F 64 65 2F 54 65 73 74 31
  #23 = Utf8               java/lang/Object                                    01 \ 00 10 : 6A 61 76 61 2F 6C 61 6E 67 2F 4F 62 6A 65 63 74
{
  public section2.bytecode.Test1();                                            00 07
    descriptor: ()V                                                            00 08
    flags: ACC_PUBLIC                                                          00 01
    Code:                                                                      00 09                
      stack=2, locals=1, args_size=1                                           00 02 : 00 01 : 2A B7 00 01 2A 04 B5 00 02 B1
         0: aload_0
         1: invokespecial #1                  // Method java/lang/Object."<init>":()V
         4: aload_0
         5: iconst_1
         6: putfield      #2                  // Field a:I
         9: return
      LineNumberTable:                                                         00 0A : 00 00 00 0A : 00 02 00 00 00 0B 00 04 00 0D
        line 11: 0
        line 13: 4
      LocalVariableTable:                                                      00 0B : 00 00 00 0C : 00 01 00 00 00 0A 00 0C 00 0D 00 00           
        Start  Length  Slot  Name   Signature
            0      10     0  this   Lsection2/bytecode/Test1;

  public int getA();                                                           00 0E
    descriptor: ()I                                                            00 0F
    flags: ACC_PUBLIC                                                          00 01
    Code:                                                                      00 09
      stack=1, locals=1, args_size=1                                           00 01 : 00 01 : 2A B4 00 02 AC
         0: aload_0
         1: getfield      #2                  // Field a:I
         4: ireturn
      LineNumberTable:                                                         00 0A : 00 00 00 06 : 00 01 00 00 00 10
        line 16: 0
      LocalVariableTable:                                                      00 0B : 00 00 00 0C : 00 01 00 00 00 05 00 0C 00 0D 00 00
        Start  Length  Slot  Name   Signature
            0       5     0  this   Lsection2/bytecode/Test1;

  public void setA(int);                                                       00 10
    descriptor: (I)V                                                           00 11
    flags: ACC_PUBLIC                                                          00 01
    Code:                                                                      00 09
      stack=2, locals=2, args_size=2                                           00 02 : 00 02 : 2A 1B B5 00 02 B1
         0: aload_0
         1: iload_1
         2: putfield      #2                  // Field a:I
         5: return
      LineNumberTable:                                                         00 0A : 00 00 00 0A : 00 02 00 00 00 14 00 05 00 15
        line 20: 0
        line 21: 5 
      LocalVariableTable:                                                      00 0B : 00 00 00 16 : 00 02 00 00 00 06 00 0C 00 0D 00 00 00 00 00 06 00 05 00 06 00 01
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
![Image text](https://mmbiz.qpic.cn/mmbiz_png/BQGpt2vnVYUpW4xYLj72IhNnJqGibMAlMpHVyCx94ibZjl1E5dKfpdPwtgX7g89AlBDGzSlNR06ZAfgjQiav87EBg/0?wx_fmt=png)

6. 在JVM规范中，每个变量/字段都有描述信息，描述信息主要的作用是描述字段的数据类型，方法的参数列表（包括数量类型和顺序）以及返回值。根据描述规则，基本数据类型和
代表无返回值的void类型都用一个大些字母表示，对象类型则使用字符L加对象的全限定名称来表示。为了压缩字节码文件的体积，基本数据类型都用一个大些字母来表示，比如：
B - byte, C - char, D - double, F - float, I - int, J - long, S - short, Z - boolean, V -void, L - 对象类型,比如 Ljava/lang/String。

7. 对于数组类型，每一个维度使用一个前置的[来表示，比如int[]被记录为[I，String[][] 被记录为 [[Ljava/lang/String 

8. 用描述符描述方法时候，先参数列表后返回值的顺序来描述，参数列表按照参数的严格顺序放在一组()内，如 String getRealName(int id, String name) 表示为 
(I,Ljava/lang/String;)Ljava/lang/String;

9. 字节码文件整体结构如图所示
![Image text](https://mmbiz.qpic.cn/mmbiz_png/BQGpt2vnVYUpW4xYLj72IhNnJqGibMAlMmN7zuicQYlZRq9U1mFJZDjo8G7hWdS2ZiaQJiamb7w9NxMk4AO8qHUayg/0?wx_fmt=png)
![Image text](https://mmbiz.qpic.cn/mmbiz_png/BQGpt2vnVYUpW4xYLj72IhNnJqGibMAlMBhfUDAtsqBv53JhfgO9TswFJdpTzicicwZ6ySibic5wO8ziaspS6x9ibhmLg/0?wx_fmt=png)
![Image text](https://mmbiz.qpic.cn/mmbiz_png/BQGpt2vnVYUpW4xYLj72IhNnJqGibMAlMJNYTOOZqnX2VZSoV2mrS5cX1OsmjRX4x7pVgicto4Tic86R8xYcibh5ag/0?wx_fmt=png)

10. 然后是 访问标志（Access_Flag） 包括该Class文件是类还是接口，是否被定义为public，是否是abstract，如果是类是否是final。通过上面源代码可以知道该文件是类
并且是public。具体如图所示!
[Image text](https://mmbiz.qpic.cn/mmbiz_png/BQGpt2vnVYUpW4xYLj72IhNnJqGibMAlMTibCmHv9sbArGLHPVialOmgsYXXrSkRZfaXqM5icT2EGEZkTOhe76e2tQ/0?wx_fmt=png)
访问标志是上述图片中的并集，比如这个类是00 21，是00 01 和00 20 即 ACC_PUBLIC 和 ACC_SUPER的并集 

11. 然后是 当前类名

12. 然后是 父类名字

13. 然后是接口数量 这个类没有实现接口所以是 0

14. 然后是 接口数组

15. 然后是字段（成员变量）数量

16. 然后是 字段表集合，用于描述字段和接口中声明的变量，这里包含了类级别变量和实例级别变量，但不包括方法局部变量。如图所示
![image text](https://mmbiz.qpic.cn/mmbiz_png/BQGpt2vnVYUpW4xYLj72IhNnJqGibMAlMkPWPH2ZToKfm3vpAxkBwa275XJ98q7z5XBZe7BTR0sOkauJeq9c1WA/0?wx_fmt=png)
![image text](https://mmbiz.qpic.cn/mmbiz_png/BQGpt2vnVYUpW4xYLj72IhNnJqGibMAlMTd2HvviagHX9FNbkLp8DgECXX0Ip0ibtvZwaMgpW9icf9RKO5hfnnFiapA/0?wx_fmt=png)

17. 然后是方法数量，此类三个方法，get set 以及编译器自动生成的init方法

18. 然后是方法表，结构如图所示
![image text](https://mmbiz.qpic.cn/mmbiz_png/BQGpt2vnVYUpW4xYLj72IhNnJqGibMAlM6kD9EjyenLujNibr6YXpfDaVxHT9iaf7If8bCggk4w2XmTRViashmExAw/0?wx_fmt=png)
![image text](https://mmbiz.qpic.cn/mmbiz_png/BQGpt2vnVYUpW4xYLj72IhNnJqGibMAlMSAxqp8ap5SZDicicy8bPoa6KqcoISJUjHvR7tK9VicGUyRTCRo6UFfjsA/0?wx_fmt=png)
方法中的每个属性都是一个attribute_info 结构，如图所示
![image text](https://mmbiz.qpic.cn/mmbiz_png/BQGpt2vnVYUpW4xYLj72IhNnJqGibMAlMU8TgeWyuGMl7kn4z6JBR20AibkghP2OzvmEP7MIU3g7uYTRjv9yibHuA/0?wx_fmt=png)
Jvm预定义了部分attribute，编译器也可以实现自己的attribute写入class文件里供运行时使用，不同的attribute通过attribute_name_index来区分。
其中code attribute的作用是保存方法的结构，如图所示对应的字节码
![image text](https://mmbiz.qpic.cn/mmbiz_png/BQGpt2vnVYUpW4xYLj72IhNnJqGibMAlMEqSSZmF1HowEq2Gx8n4DkdqNvicVIJFSB4H6djjXia4U9c9Yib4tOLgxw/0?wx_fmt=png)
    + attribute_length 表示attribute所包含的字节数，不包含attribute_name_index 和 attribute_length字段
    + max_stack 表示程序执行过程中所能达到的操作数栈的最大深度
    + max_locals 表示方法执行期间创建的局部变量的数目，包含用来表示传入参数的局部变量。
    + code_length 表示该方法所包含的字节码的字节数以及具体的指令码
    + 具体字节码是该方法被调用时，jvm执行的字节码
    + exception_table 存放的是处理异常的信息
    + 每个exception_table表项由start_pc end_pc handler_pc catch_type 构成
       - start_pc end_pc表示在code数组中从start_pc 到 end_pc 处（左闭右开）的指令抛出的异常由这个表项来处理
       - handler_pc 表示处理异常的代码的开始处，catch_type表示被处理的异常类型，它指向常量池中一个异常类，当catch_type为0表示处理所有异常
    + 然后是方法的附加属性
    + LineNumberTable 这个属性用来表示code数组中的字节码和java代码行数之间的关系，可以用来在调试的时候定位代码执行的行数。结构如图所示
    ![image text](https://mmbiz.qpic.cn/mmbiz_png/BQGpt2vnVYUpW4xYLj72IhNnJqGibMAlMKJdERvqbErBMqGMoxia6RIvztaVZRZymCAsprGHGvBnic772dkpfLkEA/0?wx_fmt=png)

19. 最后是附加属性信息




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
00 06 00 00 [00 03 00 01 00 07 00 08 00 01 00 09 00 00 00 38 00 02 00 01 00 00 00 0A 2A B7 00 01 2A 04 B5 00 
02 B1 00 00 00 02 00 0A 00 00 00 0A 00 02 00 00 00 0B 00 04 00 0D 00 0B 00 00 00 0C 00 01 00 00 00 0A 00 0C 
00 0D 00 00 00 01 00 0E 00 0F 00 01 00 09 00 00 00 2F 00 01 00 01 00 00 00 05 2A B4 00 02 AC 00 00 00 02 00 
0A 00 00 00 06 00 01 00 00 00 10 00 0B 00 00 00 0C 00 01 00 00 00 05 00 0C 00 0D 00 00 00 01 00 10 00 11 00 
01 00 09 00 00 00 3E 00 02 00 02 00 00 00 06 2A 1B B5 00 02 B1 00 00 00 02 00 0A 00 00 00 0A 00 02 00 00 00 
14 00 05 00 15 00 0B 00 00 00 16 00 02 00 00 00 06 00 0C 00 0D 00 00 00 00 00 06 00 05 00 06 00 01] 00 01 00 
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
```

## 方法表

结构如图所示
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
    
```
方法相关信息是如下十六进制数据表示的，也是在上边完全的十六进制数据中用 [] 圈出来的
一、 00 03 
二、00 01 00 07 00 08 
00 01 00 09 00 00 00 38 00 02 00 01 00 00 00 0A 2A B7 00 01 2A 04 B5 00 
02 B1 00 00 00 02 00 0A 00 00 00 0A 00 02 00 00 00 0B 00 04 00 0D 00 0B 00 00 00 0C 00 01 00 00 00 0A 00 0C 
00 0D 00 00 00 01 00 0E 00 0F 00 01 00 09 00 00 00 2F 00 01 00 01 00 00 00 05 2A B4 00 02 AC 00 00 00 02 00 
0A 00 00 00 06 00 01 00 00 00 10 00 0B 00 00 00 0C 00 01 00 00 00 05 00 0C 00 0D 00 00 00 01 00 10 00 11 00 
01 00 09 00 00 00 3E 00 02 00 02 00 00 00 06 2A 1B B5 00 02 B1 00 00 00 02 00 0A 00 00 00 0A 00 02 00 00 00 
14 00 05 00 15 00 0B 00 00 00 16 00 02 00 00 00 06 00 0C 00 0D 00 00 00 00 00 06 00 05 00 06 00 01
```
可以对照着图来一个一个解析
+ 一、 开始的两个字节 00 03 表示 三个方法，其中显示定义的有getA和setA两个方法，另外一个是哪里来的呢，是编译器自动生产的构造方法。
+ 二、 然后就开始了第一个方法，根据方法表的定义，分别为两个字节的access\_flags 两个字节的name\_index 两个字节的descriptor\_index，对应起来就是
00 01 对应
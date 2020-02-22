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
```

## 方法表

结构如图所示
![image text](https://mmbiz.qpic.cn/mmbiz_png/BQGpt2vnVYUpW4xYLj72IhNnJqGibMAlM6kD9EjyenLujNibr6YXpfDaVxHT9iaf7If8bCggk4w2XmTRViashmExAw/0?wx_fmt=png)
![image text](https://mmbiz.qpic.cn/mmbiz_png/BQGpt2vnVYUpW4xYLj72IhNnJqGibMAlMSAxqp8ap5SZDicicy8bPoa6KqcoISJUjHvR7tK9VicGUyRTCRo6UFfjsA/0?wx_fmt=png)
方法中的每个属性都是一个attribute\_info 结构，如图所示
![image text](https://mmbiz.qpic.cn/mmbiz_png/BQGpt2vnVYUpW4xYLj72IhNnJqGibMAlMU8TgeWyuGMl7kn4z6JBR20AibkghP2OzvmEP7MIU3g7uYTRjv9yibHuA/0?wx_fmt=png)
Jvm预定义了部分attribute，编译器也可以实现自己的attribute写入class文件里供运行时使用，不同的attribute通过attribute_name_index来区分。
其中code attribute的作用是保存方法的结构，如图所示对应的字节码
![image text](https://mmbiz.qpic.cn/mmbiz_png/BQGpt2vnVYUpW4xYLj72IhNnJqGibMAlMEqSSZmF1HowEq2Gx8n4DkdqNvicVIJFSB4H6djjXia4U9c9Yib4tOLgxw/0?wx_fmt=png)
+ attribute\_length 表示attribute所包含的字节数，不包含attribute\_name\_index 和 attribute\_length字段
+ max\_stack 表示程序执行过程中所能达到的操作数栈的最大深度
+ max\_locals 表示方法执行期间创建的局部变量的数目，包含用来表示传入参数的局部变量。
+ code\_length 表示该方法所包含的字节码的字节数以及具体的指令码
+ 具体字节码是该方法被调用时，jvm执行的字节码
+ exception\_table 存放的是处理异常的信息
+ 每个exception\_table表项由start\_pc end\_pc handler\_pc catch\_type 构成
   - start\_pc end\_pc表示在code数组中从start\_pc 到 end\_pc 处（左闭右开）的指令抛出的异常由这个表项来处理
   - handler\_pc 表示处理异常的代码的开始处，catch\_type表示被处理的异常类型，它指向常量池中一个异常类，当catch\_type为0表示处理所有异常
+ 然后是方法的附加属性
+ LineNumberTable 这个属性用来表示code数组中的字节码和java代码行数之间的关系，可以用来在调试的时候定位代码执行的行数。结构如图所示
    ![image text](https://mmbiz.qpic.cn/mmbiz_png/BQGpt2vnVYUpW4xYLj72IhNnJqGibMAlMKJdERvqbErBMqGMoxia6RIvztaVZRZymCAsprGHGvBnic772dkpfLkEA/0?wx_fmt=png)
    
```
方法相关信息是如下十六进制数据表示的，也是在上边完全的十六进制数据中用 [] 圈出来的
一、 00 03 
二、 00 01 00 07 00 08 
三、 00 01 
四、 00 09 
五、 00 00 00 38 
六、 00 02 
七、 00 01 
八、 00 00 00 0A 
九、 2A B7 00 01 2A 04 B5 00 02 B1 
十、 00 00 
十一、00 02 
十二、00 0A 
十三、00 00 00 0A 
十四、00 02 00 00 00 0B 00 04 00 0D 
十五、00 0B 
十六、00 00 00 0C 
十七、00 01 00 00 00 0A 00 0C 00 0D 00 00 
十八、00 01 00 0E 00 0F 00 01 00 09 00 00 00 2F 00 01 00 01 00 00 00 05 2A B4 00 02 AC 00 00 00 02 00 
0A 00 00 00 06 00 01 00 00 00 10 00 0B 00 00 00 0C 00 01 00 00 00 05 00 0C 00 0D 00 00 
十九、00 01 00 10 00 11 00 01 00 09 00 00 00 3E 00 02 00 02 00 00 00 06 2A 1B B5 00 02 B1 00 00 00 02 00 0A 00 00 00 0A 00 02 00 00 00 
14 00 05 00 15 00 0B 00 00 00 16 00 02 00 00 00 06 00 0C 00 0D 00 00 00 00 00 06 00 05 00 06 00 01
```
## 本次重点分析方法表

可以对照着图来一个一个解析
+ 一、 开始的两个字节 00 03 表示 三个方法，其中显示定义的有getA和setA两个方法，另外一个是哪里来的呢，是编译器自动生产的构造方法。
+ 二、 然后就开始了第一个方法，根据方法表的定义，分别为两个字节的access\_flags 两个字节的name\_index 两个字节的descriptor\_index，对应起来就是
00 01 对应ACC\_PUBLIC访问标志，00 07 值为7，对应常量池中索引项为7的\<init>方法名称，00 08 值为8，对应常量池中索引项为8的描述符 ()V，表示
不接受参数没有返回值，通过访问标志 public 方法名字 init 和 方法的描述信息可以唯一定位一个方法。
+ 三、 接下来两个字节代表方法本身的属性个数，这个属性是编译器动态生产的，主要记录了方法执行的指令码（助记符）异常以及code数组中的字节码和java源代码
行号之间的对应关系，此处是 00 01，值为1，说明该方法有一个属性
+ 四、 接下来两个字节代表code\_attribute的结构定义中的attribute\_name\_index，00 09值为9，指向常量池中9索引项为Code，这其实是一个规范，几乎
所有的方法的属性的名字都是Code。
+ 五、 接下来四个字节代表attribute\_length，表示attribute所包含的字节数，但是不包含attribute\_name\_index和attribute\_length,意思就是
从这四个字节后边的第一个字节开始到这个属性结束都是这个方法所代表的执行的指令。00 00 00 38 值为56，就是从下一个字节开始数56个字节是这个方法所要执行
指令的内容。
+ 六、 接下来两个字节表示该方法在执行任意时刻能达到的操作数栈的最大的深度max\_stack，00 02 值为2，说明操作数栈最大深度为2。
+ 七、 接下来两个字节表示方法执行期间创建的局部变量的数量最大值max\_locals，包含了表示传入的参数的局部变量，00 01值为1，说明局部变量数为1。
+ 八、 接下来四个字节表示code\_length,表示该方法所包含的字节码的字节数以及具体的指令码。00 00 00 0A，值为10，表明从这四个字节的下一个字节开始
数10个字节，真正代表了方法在执行的时候真正运行的字节码。
+ 九、 接下来code\_length个字节，在此处也就是10个字节，代表方法真正执行的字节码真正的执行指令，jvm指令集[在这里查看](https://docs.oracle.com/javase/specs/jvms/se8/html/jvms-6.html)
2A 代表 aload_0,是 aload_\<n>的一种，从局部变量中加载引用，B7 代表 invokespecial，大概意思是调用父类构造方法，但是这个指令接受参数，就是00 01，
指向常量池索引项为1的，methodref，最终是java/lang/Object.\"\<init>":()V，其实jvm认识的是2A和B7这些类型的数据，而aload也好或者invokespecial
也好，只是为了让人们更容易记住。接着又是2A，然后是04，这些十六进制都可以在jvm指令集搜到对应的助记符，04是iconst_1，把1压入操作数栈顶，然后是
B5，代表putfield，后边两个字节00 02是参数，代表给常量池索引项2代表的属性section2/bytecode/Test1.a:I赋值，赋的值是上一步压入操作数栈顶的1，然后是
B1，代表return，从方法返回void。
+ 十、 接下来两个字节代表方法code异常表数量， 00 00 代表没有异常
+ 十一、 接下来两个字节代表方法code的属性数量，00 02，代表2个属性。
+ 十二、 接下来两个字节代表第一个属性的名称，00 0A，常量池中索引项为10的LineNumberTable
+ 十三、 接下来四个字节代表第一个属性的长度，00 00 00 0A，代表从下个字节开始查10个字节是真正的lineNumber的信息
+ 十四、 接下来10个字节代表lineNumber真正的信息，前两个字节00 02表示有两队映射，分别是00 00 00 0B 和 00 04 00 0D，意思是 字节码偏移量为0映射
到源代码为11，字节码偏移量为4映射到源代码为13。
+ 十五、 接下来两个字节代表第二个属性的名称，00 0B，常量池中索引项为11的LocalVariableTable，局部变量表。
+ 十六、 接下来四个字节代表局部变量表所占的长度，00 00 00 0C，代表加下来的12个字节代表局部变量表的内容。
+ 十七、 局部变量表的前两个字节代表局部变量表的个数，00 01，意思是有一个局部变量。 然后十个十个字节为一组，分别为2字节局部变量开始位置 2字节
局部变量长度 2字节局部变量值 2字节局部变量描述符 2字节局部变量索引 接着的表示 00 00局部变量开始位置0  00 0A长度10  00 0C局部变量的值为
常量池中12代表的this 00 0D局部变量描述常量池中13代表的Lsection2/bytecode/Test1; 00 00 代表局部变量索引为0
+ 十八、 第二个方法 getA
+ 十九、 第三个方法 setA

## 结合上一篇可以一起分析class文件的结构和定义
## 用***jclasslib***工具可以很好的来帮助理解学习


```
package section2.bytecode;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;


public class Test3 {

    public void test() {
        try {
            InputStream inputStream = new FileInputStream("aa.txt");

            ServerSocket serverSocket = new ServerSocket(8888);
            serverSocket.accept();

        } catch (FileNotFoundException e) {

        } catch (IOException e) {

        } catch (Exception e) {

        } finally {
            System.out.println("finally");
        }
    }
}
```

```
Classfile /Users/bjhl/IdeaProjects/jvmlearn/target/classes/section2/bytecode/Test3.class
  Last modified 2020-2-23; size 1059 bytes
  MD5 checksum c855a8fc925b0322a7e9687edc49ec39
  Compiled from "Test3.java"
public class section2.bytecode.Test3
  minor version: 0
  major version: 52
  flags: ACC_PUBLIC, ACC_SUPER
Constant pool:
   #1 = Methodref          #15.#35        // java/lang/Object."<init>":()V
   #2 = Class              #36            // java/io/FileInputStream
   #3 = String             #37            // aa.txt
   #4 = Methodref          #2.#38         // java/io/FileInputStream."<init>":(Ljava/lang/String;)V
   #5 = Class              #39            // java/net/ServerSocket
   #6 = Methodref          #5.#40         // java/net/ServerSocket."<init>":(I)V
   #7 = Methodref          #5.#41         // java/net/ServerSocket.accept:()Ljava/net/Socket;
   #8 = Fieldref           #42.#43        // java/lang/System.out:Ljava/io/PrintStream;
   #9 = String             #44            // finally
  #10 = Methodref          #45.#46        // java/io/PrintStream.println:(Ljava/lang/String;)V
  #11 = Class              #47            // java/io/FileNotFoundException
  #12 = Class              #48            // java/io/IOException
  #13 = Class              #49            // java/lang/Exception
  #14 = Class              #50            // section2/bytecode/Test3
  #15 = Class              #51            // java/lang/Object
  #16 = Utf8               <init>
  #17 = Utf8               ()V
  #18 = Utf8               Code
  #19 = Utf8               LineNumberTable
  #20 = Utf8               LocalVariableTable
  #21 = Utf8               this
  #22 = Utf8               Lsection2/bytecode/Test3;
  #23 = Utf8               test
  #24 = Utf8               inputStream
  #25 = Utf8               Ljava/io/InputStream;
  #26 = Utf8               serverSocket
  #27 = Utf8               Ljava/net/ServerSocket;
  #28 = Utf8               StackMapTable
  #29 = Class              #47            // java/io/FileNotFoundException
  #30 = Class              #48            // java/io/IOException
  #31 = Class              #49            // java/lang/Exception
  #32 = Class              #52            // java/lang/Throwable
  #33 = Utf8               SourceFile
  #34 = Utf8               Test3.java
  #35 = NameAndType        #16:#17        // "<init>":()V
  #36 = Utf8               java/io/FileInputStream
  #37 = Utf8               aa.txt
  #38 = NameAndType        #16:#53        // "<init>":(Ljava/lang/String;)V
  #39 = Utf8               java/net/ServerSocket
  #40 = NameAndType        #16:#54        // "<init>":(I)V
  #41 = NameAndType        #55:#56        // accept:()Ljava/net/Socket;
  #42 = Class              #57            // java/lang/System
  #43 = NameAndType        #58:#59        // out:Ljava/io/PrintStream;
  #44 = Utf8               finally
  #45 = Class              #60            // java/io/PrintStream
  #46 = NameAndType        #61:#53        // println:(Ljava/lang/String;)V
  #47 = Utf8               java/io/FileNotFoundException
  #48 = Utf8               java/io/IOException
  #49 = Utf8               java/lang/Exception
  #50 = Utf8               section2/bytecode/Test3
  #51 = Utf8               java/lang/Object
  #52 = Utf8               java/lang/Throwable
  #53 = Utf8               (Ljava/lang/String;)V
  #54 = Utf8               (I)V
  #55 = Utf8               accept
  #56 = Utf8               ()Ljava/net/Socket;
  #57 = Utf8               java/lang/System
  #58 = Utf8               out
  #59 = Utf8               Ljava/io/PrintStream;
  #60 = Utf8               java/io/PrintStream
  #61 = Utf8               println
{
  public section2.bytecode.Test3();
    descriptor: ()V
    flags: ACC_PUBLIC
    Code:
      stack=1, locals=1, args_size=1
         0: aload_0
         1: invokespecial #1                  // Method java/lang/Object."<init>":()V
         4: return
      LineNumberTable:
        line 19: 0
      LocalVariableTable:
        Start  Length  Slot  Name   Signature
            0       5     0  this   Lsection2/bytecode/Test3;

  public void test();
    descriptor: ()V
    flags: ACC_PUBLIC
    Code:
      stack=3, locals=4, args_size=1
         // 创建新对象
         0: new           #2                  // class java/io/FileInputStream
         // 复制操作数栈顶层元素并把复制的元素压入操作数栈
         3: dup
         // 把 aa.txt 从运行时常量池中推进去
         4: ldc           #3                  // String aa.txt
         // 调用构造方法
         6: invokespecial #4                  // Method java/io/FileInputStream."<init>":(Ljava/lang/String;)V
         // 将引用存放到局部变量中 在这里是将创建处的FileInputStream的实例的引用存入到局部变量表索引项为1中（inputStream）
         9: astore_1

         // // 以上对应源代码 InputStream inputStream = new FileInputStream("aa.txt");

        // 创建新对象
        10: new           #5                  // class java/net/ServerSocket
        // 复制操作数栈顶层元素并把复制的元素压入操作数栈
        13: dup
        // 将一个 short 值 推送值栈顶，这里是 8888 
        14: sipush        8888
        // 调用构造方法
        17: invokespecial #6                  // Method java/net/ServerSocket."<init>":(I)V
        // 将引用存放到局部变量中 在这里是将创建处的ServerSocket的实例的引用赋给到局部变量表索引项为2中（serverSocket）
        20: astore_2
        // 将局部变量表索引为2的项的引用加载到操作数栈顶
        21: aload_2
        // 调用虚方法
        22: invokevirtual #7                  // Method java/net/ServerSocket.accept:()Ljava/net/Socket;
        // 将操作数栈最顶层元素弹出
        25: pop

        // ServerSocket serverSocket = new ServerSocket(8888); 以上是这两行代码
        //               serverSocket.accept();

        // finally 块中的代码
        // 从class中获取静态变量
        26: getstatic     #8                  // Field java/lang/System.out:Ljava/io/PrintStream;
        // 把 finally 从运行时常量池中推进去
        29: ldc           #9                  // String finally
        // 调用虚方法
        31: invokevirtual #10                 // Method java/io/PrintStream.println:(Ljava/lang/String;)V
        // 跳转 84 结束
        34: goto          84      // 以上从0到这行代码是方法正常运行并最后进入finally块正常结束

        // 把异常对象赋给局部变量表中索引项1中（这里为什么是1 因为之前局部变量表在finally中是看不到的）
        37: astore_1
        38: getstatic     #8                  // Field java/lang/System.out:Ljava/io/PrintStream;
        41: ldc           #9                  // String finally
        43: invokevirtual #10                 // Method java/io/PrintStream.println:(Ljava/lang/String;)V
        46: goto          84      // 以上从37 到这行代码是程序在catch到FileNotFoundException后直接跳转到这块执行的


        49: astore_1
        50: getstatic     #8                  // Field java/lang/System.out:Ljava/io/PrintStream;
        53: ldc           #9                  // String finally
        55: invokevirtual #10                 // Method java/io/PrintStream.println:(Ljava/lang/String;)V
        58: goto          84      // 以上从49 到这行代码是程序在catch到IOException后直接跳转到这块执行的

        61: astore_1
        62: getstatic     #8                  // Field java/lang/System.out:Ljava/io/PrintStream;
        65: ldc           #9                  // String finally
        67: invokevirtual #10                 // Method java/io/PrintStream.println:(Ljava/lang/String;)V
        70: goto          84      // 以上从61 到这行代码是程序在catch到Exception后直接跳转到这块执行的


        // 这里对应的是any的异常，在代码中Execption是所有异常的根，代码中可以认为Exception把所有异常都捕获了，但是从字节码角度
           不会这么认为，所以会生成catch_type为0的any类型，表示处理所有上边不可能处理的异常。
        73: astore_3
        74: getstatic     #8                  // Field java/lang/System.out:Ljava/io/PrintStream;
        77: ldc           #9                  // String finally
        79: invokevirtual #10                 // Method java/io/PrintStream.println:(Ljava/lang/String;)V
        82: aload_3
        83: athrow
        84: return
      Exception table:
         // 意思是在方法的Code里字节码中，从from开始到to但不包含to之间的字节码执行期间，如果出现catch_type（也就是下边的type）类型的
         // 异常的话，就跳转到指定的Handler PC（就是下边的target） 字节码处开始执行
         from    to  target type  
             0    26    37   Class java/io/FileNotFoundException   // 跳转到上边37行代表的astore_1并继续执行
             0    26    49   Class java/io/IOException             // 跳转到上边49行代表的astore_1并继续执行
             0    26    61   Class java/lang/Exception             // 跳转到上边61行代表的astore_1并继续执行
             0    26    73   any                                   // 跳转到上边73行代表的astore_1并继续执行
      LineNumberTable:
        line 23: 0
        line 25: 10
        line 26: 21
        line 35: 26
        line 36: 34
        line 28: 37
        line 35: 38
        line 36: 46
        line 30: 49
        line 35: 50
        line 36: 58
        line 32: 61
        line 35: 62
        line 36: 70
        line 35: 73
        line 36: 82
        line 37: 84
      LocalVariableTable:
        Start  Length  Slot  Name   Signature
           10      16     1 inputStream   Ljava/io/InputStream;
           21       5     2 serverSocket   Ljava/net/ServerSocket;
            0      85     0  this   Lsection2/bytecode/Test3;
      StackMapTable: number_of_entries = 5
        frame_type = 101 /* same_locals_1_stack_item */
          stack = [ class java/io/FileNotFoundException ]
        frame_type = 75 /* same_locals_1_stack_item */
          stack = [ class java/io/IOException ]
        frame_type = 75 /* same_locals_1_stack_item */
          stack = [ class java/lang/Exception ]
        frame_type = 75 /* same_locals_1_stack_item */
          stack = [ class java/lang/Throwable ]
        frame_type = 10 /* same */
}
SourceFile: "Test3.java"
```

+ 对于java类中的每一个实例方法（非static方法），在编译后生成的字节码中，方法参数的数量总是比源代码中方法参数多一个（this），它位于第一个参数
位置处，这样就可以在java实例中使用this来访问当前对象的属性和其他方法。***这个操作在编译期完成，即由javac编译器在编译期间将对this的访问转化为
对一个普通实例方法参数的访问，然后在运行期间，由JVM在调用实例方法时，自动向实例方法传入该this参数，所以在实例方法的局部变量表中，至少会有一个指向
当前对象的局部变量***。

+ 为什么test方法局部变量是***四个***。第一个 this， 第二个 inputStream，第三个 serverSocket，第四个***位于catch中***，意思是方法在运行期间，
根据jvm规范，如果抛出异常，那么肯定会进入到三个catch中的一个，而且只会是一个，那么后边的ex就只会生成一个，这个就是这第四个局部变量，但是也可能不抛出
异常，所以是最多局部变量的个数。

+ 每个exception_table表项由start_pc end_pc handler_pc catch_type 构成
   - start_pc end_pc表示在code数组中从start_pc 到 end_pc 处（左闭右开）的指令抛出的异常由这个表项来处理
   - handler_pc 表示处理异常的代码的开始处，catch_type表示被处理的异常类型，它指向常量池中一个异常类，当catch_type为0表示处理所有异常

+ java字节码对于异常的处理方式
   - 统一采用异常表的方式来处理异常
   - 在JDK 1.4.2 之前，是采用特定的指令码来处理异常，而不是采用异常表来处理异常
   - 当异常处理存在finally语句块时候，现代化jvm采取处理方式是将finally语句块的自己码拼接到每一个catch块后边，意思就是程序中存在多少个catch块
   就会在多少个catch块后边重复多少个finally语句块。
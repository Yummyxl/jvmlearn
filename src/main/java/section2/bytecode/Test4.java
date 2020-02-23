package section2.bytecode;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * 应用模块名称<p>
 * 代码描述<p>
 *
 * @Author: Yummyxl
 * @Date: 2020/2/23
 *
 *  通过查看此文件的class文件的字节码验证return 和 finally的执行原理
 */

public class Test4 {

    public String test() {
        try {
            InputStream inputStream = new FileInputStream("aaa");
            return "try";
        } catch (FileNotFoundException e) {
            System.out.println("catch1");
            return "catch2";
        } finally {
            System.out.println("finally");
            return "finally1";
        }
    }
}
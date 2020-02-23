package section2.bytecode;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;

/**
 * 应用模块名称<p>
 * 代码描述<p>
 *
 * @Author: Yummyxl
 * @Date: 2020/2/23
 * <p>
 * 异常处理
 */

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

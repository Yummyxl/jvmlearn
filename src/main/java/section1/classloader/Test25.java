package section1.classloader;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * 应用模块名称<p>
 * 代码描述<p>
 *
 * @Author: Yummyxl
 * @Date: 2020/2/20
 */

public class Test25 {

    public static void main(String[] args) throws Exception {

        // 这一行注释掉也可以，远离可以查看源代码一行一行看
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://172.21.139.13:3306/haoke", "chaikuservice", "testchaiku");
        System.out.println(connection);
        connection.close();
    }
}

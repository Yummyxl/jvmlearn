package section3.memory;

import java.util.ArrayList;
import java.util.List;

/**
 * 应用模块名称<p>
 * 代码描述<p>
 *
 * @Author: Yummyxl
 * @Date: 2020/2/24
 *
 * 虚拟机栈： stack frame 栈帧
 *
 * -Xms5m -Xmx5m -XX:+HeapDumpOnOutOfMemoryError
 * 堆空间溢出
 */

public class Test1 {

    public static void main(String[] args) {
        List<Test1> list = new ArrayList<>();

        while (true) {
            list.add(new Test1());
//            System.gc();
        }
    }
}

package section4.gc;

/**
 * 应用模块名称<p>
 * 代码描述<p>
 *
 * @Author: Yummyxl
 * @Date: 2020/3/1
 *
 * -verbose:gc -XX:+UseG1GC -Xms10M -Xmx10M -XX:+PrintGCDetails -XX:+PrintGCDateStamps -XX:MaxGCPauseMillis=200m
 */

public class Test7 {

    public static void main(String[] args) {

        int size = 1024 * 1024;

        System.out.println("============1");
        byte[] bytes1 = new byte[size];
        System.out.println("============2");
        byte[] bytes2 = new byte[size];
        System.out.println("============3");
        byte[] bytes3 = new byte[size];
        System.out.println("============4");
        byte[] bytes4 = new byte[size];

        System.out.println("============5");

        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

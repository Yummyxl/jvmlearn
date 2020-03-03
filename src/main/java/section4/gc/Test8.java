package section4.gc;

/**
 * 应用模块名称<p>
 * 代码描述<p>
 *
 * @Author: Yummyxl
 * @Date: 2020/3/3
 *
 * -verbose:gc -XX:+UseG1GC -Xms15M -Xmx15M -XX:+PrintGCDetails -XX:+PrintGCDateStamps -XX:MaxGCPauseMillis=200m
 */

public class Test8 {

    public static void main(String[] args) {

        byte[] bytes = new byte[1024 * 1024];
        byte[] bytes1 = new byte[1024 * 1024];
        byte[] bytes2 = new byte[1024 * 1024];
        byte[] bytes3 = new byte[1024 * 1024];
        byte[] bytes4 = new byte[1024 * 1024];
        byte[] bytes5 = new byte[1024 * 1024];
//        byte[] bytes6 = new byte[1024 * 1024];
//        byte[] bytes7 = new byte[1024 * 1024];
//        byte[] bytes8 = new byte[1024 * 1024];
//        byte[] bytes9 = new byte[1024 * 1024];

        for (int i=0; i<20; i++) {
            System.out.println("=============" + i);
            test();
        }
    }

    public static void test() {
        byte[] bytes = new byte[1024 * 1024];
        bytes = null;
        try {
            Thread.sleep(300L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

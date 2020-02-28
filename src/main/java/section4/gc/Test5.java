package section4.gc;

/**
 * 应用模块名称<p>
 * 代码描述<p>
 *
 * @Author: Yummyxl
 * @Date: 2020/2/28
 *
 * -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:+UseConcMarkSweepGC -XX:+UseParNewGC
 */

public class Test5 {

    public static void main(String[] args) {

        int size = 1024 * 1024;

        System.out.println("============1");
        byte[] bytes1 = new byte[4 * size];
        System.out.println("============2");
        byte[] bytes2 = new byte[4 * size];
        System.out.println("============3");
        byte[] bytes3 = new byte[4 * size];
        System.out.println("============4");
        byte[] bytes4 = new byte[2 * size];
        System.out.println("============5");
    }
}

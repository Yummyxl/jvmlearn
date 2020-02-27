package section4.gc;

/**
 * 应用模块名称<p>
 * 代码描述<p>
 *
 * @Author: Yummyxl
 * @Date: 2020/2/27
 * -verbose:gc -Xms200M -Xmx200M -Xmn50M -XX:TargetSurvivorRatio=60 -XX:+PrintTenuringDistribution -XX:+PrintGCDetails -XX:+PrintGCDateStamps -XX:+UseConcMarkSweepGC -XX:+UseParNewGC  -XX:MaxTenuringThreshold=3
 *
 * -XX:TargetSurvivorRatio=60 当一个Survivor使用空间占用Survivor容量百分之60时候重新计算对象晋升的阈值
 */

public class Test4 {

    public static void main(String[] args) throws Exception {
        byte[] bytes1 = new byte[512 * 1024];
        byte[] bytes2 = new byte[512 * 1024];

        myGc();
        Thread.sleep(1000);
        System.out.println("11111111");

        myGc();
        Thread.sleep(1000);
        System.out.println("222222222");

        myGc();
        Thread.sleep(1000);
        System.out.println("3333333333");

        myGc();
        Thread.sleep(1000);
        System.out.println("444444444");

        byte[] bytes3 = new byte[1024 * 1024];
        byte[] bytes4 = new byte[1024 * 1024];
        byte[] bytes5 = new byte[1024 * 1024];

        myGc();
        Thread.sleep(1000);
        System.out.println("5555555555");

        byte[] bytes6 = new byte[1024 * 1024];

        myGc();
        Thread.sleep(1000);
        System.out.println("6666666666");



    }

    private static void myGc() {
        for (int i=0; i<40; i++) {
            byte[] bytes3 = new byte[1024 * 1024];
        }
    }
}

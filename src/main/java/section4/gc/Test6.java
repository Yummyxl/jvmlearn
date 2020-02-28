package section4.gc;

/**
 * 应用模块名称<p>
 * 代码描述<p>
 *
 * @Author: Yummyxl
 * @Date: 2020/2/28
 *
 * 让JVM运行5次young gc 和 1次 cms gc
 *
 * -verbose:gc -XX:+PrintGCDetails -XX:+PrintGCDateStamps -Xms20M -Xmx20M -Xmn10M -XX:PretenureSizeThreshold=2M -XX:CMSInitiatingOccupancyFraction=60 -XX:+UseCMSInitiatingOccupancyOnly -XX:+UseConcMarkSweepGC -XX:+UseParNewGC
 */

public class Test6 {

    public static void main(String[] args) {

        youngGc(5);
        cmsGc(3);

        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void youngGc(int n) {
        int size1 = 1024 * 1024;
        for (int i=0; i<n; i++) {
            for (int j=0;j<8;j++) {
                byte[] bytes = new byte[size1];
            }
        }
    }

    public static void cmsGc(int n) {
        int size1 = 1024 * 1024;
        for (int i=0; i<n; i++) {
            byte[] bytes = new byte[6 * size1];
            System.out.println("============cms " + i);
            try {
                Thread.sleep(2000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

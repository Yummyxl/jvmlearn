package section4.gc;

/**
 * 应用模块名称<p>
 * 代码描述<p>
 *
 * @Author: Yummyxl
 * @Date: 2020/2/27
 *
 * -verbose:gc -Xms20M -Xmx20M -XX:+PrintGCDetails -XX:+PrintCommandLineFlags -XX:SurvivorRatio=8 -XX:MaxTenuringThreshold=5 -XX:+PrintTenuringDistribution
 *
 * -XX:+MaxTenuringThreahold 在可以自动调节对象晋升到老年代阈值的GC中，该阈值的最大值
 * 默认值是15，CMS默认值是6，G1中默认值是15（该数值是由四个bit来表示的，最大值1111）
 * 经历来多次gc后，会在from survivor 和 to survivor中来回存放，前提是这两个空间由足够的空间来存放对象，在gc算法中，会计算每个对象的年龄
 * 大小，如果达到某个年龄后（大于等于这个年龄）发现总大小已经大于来survivor空间的百分之50，这时候就需要调整阈值，不需要达到默认的值15次再晋升，
 * 因为这样会导致survivor空间不足，所以要调整阈值让这些对象尽快晋升。
 */

public class Test3 {

    public static void main(String[] args) {
        int size = 1024 * 1024;
        byte[] bytes1 = new byte[2 * size];
        System.out.println("1");
        byte[] bytes2 = new byte[2 * size];
        System.out.println("2");
        byte[] bytes3 = new byte[2 * size];
        System.out.println("3");
        byte[] bytes4 = new byte[2 * size];
        System.out.println("4");
    }
}

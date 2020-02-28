package section4.gc;

/**
 * 应用模块名称<p>
 * 代码描述<p>
 *
 * @Author: Yummyxl
 * @Date: 2020/2/26
 *
 * -verbose:gc  输出详细垃圾回收的日志
 * -Xms20M   堆初始大小
 * -Xmx20M   堆最大容量
 * -Xmn10M   新生代10M
 * -XX:+PrintGCDetails
 * -XX:SurivivorRatio=8  Eden 空间和 Survivor 比例是 8 比 1
 */

public class Test1 {

    public static void main(String[] args) {
        int size = 1024 * 1024;

        /**
         * 一
         *
         * [GC (Allocation Failure) [PSYoungGen: 5822K->528K(9216K)] 5822K->4632K(19456K), 0.0047325 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
         * hello world
         * Heap
         *  PSYoungGen      total 9216K, used 3838K [0x00000007bf600000, 0x00000007c0000000, 0x00000007c0000000)
         *   eden space 8192K, 40% used [0x00000007bf600000,0x00000007bf93bb20,0x00000007bfe00000)
         *   from space 1024K, 51% used [0x00000007bfe00000,0x00000007bfe84010,0x00000007bff00000)
         *   to   space 1024K, 0% used [0x00000007bff00000,0x00000007bff00000,0x00000007c0000000)
         *  ParOldGen       total 10240K, used 4104K [0x00000007bec00000, 0x00000007bf600000, 0x00000007bf600000)
         *   object space 10240K, 40% used [0x00000007bec00000,0x00000007bf002020,0x00000007bf600000)
         *  Metaspace       used 3082K, capacity 4496K, committed 4864K, reserved 1056768K
         *   class space    used 339K, capacity 388K, committed 512K, reserved 1048576K
         */
//        byte[] bytes1 = new byte[2 * size];
//        byte[] bytes2 = new byte[2 * size];
//        byte[] bytes3 = new byte[3 * size];


        /**
         * 二
         *
         * [GC (Allocation Failure) [PSYoungGen: 8034K->560K(9216K)] 8034K->6712K(19456K), 0.0041643 secs] [Times: user=0.01 sys=0.00, real=0.00 secs]
         * [Full GC (Ergonomics) [PSYoungGen: 560K->0K(9216K)] [ParOldGen: 6152K->6562K(10240K)] 6712K->6562K(19456K), [Metaspace: 3079K->3079K(1056768K)], 0.0042901 secs] [Times: user=0.01 sys=0.00, real=0.01 secs]
         * hello world
         * Heap
         *  PSYoungGen      total 9216K, used 2287K [0x00000007bf600000, 0x00000007c0000000, 0x00000007c0000000)
         *   eden space 8192K, 27% used [0x00000007bf600000,0x00000007bf83bc90,0x00000007bfe00000)
         *   from space 1024K, 0% used [0x00000007bfe00000,0x00000007bfe00000,0x00000007bff00000)
         *   to   space 1024K, 0% used [0x00000007bff00000,0x00000007bff00000,0x00000007c0000000)
         *  ParOldGen       total 10240K, used 6562K [0x00000007bec00000, 0x00000007bf600000, 0x00000007bf600000)
         *   object space 10240K, 64% used [0x00000007bec00000,0x00000007bf268840,0x00000007bf600000)
         *  Metaspace       used 3087K, capacity 4496K, committed 4864K, reserved 1056768K
         *   class space    used 339K, capacity 388K, committed 512K, reserved 1048576K
         *
         * Process finished with exit code 0
         *
         * https://blog.csdn.net/zz133110/article/details/104454819
         * https://blog.csdn.net/weixin_43194122/article/details/91526740
         */
//        byte[] bytes1 = new byte[2 * size];
//        byte[] bytes2 = new byte[2 * size];
//        byte[] bytes3 = new byte[2 * size];
//        byte[] bytes4 = new byte[2 * size];  //在此执行一次年轻代GC 和 一次 Full GC  只是发生在年轻代gc


        /**
         * 三  对象数组变大反而没有出现Full GC
         * 也有另外一种说法当新生代无法容纳下一个新对象时候，这个新对象直接在老年代诞生
         *
         * [GC (Allocation Failure) [PSYoungGen: 5822K->560K(9216K)] 5822K->4664K(19456K), 0.0027910 secs] [Times: user=0.01 sys=0.00, real=0.01 secs]
         * hello world
         * Heap
         *  PSYoungGen      total 9216K, used 6942K [0x00000007bf600000, 0x00000007c0000000, 0x00000007c0000000)
         *   eden space 8192K, 77% used [0x00000007bf600000,0x00000007bfc3bb18,0x00000007bfe00000)
         *   from space 1024K, 54% used [0x00000007bfe00000,0x00000007bfe8c010,0x00000007bff00000)
         *   to   space 1024K, 0% used [0x00000007bff00000,0x00000007bff00000,0x00000007c0000000)
         *  ParOldGen       total 10240K, used 4104K [0x00000007bec00000, 0x00000007bf600000, 0x00000007bf600000)
         *   object space 10240K, 40% used [0x00000007bec00000,0x00000007bf002020,0x00000007bf600000)
         *  Metaspace       used 3081K, capacity 4496K, committed 4864K, reserved 1056768K
         *   class space    used 339K, capacity 388K, committed 512K, reserved 1048576K
         */
        byte[] bytes1 = new byte[2 * size];
        byte[] bytes2 = new byte[2 * size];  //此时Eden空间4M，加上jvm自己一些东西可能有5M
        byte[] bytes3 = new byte[3 * size];  //此时执行了一次 Scavenge GC，之前的4M移动到了老年代，又有了足够的空间容纳接下来的6M
        byte[] bytes4 = new byte[3 * size];  // 在Eden分配


        System.out.println("hello world");

    }
}
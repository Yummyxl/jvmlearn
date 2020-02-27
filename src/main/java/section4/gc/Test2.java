package section4.gc;

/**
 * 应用模块名称<p>
 * 代码描述<p>
 *
 * @Author: Yummyxl
 * @Date: 2020/2/27
 *
 * -XX:+PrintCommandLineFlags -version  打印虚拟机启动参数
 * -XX:PretenureSizeThreshold=114141 如果对象超过这个数值，新分配的对象将会直接在老年代创建
 * -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:PretenureSizeThreshold=114141
 */

public class Test2 {

    public static void main(String[] args) {
        int size = 1024 * 1024;


        /**
         * -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:PretenureSizeThreshold=4194304
         * PretenureSizeThreshold设置为4M并没有直接分配在老年代
         * 什么原因呢？看下边
         * Heap
         *  PSYoungGen      total 9216K, used 7174K [0x00000007bf600000, 0x00000007c0000000, 0x00000007c0000000)
         *   eden space 8192K, 87% used [0x00000007bf600000,0x00000007bfd018b8,0x00000007bfe00000)
         *   from space 1024K, 0% used [0x00000007bff00000,0x00000007bff00000,0x00000007c0000000)
         *   to   space 1024K, 0% used [0x00000007bfe00000,0x00000007bfe00000,0x00000007bff00000)
         *  ParOldGen       total 10240K, used 0K [0x00000007bec00000, 0x00000007bf600000, 0x00000007bf600000)
         *   object space 10240K, 0% used [0x00000007bec00000,0x00000007bec00000,0x00000007bf600000)
         *  Metaspace       used 3083K, capacity 4496K, committed 4864K, reserved 1056768K
         *   class space    used 338K, capacity 388K, committed 512K, reserved 1048576K
         */
//        byte[] bytes1 = new byte[5 * size];

        /**
         * -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:PretenureSizeThreshold=4194304 -XX:+UseSerialGC
         *
         * PretenureSizeThreshold 这个参数要搭配 串行收集器 -XX:+UseSerialGC
         *
         * Heap
         *  def new generation   total 9216K, used 2054K [0x00000007bec00000, 0x00000007bf600000, 0x00000007bf600000)
         *   eden space 8192K,  25% used [0x00000007bec00000, 0x00000007bee01888, 0x00000007bf400000)
         *   from space 1024K,   0% used [0x00000007bf400000, 0x00000007bf400000, 0x00000007bf500000)
         *   to   space 1024K,   0% used [0x00000007bf500000, 0x00000007bf500000, 0x00000007bf600000)
         *  tenured generation   total 10240K, used 5120K [0x00000007bf600000, 0x00000007c0000000, 0x00000007c0000000)
         *    the space 10240K,  50% used [0x00000007bf600000, 0x00000007bfb00010, 0x00000007bfb00200, 0x00000007c0000000)
         *  Metaspace       used 3060K, capacity 4496K, committed 4864K, reserved 1056768K
         *   class space    used 334K, capacity 388K, committed 512K, reserved 1048576K
         */
//        byte[] bytes1 = new byte[5 * size];

        /**
         * -verbose:gc
         * -Xms20M
         * -Xmx20M
         * -Xmn10M
         * -XX:+PrintGCDetails
         * -XX:SurvivorRatio=8
         *
         * Heap
         *  PSYoungGen      total 9216K, used 2054K [0x00000007bf600000, 0x00000007c0000000, 0x00000007c0000000)
         *   eden space 8192K, 25% used [0x00000007bf600000,0x00000007bf801888,0x00000007bfe00000)
         *   from space 1024K, 0% used [0x00000007bff00000,0x00000007bff00000,0x00000007c0000000)
         *   to   space 1024K, 0% used [0x00000007bfe00000,0x00000007bfe00000,0x00000007bff00000)
         *  ParOldGen       total 10240K, used 8192K [0x00000007bec00000, 0x00000007bf600000, 0x00000007bf600000)
         *   object space 10240K, 80% used [0x00000007bec00000,0x00000007bf400010,0x00000007bf600000)
         *  Metaspace       used 3065K, capacity 4496K, committed 4864K, reserved 1056768K
         *   class space    used 336K, capacity 388K, committed 512K, reserved 1048576K
         *
         *   此时对象8M被直接分配在了老年代，因为新生代无法容纳8M
         */
//        byte[] bytes1 = new byte[8 * size];

        /**
         * [GC (Allocation Failure) [PSYoungGen: 1889K->496K(9216K)] 1889K->504K(19456K), 0.0009058 secs] [Times: user=0.01 sys=0.00, real=0.00 secs]
         * [GC (Allocation Failure) [PSYoungGen: 496K->464K(9216K)] 504K->472K(19456K), 0.0005422 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
         * [Full GC (Allocation Failure) [PSYoungGen: 464K->0K(9216K)] [ParOldGen: 8K->418K(10240K)] 472K->418K(19456K), [Metaspace: 3079K->3079K(1056768K)], 0.0047397 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
         * [GC (Allocation Failure) [PSYoungGen: 0K->0K(9216K)] 418K->418K(19456K), 0.0007384 secs] [Times: user=0.01 sys=0.00, real=0.00 secs]
         * [Full GC (Allocation Failure) [PSYoungGen: 0K->0K(9216K)] [ParOldGen: 418K->400K(10240K)] 418K->400K(19456K), [Metaspace: 3079K->3079K(1056768K)], 0.0042111 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
         * Heap
         *  PSYoungGen      total 9216K, used 246K [0x00000007bf600000, 0x00000007c0000000, 0x00000007c0000000)
         *   eden space 8192K, 3% used [0x00000007bf600000,0x00000007bf63d890,0x00000007bfe00000)
         *   from space 1024K, 0% used [0x00000007bfe00000,0x00000007bfe00000,0x00000007bff00000)
         *   to   space 1024K, 0% used [0x00000007bff00000,0x00000007bff00000,0x00000007c0000000)
         *  ParOldGen       total 10240K, used 400K [0x00000007bec00000, 0x00000007bf600000, 0x00000007bf600000)
         *   object space 10240K, 3% used [0x00000007bec00000,0x00000007bec64108,0x00000007bf600000)
         *  Metaspace       used 3111K, capacity 4496K, committed 4864K, reserved 1056768K
         *   class space    used 342K, capacity 388K, committed 512K, reserved 1048576K
         */
//        byte[] bytes1 = new byte[10 * size];


        /**
         * -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:PretenureSizeThreshold=4194304 -XX:+UseSerialGC
         */
        byte[] bytes1 = new byte[5 * size];
        try {
            Thread.sleep(10000000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

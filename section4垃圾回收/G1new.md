## 序言

```
书中布满杂乱的笔记
还是那么扑朔和迷离
用尽 全身力气
躺在书里的你 仍是个谜
日暮风悲兮边声四起
何时会成为你的知己
失落的时候
还希望靠近接近你两厘米
世界这么大还是遇见你
多少次搜索 多少点击
不经过洗礼
有一天我们怎能笑眯眯
世界这么大还是遇见你
一直都在熟悉你的脾气
可不可以
让我们有朝一日来相遇
```

## 安全点与安全区

### 枚举根节点

- 当执行系统停顿下来后，并不需要一个不漏的检查所有执行上下文和全局引用的位置，虚拟机应当是有办法直接得到那哪些地方存放着对象引用，在HotSpot 实现中，使用一组成为OopMap的数据结构来达到这个目的的
- 总而言之，GC停顿的时候，虚拟机可以通过OopMap这样的一个映射表知道，在对象内的什么偏移量上是什么类型的数据，而且特定的位置记录着栈和寄存器中哪些位置是引用

### 安全点

- 当执行系统停顿下来后，并不需要一个不漏的检查所有执行上下文和全局引用的位置，虚拟机应当是有办法直接得到那哪些地方存放着对象引用，在HotSpot 实现中，使用一组成为OopMap的数据结构来达到这个目的的
- 实际上，HotSpot不会为每一条指令都生成OopMap，而是在 特定的位置 记录这些信息，这些位置被称为安全点 safe point，即程序执行的时候并非所有地方都可以停顿下来执行GC，只要在等到安全点的时候才可以暂停执行
- Safe Point的选取不能太少以至于让GC等待的时间过长，也不能选取太频繁导致过分增大运行时的负担。安全点的选取基本原则是 是否具有让程序长时间运行的特征为标准选定的，因为每条指令执行的时间非常短暂，程序不太可能因为一个指令长度过长而运行太长的时间，长时间执行的最明显特征就是指令序列复用，比如方法调用、循环跳转、异常跳转等，所以具有这些功能等指令才会产生safe point
- 对于安全点来说，另一个需要考虑的问题是如何让所有的线程（不包括JNI调用的线程）在GC发生的时候都跑到最近的安全点停顿下来，这里有两种方式：
    + 抢占式中断，GC会主动通知每一个线程，如果线程不在安全点上，就唤醒线程指定到最近的安全点上
    + 主动式中断，GC会设置一个中断标志，不直接操作线程，线程会轮训这个标志，轮训的地方和安全点是重合的，另外再加上创建对象需要分配内存的地方
    + 现代虚拟机几乎没有抢占式中断

### 安全区域

- 在调用safe point似乎完美解决了问题，但是实际情况却不一定，safe point确保了那些在执行中的线程会在不长的时间段内进入到GC的safe point，但是无法确保那些不在运行中的线程，如果程序实在sleep即waiting或者blocked，线程就没有被分配运行CPU时间，显然JVM不可能等待线程被分配运行时间再跑到最近的safe point，这时候线程就无法响应GC请求，这时候就需要安全区域来解决，safe reign
- 当线程进入到safe reign中的代码时，首先标志自己进入到了safe reign，那样JVM在gc时候就不需要管那些把自己标记为处于safe reign的线程，当程序继续执行要离开safe reign时候，它要检查系统是否完成了根节点枚举（或者是整个GC），如果完成了就继续执行，反之就必须等待收到可以离开safe reign的信号为止

## G1 : Garbage First [这里官方文档](https://www.oracle.com/technetwork/tutorials/tutorials-1876574.html)

### 吞吐量

- 吞吐量关注的是，在一个指定的时间内，最大化一个应用的工作量
- 如下方式来衡量一个系统吞吐量的好坏
    + 在一个小时内同一个事务（或者请求任务）完成的次数 tps
    + 数据库一小时可以完成多少查询
    + 对于关注吞度量的系统，卡顿是可以接受的，因为这个系统关注的是长时间的大量任务的执行能力，单次任务快速的响应并不值得考虑
   
### 响应能力

- 响应能力指的是系统对请求是否能够快速及时响应
    + 桌面ui响应一个事件
    + 网站能够多块返回一个网页请求
    + 数据库能够多快返回数据查询
- 对于这类响应能力敏感的场景，停顿是不能接受的

### G1设计目标

- G1收集器是一个面向服务端的收集器，多适用与多核大容量内存的服务端，满足短时间GC停顿同时又能够达到较高的吞吐量，jdk7以上适用
- 与应用线程同时工作，几乎不需要STW
- 整理剩余空间，不产生内存碎片（与CMS不同，CMS只能在FullGC时用STW整理内存碎片）
- GC停顿时间可控
- 不牺牲系统的吞吐量
- G1不要求额外的内存空间，CMS需要预留空间存储浮动垃圾
- G1的设计目标是要替换CMS
    + G1在某些方面弥补了cms的不足，比如CMS采用mark sweep算法，会产生垃圾碎片，而G1采用coping算法，高效的整理内存空间而不会产生碎片
    + G1提供了更多手段来达到对gc停顿时间可控作准备

### G1堆结构

- 说起G1的堆结构，需要先说一说老一点垃圾收集器的堆结构，这包括 serial, parallel, CMS 这些垃圾收集器，它们都把堆分为了三个部分：固定大小的 young generation, old generation, and permanent generation，如下图所示：![image text](https://mmbiz.qpic.cn/mmbiz_png/BQGpt2vnVYVjlviaED6dibwX7RQjRLpMPBdEurcOFN7zt376iaWJkfEu76edp0eyc9MOgeXcF3Wv5tiat1DhyVGLrw/0?wx_fmt=png)
- G1取而代之的是，G1采取不同的策略来解决并行、串行和CMS收集器的碎片、停顿时间不可控的问题，G1将整个堆分成大小相同的分区（regions），每个region都有一个分代的角色：eden survivor old，意思是这个分代的角色现在只是个逻辑的概念，某个分区可能属于新生代或者老年代，但在一个特定的时刻有一个确定的角色，如下图所示![image text](https://mmbiz.qpic.cn/mmbiz_png/BQGpt2vnVYVjlviaED6dibwX7RQjRLpMPB4BqzoClSf6Uiamrr1aWIibtgGTrryEUWs0PIAMlbfMr4uCftI9gsOhsA/0?wx_fmt=png)
- 将 young generation, old generation 的物理空间取消了，这样再也不用单独的对每个代进行设置了，不用担心每个代内存是否足够，因为对每个角色的数量没有强制的限定，也就是说对每种分代的大小是可以动态调节的
- G1的最大特点是高效的执行回收，优先去执行那些大量对象可回收的区域region
- G1使用了GC停顿可预测的模型，来满足用户设定的GC停顿时间，根据用户设定的目标时间，G1会自动选择哪些region要清除，选择一次清除多少个region
- G1从多个region中复制存活的对象，然后放入一个region中，同时整理清除内存（coping算法）
- G1并非一个实时的收集器，与Parallel Scavenge 一样，对GC停顿时间设置并不是绝对生效，只是G1有较高对几率保证不超过设定的停顿时间，G1会根据用户的选择来只能评定哪些region需要被回收
- 在物理上不需要连续会带来额外的好处是有的分区垃圾对象特别多，有的分区垃圾对象少，G1会优先回收垃圾对象特别多的分区，这样可以花费较少的时间来完成这些分区的垃圾收集，这也就是G1名字的由来，优先收集垃圾多的分区
- 依然在新生代满了的时候，对整个新生代进行回收，整个新生代的对象要么回收要么晋升，至于新生代要采取分区机制的原因是因为和老年代的策略统一， 方便调整代的大小，这强调方便调整代的大小
- G1的Humongous区域
    + 在G1中还有一特殊的区域，Humongous区域。如果一个对象占用一个分区容量的50%甚至更多，G1收集器就认为这是一个巨型对象，这些巨型对象会被直接分入老年代，但是如果这巨型对象只是一个短暂存在的对象，就会对垃圾收集器造成负面的影响，为了解决这个为题，G1划分了一个Humongous区域， 用来专门存放巨型对象，如果一个H区装不下一个巨型对象，那么G1会寻找连续的H区来存放，为了能找到连续的H区，G1有时候不得不启动Full gc
- 对象的分配策略
    + TLAB(Thread Local Allocation Buffer)线程本地分配缓冲区
    + 每个线程在创建的时候会申请一块自己专属的内存区域，创建对象的时候可以快速给对象分配内存空间而不用去考虑一下安全性问题，比如并发问题，而不需要采用一些同步机制来管理共享空间内的空闲空间指针，这样为对象分配空间更高效
    + Eden区中分配
    + 对TLAB空间中无法分配的对象，JVM会尝试在Eden空间中进行分配。如果Eden空间无法容纳该对象，就只能在老年代中进行分配空间
    + Humongous区分配 见上一条
- 收集集合 CSet
    + 一组可被回收的分区集合，在CSet中存在的数据会在GC过程中被移动到另外一个可用分区，CSet中的分区可以来自Eden Survivor 和Old空间
- G1的两种垃圾收集模式，都会STW
    + young gc 选用所有年轻代里的Region，通过控制年轻代Region个数，即年轻代内存大小，来控制young gc的时间开销
    + mixed gc 1.选用所有年轻代里的Region，外加根据global concurrent marking 统计得出收集收益高的若干老年代Region，在用户指定的目标开销范围内最大可能的选择收益较高的老年代Region 2.mixed gc不是Full GC，只能回收部分老年代 Region，如果mixed gc实在无法跟上程序分配内存的速度，导致老年代填满无法继续进行mixed gc，那么就会使用serial old gc来收集整个内存区域，这是Full GC，所以本质上，G1不提供Full GC
- G1在运行过程中的主要模式
    + young gc
    + 并发阶段global concurrent marking，接下来会介绍
    + 混合模式
    + Full GC，一般是G1收集出现问题，收集速度赶不上垃圾产生的速度，就会使用serial old来进行Full GC
   
### G1 young gc

- G1 young gc 在Eden区充满时触发，在回收之后此前所有属于Eden的区域全部变成空白，即不属于任何一个分区（Eden Survivor Old）
- Eden空间的对象移动到survivor中，如果survivor空间容量也不够，Eden空间的部分数据会直接晋升到老年代。survivor区的数据移动到新的 survivor区中，也有部分数据晋升到老年代中。最终Eden空间变空，GC完成工作，应用线程继续执行
- 如果仅仅是GC新生代中的对象，如何找到所有的根对象呢？老年代对象也可能是根对象，那么老年代的所有对象都是跟对象么？如果这样扫描整个老年代会耗费大量的时间，于是，就有了RSet 的用武之地，RSet作用是跟踪指向某个Region内的对象，即谁引用了我这个region的对象。这样就可以找到所有的root对象了（根对象）![image text](https://mmbiz.qpic.cn/mmbiz_png/BQGpt2vnVYXELlhyTml1h5IwySUHY7qTicmNsKgMNaE75pSXgibfbiayqBjDiaHm9hTITfcfNicb6HUQtl6GjGUwk8Q/0?wx_fmt=png)
- RSet记录了其他Region中的对象引用了本Region中对象的关系，属于Points-into关系即谁引用了我，RSet在于垃圾收集器不用去 扫描整个堆就可以找到谁引用了当前分区的对象，只需要扫描RSet即可
- G1 GC是在points-out的Card Table上再增加一层结构来构成points-into RSet，每个Region会记录到底哪些别的Region有指向自己的记录， 而这些指针分别在哪些Card范围内
- 这个RSet其实是一个hash table，key是别的region的其实地址，value是一个集合，里面的元素是Card Table的index。比如上图右侧Region 1 的RSet里 有一项是上图左侧Region 2，key是左侧region的内存的起始地址，value是红色区域的index，说明在Region 2的一个card里有引用指向Region 1。所以对于Region 2来说，RSet记录里points-into 的关系，而Card table仍然是points-out的关系
- 那什么是Card Table呢？如果引用的对象过多，赋值器需要对每个引用做处理，赋值器开销也会很大，所以为了解决这个赋值器开销过大问题，G1中引入来Card Table的概念， card table 在逻辑上将一个分区分为多个大小固定的连续区域，通常在128到512字节之间，card table通常为字节数组，由card的索引（数值下标） 来标示每个分区的空间地址
- 在CMS中也有RSet的概念，在老年代有一块区域来记录指向新生代的引用，这样在进行young gc时候就不需要扫面整个老年代，只是扫面这一块区域就可以，这是一种point-out的概念，我引用了谁的概念
- 在G1中并没有采用point-out，因为G1分区容量太小，数量太多，如果point-out会造成太多的扫描浪费，有些不需要扫描的GC区域也要被扫描，所以 G1中采用point-into来解决，point-into标示来哪些对象引用了这些region，这样仅仅将这些对象当作跟对象来扫描就可以了。一方面因为这个，还有一方面是因为G1 GC年轻代是必然被收集的，整个年轻的都会被扫描，这样使用point-into正好可以扫描出那些老年代region引用了我，不会造成扫描的浪费，如果像CMS一样采用point-out的理念，每个老年代region都会有自己的point-out的RSet，这样就必须要扫描整个老年代来确认了
- 由于新生代由多个，那么需要记录新生代之间的引用吗？这是不必要的，因为在每次GC时，所有新生代都会被扫描，所以只需要记录老年代到新生代 的引用即可
- 处理阶段
    + 阶段1 根扫描 静态和本地对象被扫描
    + 阶段2 更新RSet 处理dirty card队列更新RSet
    + 阶段3 处理RSet 检测从年轻代指向老年代的对象
    + 阶段4 对象拷贝 拷贝存活的对象到Survivor Old
    + 阶段5 处理引用队列 软引用 弱引用 虚引用处理

### G1 并发阶段

- global concurrent marking 全局并发标记
- global concurrent marking的执行过程类似于cms，但是不同的是，在G1 gc中，他主要为mixed gc提供标记服务的，标记哪些老年代region更适合去收集，收集得到的效益高，但这并不是G1 mixed gc的一个必要环节
- 执行分为五个步骤
    + 初始标记 initial mark，会stw， 标记了从gc roots直接可达的对象
    + 根区域扫描 root region scan，在初始标记的存活区扫描对老年代的引用，并标记被引用的对象。该阶段与应用程序（非 STW）同时运行，并且只有完成该阶段后，才能开始下一次 STW 年轻代垃圾回收
    + 并发标记 concurrent marking， 这个阶段从gc roots开始对heap中的对象进行标记，标记线程与应用程序并发执行，并且收集各个region的存活情况，可以被年轻代的STW中断
    + 重新标记 remark stw，标记那些在并发标记阶段发生变化的对象，将被回收
    + 清理 clean up，清除空region，没有存活对象的，加入到free list，然后识别可供进行混合垃圾回收的区域，会 清空 SATB 缓冲区
    + 第一阶段的initial mark 是共用了 young gc 的暂停，这是因为他们可以复用root scan操作，所以可以说global concurrent marking是伴随 young gc发生的
    + 第五阶段的clean up 只是回收了没有存活对象的region，所以并不需要stw
- 其中步骤3的并发标记采用的是 三色标记算法，其中对象被分为三种类型
    + 黑色 根对象或者他的子对象都被扫描过了，（对象被标记了，并且所有field也被标记完了）
    + 灰色 对象本身被扫描，但还没扫描完自对象，（所有field并没有被扫面完）
    + 白色 未被扫描对象，扫描完之后，最终为白色的为不可达对象
- 下面演示下三色标记算法具体的流程
    + GC从根开始扫描对象，扫描到的子对象被置为灰色![image text](https://mmbiz.qpic.cn/mmbiz_png/BQGpt2vnVYVjlviaED6dibwX7RQjRLpMPBwmF4Bb3e1Dpic7qb7iaB0tuL6xGqrPkVNUaCicibSPdGCTOG2hJxdrMdRw/0?wx_fmt=png)
    + 然后继续扫描，从灰色进行扫描，自对象都被扫描标记完的编程黑色，被扫描到的对象标记为灰色，其中第二列第三个对象因为子对象未被全部扫描，所以这个对象还是灰色![image text](https://mmbiz.qpic.cn/mmbiz_png/BQGpt2vnVYVjlviaED6dibwX7RQjRLpMPB9TmhTNENaEch7RLnAJ2IYDWfmROO2NRAY3QazCytCqU792L7lyLo4w/0?wx_fmt=png)
    + 然后扫描完毕，所有可达对象都被标记为黑色，不可达对象标记为白色，白色是需要被清理的对象![image text](https://mmbiz.qpic.cn/mmbiz_png/BQGpt2vnVYVjlviaED6dibwX7RQjRLpMPBs6MG0wndffVp0PMUjpziciaHavASiblhnBalvhwdaicia27QX61ZGpZiaHNg/0?wx_fmt=png)
- 这样就完成了标记，看似很完美，但是这是并发标记阶段，标记的过程中用户程序也在运行，会引起对象引用关系的变化，就会造成 误标 和 漏标，误标就是把本是垃圾对象标记为了非垃圾对象，漏标是非垃圾对象没有被标记，误标是可以允许的，可以在下次垃圾回收清理，这类垃圾也被称为浮动垃圾floating garbage，漏标就不被允许了，会造成程序的错误。下面演示下漏标的一种情况
    + 此时扫描的情况为，C已经标记为黑色，子对象被扫描完，B子对象还未被扫描，为灰色![image text](https://mmbiz.qpic.cn/mmbiz_png/BQGpt2vnVYVjlviaED6dibwX7RQjRLpMPB1s2nFwbbDB9D57hJicXsl0fBWOj6ujsYibBFeTZWhcPCdWMalgWyicxMg/0?wx_fmt=png)
    + 接下来因为用户线程也在运行，如果运行一下代码
    ```
    C.D = B.D;
    B.D = null;
    ```
    + 那么此时引用关系就会变为如下图所描述情况![image text](https://mmbiz.qpic.cn/mmbiz_png/BQGpt2vnVYVjlviaED6dibwX7RQjRLpMPBO7WDasvmq7JJIvQyU7paPicvJ2RoRXwA9sz9T99MznOqmWlY5rvRiaug/0?wx_fmt=png)
    + 此时继续扫描，C为黑色，所以D不再会被标记，就出现了漏标的情况
- 其实上述问题可以总结为以下两种
    + 灰色对象引用被更改，这种解决方式为删除时候记录对象
    + 黑色对象引用被赋值，这种解决方式为插入时候记录对象
    + 上述两种方式对应于CMS和G1的两种解决方式
    + 在CMS采用的是增量更新（Incremental update），只要在写屏障（write barrier）里发现要有一个白对象的引用被赋值到一个黑对象的字段里，那就把这个白对象变成灰色的。即插入的时候记录下来
    + 对于G1在接下来讲述
- G1的SATB（snapshot-at-the-beginning）
    + 接上一小节，G1对应的是灰色对象引用被更改，记录该对象
    + 分为三个步骤
    + 1 在开始标记的时候生成一个快照图标记存活对象
    + 2 在并发标记的时候所有被改变的对象入队（在write barrier里把所有旧的引用所指向的对象都变成非白的）
    + 3 可能存在游离的垃圾，将在下次被收集

### G1 mixed gc

- 在全局并发标记中会标记出待清理的region加入CSet，所以说在G1 gc中，全局并发标记主要为mixed gc提供标记服务的，标记哪些老年代region更适合 去收集，收集得到的效益高，但全局并发标记并不是G1 mixed gc的一个必要环节
- mixed gc的触发条件 由一些参数控制，另外也控制着哪些老年代region会被选入CSet
- G1HeapWastePercent   在global concurrent marking 之后，可以知道old gen region中由多少空间被回收，在每次ygc之后和再次发生 Mixed gc之前，会检查垃圾占比是否超过此参数，只有达到了，下次才会发生 Mixed GC
- G1MixedGCLiveThresholdPercent   old generation region中的存活对象的占比，只有在此参数之下，才会被放入CSet。解释一下就是 old region在此参数之下说的是活的对象占比小，这些region基本上都是垃圾了，会对这些old region进行回收，所以放入CSet
- G1MixedGCCountTarget 一次global concurrent marking之后最多执行Mixed GC的次数
- G1OldCSetRegionThresholdPercent 一次mixed gc中最多能够被选入CSet的最多的old generation region的数量
- mixed gc 和 young gc 唯一的不同点是young gc的CSet是整个年轻代的垃圾，而mixed gc 的CSet不仅是整个年轻代垃圾，还有老年代中的垃圾（经过全剧并发标记统计得出的值得回收的老年代region），也是采用的coping算法。

### G1最佳实践

- 不断调优暂停时间指标
    + 通过-XX:MaxGCPauseMillis=X来设置启动应用程序的暂停时间，G1在运行的时候会根据这个参数来选择CSet来满足用户设置的时间，一般在100到200ms 之间，如果设置的太短如50ms的话，会让垃圾产生的速度大于回收的速度，最后退化为Full GC
- 不要设置老年代和新生代大小
    + G1收集器在运行是会动态调整新生代老年代大小，通过改变代的大小来调整对象晋升老年代的年龄，从而达到为收集器设置的暂停时间目标
    + 设置新生代大小相当于放弃了G1的动态调节能力，需要做的是设置整个堆的大小，让G1自己动态调节
- 关注 Evacuation Failure
    + Evacuation Failure 类似与CMS里边的晋升失败，堆空间垃圾太多导致无法完成Region之间的拷贝，没有足够的内存供存活对象或晋升对象使用，于是不得把退化成Full gc来完成一次全局 范围内的垃圾收集，由此触发了Full GC。可以在日志中看到(to-space exhausted)或者（to-space overflow）
    + 解决办法有三个
    + 增加 -XX:G1ReservePercent 选项的值（并相应增加总的堆大小），为“目标空间”增加预留内存量
    + 通过减少 -XX:InitiatingHeapOccupancyPercent 提前启动标记周期
    + 也可以通过增加 -XX:ConcGCThreads 选项的值来增加并行标记线程的数目
- 关注Humongous Allocation 巨型对象分配失败
    + 当巨型对象找不到合适的空间进行分配时，就会启动Full GC，来释放空间。这种情况下，应该避免分配大量的巨型对象，增加内存或者增大-XX:G1HeapRegionSize=X，使巨型对象不再是巨型对象

      

   

package section1.classloader;

/**
 * 应用模块名称<p>
 * 代码描述<p>
 *
 * @Author: Yummyxl
 * @Date: 2020/2/20
 *
 * Launcher 中 Thread.currentThread().setContextClassLoader(this.loader); 设置的
 */

public class Test23 implements Runnable {

    private Thread thread;

    public Test23() {
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        this.thread.setContextClassLoader(classLoader);
        System.out.println("class: " + classLoader.getClass());
        System.out.println("Parent: " + classLoader.getParent().getClass());
    }

    public static void main(String[] args) {
        new Test23();
    }
}

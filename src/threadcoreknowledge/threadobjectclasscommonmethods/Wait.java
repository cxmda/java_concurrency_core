package threadcoreknowledge.threadobjectclasscommonmethods;

/**
 * 展示wait和notify的基本用法 1. 研究代码执行顺序 2. 证明wait释放锁
 *
 * @author chen
 * @create 2020-05-29 22:00
 */
public class Wait {

    public static Object object = new Object();

    static class Thread1 extends Thread {
        @Override
        public void run() {
            synchronized (object) {
                System.out.println("线程" + Thread.currentThread().getName() + "开始执行。。。");
                try {
                    object.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("线程" + Thread.currentThread().getName() + "获取到锁了。。。");
            }
        }
    }

    static class Thread2 extends Thread {
        @Override
        public void run() {
            synchronized (object) {
                object.notify();
                System.out.println("线程" + Thread.currentThread().getName() + "调用了notify()");
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread1 thread1 = new Thread1();
        Thread2 thread2 = new Thread2();
        thread1.start();
        Thread.sleep(500);
        thread2.start();
    }
}

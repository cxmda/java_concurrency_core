package threadcoreknowledge.threadobjectclasscommonmethods;

/**
 * 两个线程交替打印0~100的奇偶数，用wait和notify
 *
 * @author chenqiang
 * @create 2020-05-30 16:26
 */
public class WaitNotifyPrintOddEveWait {

    public static int count = 0;

    public static final Object lock = new Object();

    public static void main(String[] args) {
        Runnable runnable = () -> {
            //1. 拿到锁，我们就打印
            //2. 打印完，唤醒其他线程，自己就休眠
            while (count <= 100) {
                synchronized (lock) {
                    //拿到锁，就打印
                    System.out.println(Thread.currentThread().getName() + ":" + count++);
                    lock.notify();
                    //如果任务还没结束，就让出当前的锁，并休眠
                    if(count <= 100){
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    }
                }
            }
        };
        Thread thread1 = new Thread(runnable,"偶数");
        Thread thread2 = new Thread(runnable,"奇数");
        thread1.start();
        thread2.start();
    }
}

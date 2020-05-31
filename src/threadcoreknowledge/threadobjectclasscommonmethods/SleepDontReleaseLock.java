package threadcoreknowledge.threadobjectclasscommonmethods;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 演示sleep不释放lock（lock需要手动释放）
 * @author chen
 * @create 2020-05-31 14:19
 */
public class SleepDontReleaseLock implements Runnable{

    private static final Lock lock = new ReentrantLock();

    @Override
    public void run() {
         lock.lock();
        System.out.println(Thread.currentThread().getName() + "拿到了锁");
        try {
            Thread.sleep(3000);
            System.out.println(Thread.currentThread().getName() + "已经苏醒");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
            System.out.println(Thread.currentThread().getName() + "释放了锁");
        }
    }

    public static void main(String[] args) {
        SleepDontReleaseLock runnable = new SleepDontReleaseLock();
        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);
        thread1.start();
        thread2.start();
    }
}

package threadcoreknowledge.threadobjectclasscommonmethods;

/**
 * 展示线程sleep的时候不释放synchronized的monitor，
 * 等sleep时间到了以后，正常结束后才释放锁
 * @author chen
 * @create 2020-05-31 14:14
 */
public class SleepDontReleaseMonitor implements Runnable{

    public static void main(String[] args) {
        SleepDontReleaseMonitor runnable = new SleepDontReleaseMonitor();
        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);
        thread1.start();
        thread2.start();
    }

    @Override
    public void run() {
        syc();
    }

    private synchronized void syc() {
        System.out.println(Thread.currentThread().getName() + "拿到了锁");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "释放了锁");
    }
}

package threadcoreknowledge.threadobjectclasscommonmethods;

/**
 * 证明wait只释放当前的那把锁
 * @author chen
 * @create 2020-05-29 22:27
 */
public class WaitNotifyReleaseOwnMonitor {

    public static volatile Object resourceA = new Object();
    public static volatile Object resourceB = new Object();

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            synchronized (resourceA){
                System.out.println(Thread.currentThread().getName() + "got resourceA lock");
                synchronized (resourceB){
                    System.out.println(Thread.currentThread().getName() + "got resourceB lock");
                    try {
                        System.out.println(Thread.currentThread().getName() + "release resourceA lock");
                        resourceA.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (resourceA){
                resourceA.notify();
                System.out.println(Thread.currentThread().getName() + "got resourceA lock");
                System.out.println(Thread.currentThread().getName() + "try to got resourceB lock");
                synchronized (resourceB){
                    System.out.println(Thread.currentThread().getName() + "got resourceB lock");
                }
            }
        });

        thread1.start();
        thread2.start();
    }
}

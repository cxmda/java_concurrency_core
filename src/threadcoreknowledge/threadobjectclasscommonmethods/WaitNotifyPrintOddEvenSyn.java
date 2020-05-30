package threadcoreknowledge.threadobjectclasscommonmethods;

/**
 * 两个线程交替打印0~100的奇偶数，用synchronized关键字实现
 *
 * @author chenqiang
 * @create 2020-05-30 16:17
 */
public class WaitNotifyPrintOddEvenSyn {

    public static int count = 0;

    public static final Object lock = new Object();

    public static void main(String[] args) {
        new Thread(() -> {
            while (count < 100) {
                synchronized (lock) {
                    if ((count & 1) == 0) {
                        System.out.println(Thread.currentThread().getName() + ": " + count++);
                    }
                }
            }
        },"偶数").start();

        new Thread(() ->{
            while (count < 100){
                synchronized (lock){
                    if((count & 1) == 1){
                        System.out.println(Thread.currentThread().getName() + ": " + count++);
                    }
                }
            }
        },"奇数").start();
    }
}

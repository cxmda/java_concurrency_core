package threadcoreknowledge.threadobjectclasscommonmethods;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * 每个1秒钟输出当前时间，被中断，观察。
 * @author chen
 * @create 2020-05-31 14:55
 */
public class SleepInterrupt implements Runnable{

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new SleepInterrupt());
        thread.start();
        Thread.sleep(3000);
        thread.interrupt();
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(new Date());
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                System.out.println("我被中断了");
                e.printStackTrace();
            }
        }
    }
}

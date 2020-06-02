package jmm;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 适用于volatile的场景
 * @author chenqiang
 * @create 2020-06-02 19:14
 */
public class UseVolatile implements Runnable {

    volatile boolean flag = false;

    AtomicInteger atomicInteger = new AtomicInteger();

    public static void main(String[] args) throws InterruptedException {
        UseVolatile useVolatile = new UseVolatile();
        Thread thread1 = new Thread(useVolatile);
        Thread thread2 = new Thread(useVolatile);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(useVolatile.flag);
        System.out.println(useVolatile.atomicInteger.get());
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            atomicInteger.incrementAndGet();
            flipDone();
        }
    }

    private void flipDone() {
        //赋值是原子性操作（不取决于原来变量的值）
        flag = true;
    }
}

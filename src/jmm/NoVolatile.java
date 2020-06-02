package jmm;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 不适用于volatile的场景
 * @author chenqiang
 * @create 2020-06-02 19:04
 */
public class NoVolatile implements Runnable{

    volatile int a = 0;

    AtomicInteger atomicInteger = new AtomicInteger();

    public static void main(String[] args) throws InterruptedException {
        NoVolatile noVolatile = new NoVolatile();
        Thread thread1 = new Thread(noVolatile);
        Thread thread2 = new Thread(noVolatile);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println("a = " +noVolatile.a);
        System.out.println(noVolatile.atomicInteger.get());
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            atomicInteger.incrementAndGet();
            a++;
        }
    }
}

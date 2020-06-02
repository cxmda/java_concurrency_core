package jmm;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 不适用于volatile的场景
 * @author chenqiang
 * @create 2020-06-02 19:14
 */
public class NoVolatile2 implements Runnable {

    volatile boolean flag = false;

    AtomicInteger atomicInteger = new AtomicInteger();

    public static void main(String[] args) throws InterruptedException {
        NoVolatile2 useVolatile = new NoVolatile2();
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
            setTrue();
        }
    }

    private void setTrue() {
        //与原来的变量有关，需要先拿到flag，所以不是原子操作
        flag = !flag;
    }
}

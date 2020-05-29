package threadcoreknowledge.threadobjectclasscommonmethods;

/**
 * 3个线程，线程1和线程2首先被阻塞，线程3唤醒它们。notify, notifyAll。 start先执行不代表线程先启动。
 * @author chen
 * @create 2020-05-29 22:14
 */
public class WaitNotifyAll implements Runnable{

    public static Object object = new Object();

    public static void main(String[] args) throws InterruptedException {
        WaitNotifyAll runnable = new WaitNotifyAll();
        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);
        thread1.start();
        thread2.start();
        Thread.sleep(500);
        new Thread(() -> {
            synchronized (object){
                object.notifyAll();
                System.out.println(Thread.currentThread().getName() + "notifyAll()");
            }
        }).start();
    }

    @Override
    public void run() {
        synchronized (object){
            System.out.println(Thread.currentThread().getName() + "got resource lock");
            try {
                System.out.println(Thread.currentThread().getName()+" waits to start.");
                object.wait();
                System.out.println(Thread.currentThread().getName()+"'s waiting to end.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

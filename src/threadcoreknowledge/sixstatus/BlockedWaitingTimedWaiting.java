package threadcoreknowledge.sixstatus;

/**
 * 展示Blocked, Waiting, TimedWaiting
 * @author chen
 * @create 2020-05-28 22:42
 */
public class BlockedWaitingTimedWaiting implements Runnable{

    public static void main(String[] args) {
        BlockedWaitingTimedWaiting runable = new BlockedWaitingTimedWaiting();
        Thread thread1 = new Thread(runable);
        thread1.start();
        Thread thread2 = new Thread(runable);
        thread2.start();
        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //打印出Timed_Waiting状态，因为正在执行Thread.sleep(1000);
        System.out.println(thread1.getState());
        //打印出BLOCKED状态，因为thread2想拿得到sync()的锁却拿不到
        System.out.println(thread2.getState());
        try {
            Thread.sleep(1300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //打印出WAITING状态，因为执行了wait()
        System.out.println(thread1.getState());
    }

    @Override
    public void run() {
        syc();
    }

    public synchronized void syc(){
        try {
            Thread.sleep(1000);
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

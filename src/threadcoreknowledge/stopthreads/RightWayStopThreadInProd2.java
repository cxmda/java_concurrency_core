package threadcoreknowledge.stopthreads;

/**
 *  最佳实践：在catch语句中调用Thread.currentThread().interrupt()来恢复设置中断状态，
 *  以便于在后续的执行中，依然能够检查到刚才发生了中断回到刚才
 *  RightWayStopThreadInProd补上中断，让它跳出
 * @author chenqiang
 * @create 2020-05-28 14:00
 */
public class RightWayStopThreadInProd2 implements Runnable{

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new RightWayStopThreadInProd2());
        thread.start();
        Thread.sleep(1000);
        thread.interrupt();
    }

    @Override
    public void run() {
        while (true) {
            if (Thread.currentThread().isInterrupted()) {
                System.out.println("线程被中断了");
                break;
            }
            throwInMethod();
        }
    }

    private void throwInMethod() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }
    }
}

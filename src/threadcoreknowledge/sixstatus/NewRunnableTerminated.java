package threadcoreknowledge.sixstatus;

/**
 * 展示线程的NEW、RUNNABLE、Terminated状态。
 * 即使是正在运行，也是Runnable状态，而不是Running。
 * @author chen
 * @create 2020-05-28 22:32
 */
public class NewRunnableTerminated implements Runnable{

    public static void main(String[] args) throws InterruptedException {
        NewRunnableTerminated runnable = new NewRunnableTerminated();
        Thread thread = new Thread(runnable);
        //打印出NEW的状态
        System.out.println(thread.getState());
        thread.start();
        System.out.println(thread.getState());
        Thread.sleep(10);
        //打印出RUNNABLE的状态，即使是正在运行，也是RUNNABLE，而不是RUNNING
        System.out.println(thread.getState());
        Thread.sleep(50);
        //打印出TERMINATED状态
        System.out.println(thread.getState());
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println(i);
        }
    }
}

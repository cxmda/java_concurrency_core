package threadcoreknowledge.createthreads.wrongways;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @author chenqiang
 * @create 2020-05-26 16:05
 */
public class DemoTimmerTask {

    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                    System.out.println(Thread.currentThread().getName());
            }
        },1000,1000);
    }
}

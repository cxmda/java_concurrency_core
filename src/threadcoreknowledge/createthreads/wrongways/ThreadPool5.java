package threadcoreknowledge.createthreads.wrongways;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author chenqiang
 * @create 2020-05-26 16:04
 */
public class ThreadPool5 {

    public static void main(String[] args) {
        ExecutorService service = Executors.newCachedThreadPool();
        service.execute(
            () -> {
                System.out.println(Thread.currentThread().getName());
            
        });
        service.shutdown();
    }
}

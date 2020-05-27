package threadcoreknowledge.createthreads.wrongways;

/**
 * @author chenqiang
 * @create 2020-05-26 16:09
 */
public class Lambda {
    public static void main(String[] args) {
        new Thread(
                () -> System.out.println(Thread.currentThread().getName()))
                .start();
    }
}

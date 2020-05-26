package threadcoreknowledge.createthreads.wrongways;

/**
 * @author chenqiang
 * @create 2020-05-26 16:10
 */
public class AnonymousInnerClassDemo {

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        }).start();

        new Thread(){
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        }.start();
    }
}

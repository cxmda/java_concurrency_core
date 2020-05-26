package threadcoreknowledge.createthreads;

/**
 * @author chenqiang
 * @create 2020-05-26 15:43
 */
public class BothRunnableThread {

    public static void main(String[] args) {
        new Thread(() ->{
                System.out.println("这是Runnable的run()");
        }){
            @Override
            public void run() {
                System.out.println("这是重写Thread类的run()");
            }
        }.start();
    }
}

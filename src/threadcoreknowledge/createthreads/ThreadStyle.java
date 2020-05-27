package threadcoreknowledge.createthreads;

/**
 * @author chenqiang
 * @create 2020-05-26 15:08
 */
public class ThreadStyle extends Thread{

    @Override
    public void run() {
        System.out.println("继承Thread创建的线程");
    }

    public static void main(String[] args) {
        ThreadStyle threadStyle = new ThreadStyle();
        threadStyle.start();
    }
}

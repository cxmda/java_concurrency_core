package threadcoreknowledge.createthreads;

/**
 * @author chenqiang
 * @create 2020-05-26 15:06
 */
public class RunnableStyle implements Runnable{
    @Override
    public void run() {
        System.out.println("实现Runnable创建的线程");
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new RunnableStyle());
        thread.start();
    }
}

package background;

/**
 * @author chenqiang
 * @create 2020-06-01 14:10
 */
public class MultiThreadError implements Runnable {

    static Object o1 = new Object();
    static Object o2 = new Object();
    int flag = 1;

    public static void main(String[] args) {
        MultiThreadError runnable1 = new MultiThreadError();
        MultiThreadError runnable2 = new MultiThreadError();
        runnable1.flag = 1;
        runnable1.flag = 0;
        new Thread(runnable1).start();
        new Thread(runnable2).start();
    }

    @Override
    public void run() {
        System.out.println("flag = " + flag);
        if (flag == 1) {
            synchronized (o1){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (o2){
                    System.out.println("1");
                }
            }
        }

        if (flag == 0) {
            synchronized (o2){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (o1){
                    System.out.println("0");
                }
            }
        }
    }
}

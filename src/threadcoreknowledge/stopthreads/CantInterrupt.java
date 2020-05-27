package threadcoreknowledge.stopthreads;

/**
 * 如果while里面放try/catch，会导致中断失效
 * @author chenqiang
 * @create 2020-05-27 15:19
 */
public class CantInterrupt {
    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = () -> {
            int num = 0;
            while (num <= 30000 && !Thread.currentThread().isInterrupted()){
                if(num % 100 == 0){
                    System.out.println(num + "是100的倍数");
                }
                num++;
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
        Thread.sleep(1000);
        thread.interrupt();
    }
}

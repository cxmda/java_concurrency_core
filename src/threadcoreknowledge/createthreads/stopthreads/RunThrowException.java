package threadcoreknowledge.createthreads.stopthreads;

/**
 * run方法无法抛出checked Exception，只能用try/catch
 * @author chen
 * @create 2020-05-27 22:41
 */
public class RunThrowException {

    public void aVoid() throws Exception {
        throw new Exception();
    }

    public static void main(String[] args) {
        Runnable runnable = () ->{
            try {
                throw new Exception();
            } catch (Exception e) {
                e.printStackTrace();
            }
        };
    }
}

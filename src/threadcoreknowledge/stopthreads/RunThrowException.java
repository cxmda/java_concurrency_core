package threadcoreknowledge.stopthreads;

/**
 * run方法无法抛出checked Exception，只能用try/catch
 * @author chenqiang
 * @create 2020-05-28 14:02
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

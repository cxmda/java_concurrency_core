package singleton;

/**
 * 静态内部类（可用）
 *
 * @author chenqiang
 * @create 2020-06-03 9:52
 */
public class Singleton7 {

    private Singleton7() {

    }

    private static class SingletonInstance {
        private static final Singleton7 INSTANCE = new Singleton7();
    }

    public static Singleton7 getInstance() {
        return SingletonInstance.INSTANCE;
    }
}

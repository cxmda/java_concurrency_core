package singleton;

/**
 * 懒汉式（线程不安全）（不推荐）
 *
 * @author chenqiang
 * @create 2020-06-03 9:52
 */
public class Singleton5 {

    private static Singleton5 INSTANCE;

    private Singleton5() {

    }

    public static Singleton5 getInstance() {
        if (INSTANCE == null) {
            synchronized (Singleton5.class) {
                INSTANCE = new Singleton5();
            }
        }
        return INSTANCE;
    }
}

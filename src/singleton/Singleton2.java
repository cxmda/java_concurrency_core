package singleton;

/**
 * 饿汉式（静态代码块）（可用）
 * @author chenqiang
 * @create 2020-06-03 9:52
 */
public class Singleton2 {

    private static final Singleton2 INSTANCE;

    static {
        INSTANCE = new Singleton2();
    }

    private Singleton2() {

    }

    public static Singleton2 getInstance() {
        return INSTANCE;
    }
}

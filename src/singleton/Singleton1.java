package singleton;

/**
 *  饿汉式（静态常量）（可用）
 * @author chenqiang
 * @create 2020-06-03 9:52
 */
public class Singleton1 {

    private static final Singleton1 INSTANCE = new Singleton1();

    private Singleton1() {

    }

    public static Singleton1 getInstance() {
        return INSTANCE;
    }
}

package singleton;

/**
 * 懒汉式（双重检查，线程安全）（推荐）
 *
 * @author chenqiang
 * @create 2020-06-03 9:52
 */
public class Singleton6 {

    //创建对象不是原子性操作，需要使用volatile保证原子性
    private volatile static Singleton6 INSTANCE;

    private Singleton6() {

    }

    public static Singleton6 getInstance() {
        if (INSTANCE == null) {
            synchronized (Singleton6.class) {
                if (INSTANCE == null) {
                    INSTANCE = new Singleton6();
                }
            }
        }
        return INSTANCE;
    }
}

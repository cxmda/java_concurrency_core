package singleton;

/**
 * 懒汉式（线程安全）（不推荐）
 *
 * @author chenqiang
 * @create 2020-06-03 9:52
 */
public class Singleton4 {

    private static Singleton4 INSTANCE;

    private Singleton4() {

    }

    public synchronized static Singleton4 getInstance() {
        if(INSTANCE == null){
                INSTANCE = new Singleton4();
        }
        return INSTANCE;
    }
}

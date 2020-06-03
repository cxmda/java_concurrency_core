package singleton;

/**
 * 懒汉式（线程不安全）（不可用）
 *
 * @author chenqiang
 * @create 2020-06-03 9:52
 */
public class Singleton3 {

    private static Singleton3 INSTANCE;

    private Singleton3() {

    }

    public static Singleton3 getInstance() {
        if(INSTANCE == null){
            INSTANCE = new Singleton3();
        }
        return INSTANCE;
    }
}

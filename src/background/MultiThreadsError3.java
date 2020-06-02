package background;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chenqiang
 * @create 2020-06-01 14:31
 */
public class MultiThreadsError3 {

    private Map<String, String> status;

    public MultiThreadsError3() {
        status = new HashMap<>();
        status.put("1", "星期一");
        status.put("2", "星期二");
        status.put("3", "星期三");
        status.put("4", "星期四");
    }

    public Map<String, String> getStatus() {
        return status;
    }

    public static void main(String[] args) {
        MultiThreadsError3 multiThreadsError3 = new MultiThreadsError3();
        Map<String, String> status = multiThreadsError3.getStatus();
        System.out.println(status.get("1"));
        status.remove("1");
        System.out.println(status.get("1"));
    }
}

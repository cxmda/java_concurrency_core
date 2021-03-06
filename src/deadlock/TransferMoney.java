package deadlock;

/**
 * 转账时候遇到死锁，一旦打开注释，便会发生死锁
 *
 * @author chenqiang
 * @create 2020-06-03 15:16
 */
public class TransferMoney implements Runnable {

    int flag = 1;
    static Account a = new Account(500);
    static Account b = new Account(500);
    static Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {
        TransferMoney r1 = new TransferMoney();
        TransferMoney r2 = new TransferMoney();
        r1.flag = 1;
        r2.flag = 0;
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("账户a余额" + a.balance + "元");
        System.out.println("账户b余额" + b.balance + "元");
    }

    @Override
    public void run() {
        if (flag == 1) {
            transformAccount(a, b, 300);
        }
        if (flag == 0) {
            transformAccount(b, a, 200);
        }
    }

    public static void transformAccount(Account from, Account to, int money) {

        class Helper{
            public void transfer(){
                if (from.balance - money < 0) {
                    System.out.println("账户余额不足，转账失败");
                }
                from.balance -= money;
                to.balance += money;
                System.out.println("成功转账" + money + "元");
            }
        }
        //避免死锁：避免相反获取锁的顺序
        int fromHash = System.identityHashCode(from);
        int toHash = System.identityHashCode(to);

        if(fromHash < toHash){
            synchronized (from) {
                synchronized (to) {
                    new Helper().transfer();
                }
            }
        }else if(fromHash > toHash){
            synchronized (to) {
                synchronized (from) {
                    new Helper().transfer();
                }
            }
        }else{
            synchronized (lock){
                synchronized (to) {
                    synchronized (from) {
                        new Helper().transfer();
                    }
                }
            }
        }
    }
}

class Account {

    int balance;

    public Account(int balance) {
        this.balance = balance;
    }
}


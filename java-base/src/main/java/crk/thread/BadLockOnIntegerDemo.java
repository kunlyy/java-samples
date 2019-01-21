package crk.thread;

/**
 * Created by kunlyy on 2019/1/20.
 */
public class BadLockOnIntegerDemo implements Runnable {
//    public static Integer integer = 0;
    public static int integer = 0;

    public static BadLockOnIntegerDemo instance = new BadLockOnIntegerDemo();
    @Override
    public void run() {
        for (int i = 0; i < 1000000; i++) {
//            synchronized (instance) {
                integer ++ ;
//            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(instance);
        Thread t2 = new Thread(instance);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(integer);
    }
}

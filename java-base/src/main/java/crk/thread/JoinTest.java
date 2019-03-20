package crk.thread;

/**
 * join()方法会无限等待，它会一直阻塞当前线程，直到目标线程执行完毕
 *
 * join()方法使调用该方法的线程在此之前执行完毕，也就是主线程会等待(调用该方法的线程执行完毕后)再往下继续执行.
 *
 * join()方法会抛出InterruptedException异常
 */
public class JoinTest implements Runnable {

    public static int a = 0;

    @Override
    public void run() {
        for (int i = 0; i < 500000; i++) {
            a++;
        }

    }

    /**
     * 这个例子中，如果不用join()方法，main很可能输出a的值是0或者很小的数，但是调用join()方法或，main函数会
     * 一直等待t线程执行完毕才会继续执行
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        JoinTest joinTest = new JoinTest();
        Thread t = new Thread(joinTest);
        t.start();
        t.join();
        System.out.println(a);
    }

}

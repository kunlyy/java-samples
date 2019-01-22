package crk.thread;

/**
 * wait()方法有异常:InterruptedException抛出。需要不活或者往上继续抛出，notify(),notifyAll()没有异常抛出
 *
 * Created by kunlyy on 2019/1/20.
 */
public class WaitNotifyDemo {
    final static Object object = new Object();

    public static class T1 extends Thread {
        @Override
        public void run() {
            synchronized (object) {
                System.out.println(System.currentTimeMillis() + " T1 START");
                try {
                    System.out.println(System.currentTimeMillis() + " T1 WAIT FOR OBJECT");
                    object.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(System.currentTimeMillis() + " T1 END");
            }
        }
    }

    public static class T2 extends Thread {
        @Override
        public void run() {
            synchronized (object) {
                System.out.println(System.currentTimeMillis() + " T2 START! NOFITY ONE THREAD");
                object.notify();
                System.out.println(System.currentTimeMillis() + " T2 END");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        /**
         * 可以看出wait()是等待资源的释放（获取到锁的权限）才继续执行，notify()就是释放资源，通知
         * 其他线程可以获取锁
         */
        Thread t1 = new T1();
        Thread t2 = new T2();

        t1.start();

        /**
         * 同一个线程执行两次start()方法，会报错：java.lang.IllegalThreadStateException
         */
        t2.start();
//        t2.start();
    }

}

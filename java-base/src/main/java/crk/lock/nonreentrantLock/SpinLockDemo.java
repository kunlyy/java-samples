package crk.lock.nonreentrantLock;

public class SpinLockDemo {
	private SpinLock lock =  new SpinLock();
    class Widget{
        public void doSomething(){
            lock.lock();
            System.out.println("Widget calling doSomething");
            lock.unlock();
        }
    }

    class LoggingWidget extends Widget {
        @Override
        public void doSomething() {
            lock.lock();
            System.out.println("LoggingWidget calling doSomething");
            super.doSomething();
            lock.unlock();
        }
    }

    public static void main(String[] args){
        SpinLockDemo spinLockDemo = new SpinLockDemo();
        Widget widget = spinLockDemo.new LoggingWidget();
        widget.doSomething();
    }
}
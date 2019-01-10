package crk.thread.readwritelock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class CacheDemo {
    private static ReadWriteLock rwl = new ReentrantReadWriteLock(); //读写锁
    private static Lock readLock = rwl.readLock();
    private static Lock writeLock = rwl.writeLock();
    
    private static Map<String, Object> cache = new HashMap<String, Object>();
    public static void main(String[] args) {
        for(int j=0;j<10;j++){ //写入
            final String key= "key"+j;
            new Thread(new Runnable() {
                public void run() {
                     put(key,key);
                }
            }).start();
            new Thread(new Runnable() { //读取
                public void run() {
                    getData(key);
                }
            }).start();
        }
    }
    //取
    public  static Object getData(String key){
        //rwl.readLock().lock();
    	readLock.lock();
        Object value = null;
        try{
            value = cache.get(key);
            if(value == null){
            	readLock.unlock();
            	writeLock.lock();
                try{
                    if(value==null){
                        value = "no";//实际是去queryDB();
                    }
                }finally{
                    writeLock.unlock();
                }
                readLock.lock();
            }
            System.out.println(Thread.currentThread().getName()+"-- get data : {key:"+key+",value: "+value+"}");
        }finally{
           readLock.unlock();
        }
        return value;
    }
    //存
    public static void put(String key,Object value){
        writeLock.lock();
        System.out.println("begin of put data >>");
        try{
            Thread.sleep(10);
            if(key != null){
                cache.put(key, value);
            }
            System.out.println(Thread.currentThread().getName()+"-- put data :  {key:"+key+",value: "+value+"}");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally{
        	System.out.println("end of put data >>");
        	writeLock.unlock();
        }
       
    }
}

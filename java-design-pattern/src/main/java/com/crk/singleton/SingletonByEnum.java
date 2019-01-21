package com.crk.singleton;

/**
 * 通过枚举创建单例
 * Created by kunlyy on 2019/1/19.
 */
public class SingletonByEnum {

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                SingletonByEnum instance = SingletonEnum.INSTANCE.getInstance();
                System.out.println(Thread.currentThread().getId() + "**" +
                        Thread.currentThread().getName() + "**" + instance);
            }).start();
        }
    }

}

/**
 * 利用枚举的特性：构造方法是私有的；每个枚举的实例都是默认static final的；
 * 枚举的单例也是懒加载的单例，是在需要获取单例实例的时候才创建实例
 *
 *
 * 《Effective java中文版第2版》：枚举无偿的提供了序列化机制，绝对防止多次实例化，
 * 即使是在面对复杂得序列化或作反射攻击的时候
 */
enum SingletonEnum{
    INSTANCE;

    private SingletonByEnum instance;

    SingletonEnum() {
        instance = new SingletonByEnum();
    }

    public SingletonByEnum getInstance() {
        return instance;
    }
}

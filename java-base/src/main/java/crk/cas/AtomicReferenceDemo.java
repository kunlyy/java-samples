package crk.cas;

import java.util.concurrent.atomic.AtomicReference;

/**
 * 演示了使用AtomicReference使用过程中有可能出现ABA的问题
 * Created by kunlyy on 2019/1/13.
 */
public class AtomicReferenceDemo {
    /**
     * 如果money小于20元就自动赠送20元
     */
    static AtomicReference<Integer> momey = new AtomicReference<>(19);

    /**
     * 自动赠送
     */
    public static void donate () {
        for(int i = 0; i < 5; i++) {
            new Thread(() -> {
                    while (true) {
                        while (true) {
                            Integer m = momey.get();
                            if (m < 20) {
                                if (momey.compareAndSet(m, m + 20)) {
                                    System.out.println("余额小于20，赠送成功，余额：" + momey.get());
                                    break;
                                }
                            } else {
//                                System.out.println("余额大于20，无须赠送");
                                break;
                            }
                        }
                    }
            }).start();
        }
    }

    /**
     * 用户消费
     */
    public static void consume() {
        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                while (true) {
                    Integer m = momey.get();
                    if (m > 10) {
                        System.out.println("余额大于10元");
                        if (momey.compareAndSet(m, m -10)) {
                            System.out.println("成功消费10元，余额：" + momey.get());
                            break;
                        }
                    } else {
                        System.out.println("余额不足");
                        break;
                    }
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    public static void main(String[] args) {
        /**
         * 余额小于20，赠送成功，余额：39
         余额大于20，无须赠送
         余额大于20，无须赠送
         余额大于10元
         成功消费10元，余额：29
         余额大于10元
         成功消费10元，余额：19
         余额大于10元
         成功消费10元，余额：9
         余额大于10元
         余额小于20，赠送成功，余额：29
         成功消费10元，余额：19
         余额大于10元
         成功消费10元，余额：9
         */
        /**
         * 多线程情况下，赠送的操作不止进行了一次
         */
        //赠送线程启动
        donate();
        //消费线程启动
        consume();
    }
}

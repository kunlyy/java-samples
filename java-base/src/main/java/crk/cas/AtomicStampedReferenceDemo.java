package crk.cas;

import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * 演示了使用AtomicStampedReference可以避免出现ABA的问题
 * Created by kunlyy on 2019/1/13.
 */
public class AtomicStampedReferenceDemo {
    /**
     * 如果money小于20元就自动赠送20元
     */
    static AtomicStampedReference<Integer> momey = new AtomicStampedReference<>(19, 0);

    /**
     * 自动赠送
     */
    public static void donate () {
        for(int i = 0; i < 3; i++) {
            int timestamp = momey.getStamp();
            new Thread(() -> {
                    while (true) {
                        while (true) {
                            Integer m = momey.getReference();
                            if (m < 20) {
                                if (momey.compareAndSet(m, m + 20, timestamp, timestamp + 1)) {
                                    System.out.println("余额小于20，赠送成功，余额：" + momey.getReference());
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
                int timestamp = momey.getStamp();
                while (true) {
                    Integer m = momey.getReference();
                    if (m > 10) {
                        System.out.println("余额大于10元");
                        if (momey.compareAndSet(m, m -10, timestamp, timestamp + 1)) {
                            System.out.println("成功消费10元，余额：" + momey.getReference());
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
         余额大于10元
         成功消费10元，余额：29
         余额大于10元
         成功消费10元，余额：19
         余额大于10元
         成功消费10元，余额：9
         余额不足
         */
        /**
         * 账号只会被赠送一次
         */
        //赠送线程启动
        donate();
        //消费线程启动
        consume();
    }
}

package com.zl.concurrent;

/**
 * @author zhanglan
 * @description
 * @date 2020-07-19
 */
public class VolatileAtomicSample {

    private volatile static int count = 0;

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    count++;
                }
            }).start();
        }
        Thread.sleep(2000);
        System.out.println("count = " + count);
    }

}

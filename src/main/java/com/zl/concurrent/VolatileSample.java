package com.zl.concurrent;

/**
 * @author zhanglan
 * @description
 * @date 2020-07-19
 */
public class VolatileSample {

    private static volatile boolean flag = false;

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            while (!flag) {
            }
            System.out.println("flag为" + flag + "，t1跳出循环...");
        });

        Thread t2 = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            flag = true;
            System.out.println("t2将flag置为true...");
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("t1、t2执行结束...");
    }

}

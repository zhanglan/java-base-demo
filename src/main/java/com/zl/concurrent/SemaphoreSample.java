package com.zl.concurrent;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

/**
 * @author zhanglan
 * @description
 * @date 2020-07-22
 */
public class SemaphoreSample implements Runnable {

    private static final Semaphore semaphore = new Semaphore(2);

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        try {
            semaphore.acquire();
            System.out.println(name + "获取了共享资源...");
            TimeUnit.SECONDS.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println(name + "释放了共享资源...");
            semaphore.release();
        }
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new SemaphoreSample(), "t1");
        Thread t2 = new Thread(new SemaphoreSample(), "t2");
        Thread t3 = new Thread(new SemaphoreSample(), "t3");
        Thread t4 = new Thread(new SemaphoreSample(), "t4");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }

}

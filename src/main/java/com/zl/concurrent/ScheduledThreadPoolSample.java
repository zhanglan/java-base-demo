package com.zl.concurrent;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author zhanglan
 * @description
 * @date 2020-08-09
 */
public class ScheduledThreadPoolSample {

    public static void main(String[] args) {
        ScheduledExecutorService pool = Executors.newScheduledThreadPool(5);
        // 定时任务，不管前面的任务执行完与否，到了固定的时间间隔就执行下一个任务
        pool.scheduleAtFixedRate(() -> {
            System.out.println(System.currentTimeMillis());
        }, 2, 1, TimeUnit.SECONDS);

        // 前一个任务执行完，才开始进行延时计时，然后再执行后面的任务
        pool.scheduleWithFixedDelay(() -> {
            System.out.println(System.currentTimeMillis());
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, 2, 1, TimeUnit.SECONDS);
    }

}

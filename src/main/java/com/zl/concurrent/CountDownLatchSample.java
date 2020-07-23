package com.zl.concurrent;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author zhanglan
 * @description
 * @date 2020-07-23
 */
public class CountDownLatchSample implements Runnable  {

	private CountDownLatch latch;

	public CountDownLatchSample(CountDownLatch latch) {
		this.latch = latch;
	}

	@Override
	public void run() {
		try {
			Random random = new Random();
			int time = random.nextInt(10);
			String name = Thread.currentThread().getName();
			System.out.println(name + "执行任务需要" + time + "秒...");
			TimeUnit.SECONDS.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			latch.countDown();
		}
	}

	public static void main(String[] args) throws InterruptedException {
		CountDownLatch latch = new CountDownLatch(10);
		long startTime = System.currentTimeMillis();
		for (int i = 0; i < 10; i++) {
			new Thread(new CountDownLatchSample(latch), "线程" + i).start();
		}
		latch.await();
		System.out.println("执行任务共使用了" + (System.currentTimeMillis() - startTime) / 1000 + "秒...");
	}

}

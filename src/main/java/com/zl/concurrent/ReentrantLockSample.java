package com.zl.concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zhanglan
 * @description
 * @date 2020-07-21
 */
public class ReentrantLockSample implements Runnable {

//	private static final ReentrantLock lock = new ReentrantLock();

	private static final MyLock lock = new MyLock();

	@Override
	public void run() {
		try {
			lock.lock();
			System.out.println(Thread.currentThread().getName() + "第一次获得了锁");
			lock.lock();
			System.out.println(Thread.currentThread().getName() + "第二次获得了锁");
			TimeUnit.SECONDS.sleep(2);
			System.out.println(Thread.currentThread().getName() + "第一次释放了锁");
			lock.unlock();
			TimeUnit.SECONDS.sleep(2);
			System.out.println(Thread.currentThread().getName() + "第二次释放了锁");
			lock.unlock();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		for (int i = 0; i < 2; i++) {
			new Thread(new ReentrantLockSample(), "线程"+i).start();
		}
	}

}

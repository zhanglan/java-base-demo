package com.zl.concurrent;

import java.util.concurrent.TimeUnit;

/**
 * @author zhanglan
 * @description
 * @date 2020-07-29
 */
public class ThreadSample {
	private final static Object lock = new Object();

	private static void waitTest() {
		synchronized (lock) {
			System.out.println(Thread.currentThread().getName() + "进入test方法...");
			try {
				lock.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + "退出test方法...");
		}
	}

	private static void notifyTest() {
		synchronized (lock) {
			System.out.println(Thread.currentThread().getName() + "唤醒某个等待线程...");
			lock.notify();
			try {
				lock.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + "执行notifyTest结束");
		}
	}

	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread(() -> waitTest());
		Thread t2 = new Thread(() -> notifyTest());
		t1.start();

		TimeUnit.SECONDS.sleep(5);
		System.out.println("开启t2...");
		t2.start();
	}

}

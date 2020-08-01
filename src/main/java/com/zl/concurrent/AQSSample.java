package com.zl.concurrent;

import com.zl.concurrent.aqs.AbstractQueuedSynchronizer;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;

/**
 * @author zhanglan
 * @description
 * @date 2020-07-31
 */
public class AQSSample {
	private static final MyLock lock;
	private static final AbstractQueuedSynchronizer.ConditionObject c1;
	private static final AbstractQueuedSynchronizer.ConditionObject c2;

	static {
		lock = new MyLock();
		c1 = (AbstractQueuedSynchronizer.ConditionObject) lock.newCondition();
		c2 = (AbstractQueuedSynchronizer.ConditionObject) lock.newCondition();
	}

	private static void awaitC1() {
		try {
			lock.lockInterruptibly();
			c1.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	private static void awaitC2() {
		try {
			lock.lockInterruptibly();
			c2.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	private static void signalC1() {
		try {
			lock.lockInterruptibly();
			c1.signal();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	private static void signalC2() {
		try {
			lock.lockInterruptibly();
			c2.signal();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread(() -> awaitC1(), "t1");
		Thread t2 = new Thread(() -> awaitC2(), "t2");
		Thread t3 = new Thread(() -> signalC1(), "t3");
		Thread t4 = new Thread(() -> signalC2(), "t4");
		t1.start();
		t2.start();


		TimeUnit.SECONDS.sleep(2);
		System.out.println("同步队列：" + lock.sync.printSyncQueue());
		System.out.println("条件队列1：" + c1.printConditionQueue());
		System.out.println("条件队列2：" + c2.printConditionQueue());

		TimeUnit.SECONDS.sleep(2);
		t3.start();
//		t4.start();
		TimeUnit.SECONDS.sleep(2);
		System.out.println("同步队列：" + lock.sync.printSyncQueue());
		System.out.println("条件队列1：" + c1.printConditionQueue());
		System.out.println("条件队列2：" + c2.printConditionQueue());
	}
}

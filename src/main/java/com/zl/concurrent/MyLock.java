package com.zl.concurrent;

import com.zl.concurrent.aqs.AbstractQueuedSynchronizer;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @author zhanglan
 * @description
 * @date 2020-07-31
 */
public class MyLock implements Lock {
	public final Sync sync;

	public MyLock() {
		sync = new Sync();
	}



	@Override
	public void lock() {
		sync.lock();
	}

	@Override
	public void lockInterruptibly() throws InterruptedException {
		System.out.println(Thread.currentThread().getName() + "进行获取锁操作...");
		sync.acquireInterruptibly(1);
		System.out.println(Thread.currentThread().getName() + "获取了锁...");
	}

	@Override
	public boolean tryLock() {
		return sync.tryAcquire(1);
	}

	@Override
	public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
		return sync.tryAcquireNanos(1, unit.toNanos(time));
	}

	@Override
	public void unlock() {
		System.out.println(Thread.currentThread().getName() + "进行释放锁操作...");
		sync.release(1);
		System.out.println(Thread.currentThread().getName() + "释放了锁...");
	}

	@Override
	public Condition newCondition() {
		return sync.newCondition();
	}

	static final class Sync extends AbstractQueuedSynchronizer {
		protected final boolean tryAcquire(int acquires) {
			final Thread current = Thread.currentThread();
			int c = getState();
			if (c == 0) {
				if (compareAndSetState(0, acquires)) {
					setExclusiveOwnerThread(current);
					return true;
				}
			}
			else if (current == getExclusiveOwnerThread()) {
				int nextc = c + acquires;
				if (nextc < 0) // overflow
					throw new Error("Maximum lock count exceeded");
				setState(nextc);
				return true;
			}
			return false;
		}

		protected final boolean tryRelease(int releases) {
			int c = getState() - releases;
			if (Thread.currentThread() != getExclusiveOwnerThread())
				throw new IllegalMonitorStateException();
			boolean free = false;
			if (c == 0) {
				free = true;
				setExclusiveOwnerThread(null);
			}
			setState(c);
			return free;
		}

		final ConditionObject newCondition() {
			return new ConditionObject();
		}

		protected final boolean isHeldExclusively() {
			// While we must in general read state before owner,
			// we don't need to do so to check if current thread is owner
			return getExclusiveOwnerThread() == Thread.currentThread();
		}

		final void lock() {
			acquire(1);
		}

	}

}

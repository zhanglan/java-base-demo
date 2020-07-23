package com.zl.concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

/**
 * @author zhanglan
 * @description
 * @date 2020-07-23
 */
public class CyclicBarrierSample implements Runnable {

	private CyclicBarrier barrier;

	public CyclicBarrierSample(CyclicBarrier barrier) {
		this.barrier = barrier;
	}

	@Override
	public void run() {
		String name = Thread.currentThread().getName();
		try {
			TimeUnit.SECONDS.sleep(2);
			System.out.println(name + "到达第一个栅栏，开始等待队友集合...");
			barrier.await();
			System.out.println(name + "冲破第一个栅栏，向第二个栅栏触发...");
			TimeUnit.SECONDS.sleep(5);
			System.out.println(name + "到达第二个栅栏，开始等待队友集合...");
			barrier.await();
			System.out.println(name + "冲破第二个栅栏...");
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws BrokenBarrierException, InterruptedException {
		CyclicBarrier barrier = new CyclicBarrier(5, () -> {
			System.out.println(Thread.currentThread().getName() + "最后一个到达本栅栏并将之冲破...");
		});

		for (int i = 0; i < 5; i++) {
			new Thread(new CyclicBarrierSample(barrier), "线程" + i).start();
		}
	}

}

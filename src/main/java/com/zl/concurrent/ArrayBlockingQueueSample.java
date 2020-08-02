package com.zl.concurrent;

import lombok.Data;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.LockSupport;

/**
 * @author zhanglan
 * @description
 * @date 2020-07-28
 */
public class ArrayBlockingQueueSample {

	private ArrayBlockingQueue<Ball> queue = new ArrayBlockingQueue<Ball>(1);

	public int size() {
		return queue.size();
	}

	public void produce(Ball ball) throws InterruptedException {
		queue.put(ball);
	}

	public Ball consume() throws InterruptedException {
		return queue.take();
	}


	public static void main(String[] args) throws InterruptedException {
		ArrayBlockingQueueSample sample = new ArrayBlockingQueueSample();
		ExecutorService service = Executors.newCachedThreadPool();
		service.submit(() -> {
			int i = 0;
			while (i <= 100) {
				Ball ball = new Ball(i, "球" + i);
				System.out.println("准备放入球-->" + ball.getName() + ",此时共有球：" + sample.size() + "个...");
				try {
					sample.produce(ball);
					TimeUnit.MICROSECONDS.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				i++;
			}

		});

		service.submit(() -> {
			while (true) {
				System.out.println("准备拿出球,此时共有球：" + sample.size() + "个...");
				Ball ball = sample.consume();
			}
		});

	}
}

@Data
class Ball {
	private int id;
	private String name;

	Ball(int id, String name) {
		this.id = id;
		this.name = name;
	}
}



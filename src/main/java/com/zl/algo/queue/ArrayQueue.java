package com.zl.algo.queue;


import java.util.Arrays;

/**
 * @author zhang_lan@inspur.com
 * @description
 * @date 2020/6/22
 */
public class ArrayQueue<E> {

	private E[] array;

	private int head;

	private int tail;

	private int capacity;

	private int size;

	public ArrayQueue() {
		this(10);
	}

	public ArrayQueue(int capacity) {
		this.capacity = capacity;
		this.array = (E[]) new Object[this.capacity];
	}

	/**
	 * 队列入队
	 * @param e
	 */
	public void enqueue(E e) {
		checkCapacity();
		if (isEmpty()) {
			array[tail] = e;
		} else {
			array[++tail] = e;
		}
		size++;
	}

	public E dequeue() {
		if (isEmpty()) return null;
		E e = array[head];
		array[head] = null;
		head++;
		size--;
		return e;
	}

	private void checkCapacity() {
		if (tail == capacity-1 && head > 0) {
			E[] oldArray = array;
			array = (E[]) new Object[capacity];
			System.arraycopy(oldArray, head, array, 0, size);
			tail = size -1;
			head = 0;
		}
		if (size >= capacity) {
			capacity = capacity << 1;
			array = Arrays.copyOf(array, capacity);
		}
	}

	private boolean isEmpty() {
		return size == 0;
	}


	public static void main(String[] args) {
		ArrayQueue<String> queue = new ArrayQueue<>(5);
		queue.enqueue("a");
		queue.enqueue("b");
		queue.enqueue("c");
		queue.enqueue("d");
		queue.enqueue("e");
		queue.dequeue();
		queue.dequeue();
		queue.enqueue("f");
		queue.enqueue("g");
		queue.enqueue("h");
	}

}

package com.zl.algo.queue;

/**
 * @author zhang_lan@inspur.com
 * @description
 * @date 2020/6/22
 */
public class ArrayDeque<E> {
	private E[] array;

	private int head;

	private int tail;

	private int capacity;

	private int size;

	public ArrayDeque() {
		this(10);
	}

	public ArrayDeque(int capacity) {
		this.capacity = capacity;
		array = (E[]) new Object[capacity];
	}

	public void enqueueHead(E e) {
		checkCapacity();
		if (!isEmpty()){
			head = Math.floorMod(head - 1, capacity);
		}
		array[head] = e;
		size++;
	}

	public void enqueueTail(E e) {
		checkCapacity();
		if (!isEmpty()) {
			tail = Math.floorMod(tail + 1, capacity);
		}
		array[tail] = e;
		size++;
	}

	public E dequeueHead() {
		E e = array[head];
		array[head] = null;
		head = Math.floorMod(head + 1, capacity);
		size--;
		return e;
	}

	public E dequeueTail() {
		E e = array[tail];
		array[tail] = null;
		tail = Math.floorMod(tail - 1, capacity);
		size--;
		return e;
	}

	private void checkCapacity() {
		if (size == capacity) {
			capacity = capacity << 1;
			E[] oldArray = array;
			array = (E[]) new Object[capacity];
			System.arraycopy(oldArray, head, array, 0, size - head);
			if (tail < head) {
				System.arraycopy(oldArray, 0, array, size-head, tail + 1);
			}
			head = 0;
			tail = size - 1;
		}
	}

	private boolean isEmpty() {
		return size == 0;
	}

	public static void main(String[] args) {

		ArrayDeque<String> arrayDeque = new ArrayDeque<>(5);
		arrayDeque.enqueueHead("a");
		arrayDeque.enqueueHead("b");
		arrayDeque.enqueueTail("c");
		arrayDeque.enqueueTail("d");
		arrayDeque.enqueueTail("e");
		arrayDeque.dequeueHead();
		arrayDeque.dequeueTail();
		arrayDeque.enqueueTail("1");
		arrayDeque.enqueueHead("2");
		arrayDeque.enqueueTail("3");

	}
}

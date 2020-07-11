package com.zl.algo.queue;

/**
 * @author zhang_lan@inspur.com
 * @description
 * @date 2020/6/23
 */
public class LinkedDeque<E> {

	private Node<E> head;

	private Node<E> tail;

	private int size;

	public LinkedDeque() {
	}

	public void enqueueHead(E e) {
		if (isEmpty()) {
			Node<E> node = new Node<>(e, null, null);
			head = node;
			tail = node;
		} else {
			Node<E> node = new Node<>(e, null, head);
			head.pre = node;
			head = node;
		}
		size++;
	}

	public void enqueueTail(E e) {
		if (isEmpty()) {
			Node<E> node = new Node<>(e, null, null);
			head = node;
			tail = node;
		} else {
			Node<E> node = new Node<>(e, tail, null);
			tail.next = node;
			tail = node;
		}
		size++;
	}

	public E dequequeHead() {
		if (isEmpty()) return null;
		Node<E> node = head;
		head = node.next;
		if (head != null) {
			head.pre = null;
		}
		size--;
		return node.item;
	}

	public E dequeueTail() {
		if (isEmpty()) return null;
		Node<E> node = tail;
		tail = node.pre;
		if (tail != null) {
			tail.next = null;
		}
		size--;
		return node.item;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public void print() {
		if (!isEmpty()) {
			Node<E> e = head;
			while (e != null) {
				System.out.print(e.item.toString() + "");
				e = e.next;
			}
			System.out.println();
		}
	}

	private final static class Node<E> {
		private E item;

		private Node<E> pre;

		private Node<E> next;

		private Node(E item, Node<E> pre, Node<E> next) {
			this.item = item;
			this.pre = pre;
			this.next = next;
		}
	}


	public static void main(String[] args) {
		LinkedDeque<String> deque = new LinkedDeque<>();
		deque.enqueueHead("a");
		deque.enqueueHead("b");
		deque.enqueueTail("c");
		deque.enqueueTail("d");
		deque.print();
		deque.dequequeHead();
		deque.print();
		deque.dequeueTail();
		deque.print();
		deque.dequeueTail();
		deque.print();
		deque.dequeueTail();
		deque.print();
		deque.dequeueTail();
		deque.print();
		deque.dequeueTail();
		deque.print();
	}


}

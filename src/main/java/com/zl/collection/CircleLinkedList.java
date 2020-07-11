package com.zl.collection;

/**
 * @author zhang_lan@inspur.com
 * @description
 * @date 2020/6/19
 */
public class CircleLinkedList<E> {

	private Node<E> first;

	private Node<E> last;

	private int size;

	public E add(E e) {
		if (first == null) {
			Node<E> node = new Node<E>(e, null);
			first = node;
			last = node;
			last.next = first;
		} else {
			Node<E> node = new Node<E>(e, first);
			last.next = node;
			last = node;
		}
		size++;
		return e;
	}

	public E remove(int index) throws Exception {
		Node<E> node = getNode(index);

		if (node == null) return null;

		if (node == first && node == last) {
			first = null;
			last = null;
		} else if (node == first) {
			first = node.next;
			last.next = first;
		} else if (node == last) {
			last = getNode(index - 1);
			last.next = first;
		} else {
			Node<E> pre = getNode(index -1);
			pre.next = node.next;
		}
		if (size > 0) size--;

		return node.item;
	}

	public E removeAndSetNextFirst(int killIndex) throws Exception {
		int index;
		if (killIndex <= size-1) {
			index = killIndex;
		} else {
			index = killIndex % size;
		}
		Node<E> node = getNode(index);

		if (node == null) return null;

		if (node == first && node == last) {
			first = null;
			last = null;
		} else if (node == first) {
			first = node.next;
			last.next = first;
		} else if (node == last) {
			last = getNode(index - 1);
			last.next = first;
		} else {
			Node<E> pre = getNode(index -1);
			pre.next = node.next;
			first = node.next;
			last = pre;
		}
		if (size > 0) size--;

		return node.item;
	}

	public E get(int index) throws Exception {
		return getNode(index).item;
	}

	private Node<E> getNode(int index) throws Exception {
		if (index >= size || index < 0) {
			return null;
		}

		int count = 0;
		Node<E> node = first;
		while (count < index) {
			node = node.next;
			count++;
		}

		return node;
	}



	public void print() {
		int count = 0;
		Node<E> node = first;
		while (count < size) {
			System.out.print(node.item + ";");
			node = node.next;
			count++;
		}
		System.out.println();
	}

	private static final class Node<E> {
		E item;
		Node<E> next;

		private Node(E item, Node<E> next) {
			this.item = item;
			this.next = next;
		}
	}

	public static void resolveJosephusProblem(int total, int killIndex) throws Exception {
		CircleLinkedList<Integer> list = new CircleLinkedList<>();
		for (int i = 0; i < total; i++) {
			list.add(i + 1);
		}
		list.print();
		while (list.size > 0) {
			list.removeAndSetNextFirst(killIndex);
			list.print();
		}
	}

	public static void main(String[] args) throws Exception {
		resolveJosephusProblem(6, 4);

	}
}

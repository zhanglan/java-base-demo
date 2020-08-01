package com.zl.algo.queue;

/**
 * @author zhanglan
 * @description
 * @date 2020-07-28
 */
public class ConditionNodeSample {

	private Node firstWaiter;

	private Node lastWaiter;

	public void put(Node node) {
		if (firstWaiter == null) {
			firstWaiter = lastWaiter = node;
		} else {
			Node l = lastWaiter;
			l.next = node;
			lastWaiter = node;
		}
	}

	public void unlinkCancelledWaiters() {
		Node node = firstWaiter;
		Node preNode = null;
		while (node != null) {
			Node next = node.next;
			if (node.status == Node.CANCELLED) {
				node.next = null;
				if (preNode == null) {
					firstWaiter = next;
				} else {
					preNode.next = next;
				}
				if (next == null) {
					lastWaiter = preNode;
				}
			} else {
				preNode = node;
			}
			node = next;
		}
	}

	public String toString() {
		Node n = firstWaiter;
		StringBuilder sb = new StringBuilder();
		while (n != null) {
			sb.append(n.toString());
			if (n.next != null)
				sb.append("-->");
			n = n.next;
		}
		return sb.toString();
	}

	static class Node {
		private static final int CANCELLED = 0;

		private String index;

		private int status;

		private Node next;

		public Node(String index) {
			this.index = index;
		}

		public Node(String index, int status) {
			this.index = index;
			this.status = status;
		}

		public Node(String index, int status, Node next) {
			this.index = index;
			this.status = status;
			this.next = next;
		}

		public String toString() {
			return "{index: " + index + ", status: " + status + "}";
		}
	}

	public static void main(String[] args) {
		ConditionNodeSample sample = new ConditionNodeSample();
		for (int i = 0; i < 10; i++) {
			sample.put(new Node(i + "", i%2));
		}
		System.out.println(sample.toString());
		sample.unlinkCancelledWaiters();
		System.out.println(sample.toString());
	}
}

package com.zl.algo.stack;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author zhang_lan@inspur.com
 * @description
 * @date 2020/6/19
 */
public class BracketStack<E> implements Stack<E> {

	private E[] array;

	private int capacity = 10;

	private int size;

	public BracketStack() {
		array = (E[]) new Object[capacity];
	}

	private void checkCapacity(int index) {
		if (index >= capacity) {
			capacity = capacity << 1;
			resize();
		} else if (index < capacity >> 1 && capacity > 10) {
			capacity = capacity >> 1;
			resize();
		}
	}

	private void resize() {
		E[] oldArray = array;
		array = Arrays.copyOf(oldArray, capacity);
	}

	@Override
	public E push(E e) {
		size++;
		checkCapacity(size - 1);
		array[size-1] = e;
		return e;
	}

	@Override
	public E pop() {
		if (size <= 0) return null;
		E e = array[size-1];
		array[size - 1] = null;
		size--;
		checkCapacity(size - 1);
		return e;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	public static boolean checkChars(String str) {
		BracketStack<Character> stack = new BracketStack<>();
		char[] chars = str.toCharArray();
		Character popChar;
		for (char c : chars) {
			switch (c) {
				case '(':
				case '[':
				case '{':
					stack.push(c);
					break;
				case ')':
					popChar = stack.pop();
					if (popChar == null || popChar != '(') {
						return false;
					}
						break;
				case ']':
					popChar = stack.pop();
					if (popChar == null || popChar != '[') {
						return false;
					}
					break;
				case '}':
					popChar = stack.pop();
					if (popChar == null || popChar != '{') {
						return false;
					}
					break;
			}
		}
		if (stack.isEmpty()) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			String s = scanner.next();
			System.out.println("检查结果：" + checkChars(s));
		}

	}
}

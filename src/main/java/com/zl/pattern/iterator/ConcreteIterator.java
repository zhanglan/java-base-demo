package com.zl.pattern.iterator;

import java.util.List;

/**
 * @author zhang_lan@inspur.com
 * @description
 * @date 2020/4/23
 */
public class ConcreteIterator<T> implements Iterator<T> {

	private List<T> list;

	private int cursor;

	public ConcreteIterator(List<T> list) {
		this.list = list;
	}

	@Override
	public T first() {
		return list.get(0);
	}

	@Override
	public T next() {
		T obj = null;
		if (hasNext()) {
			obj = list.get(cursor++);
		}
		return obj;
	}

	@Override
	public boolean hasNext() {
		if (list != null && cursor < list.size()) {
			return true;
		}
		return false;
	}

	@Override
	public T currentItem() {
		return list.get(cursor);
	}

}

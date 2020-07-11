package com.zl.pattern.iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhang_lan@inspur.com
 * @description
 * @date 2020/4/23
 */
public class ConcreteAggregate<T> implements Aggregate<T> {

	private List<T> list = new ArrayList<>();


	@Override
	public void add(T t) {
		list.add(t);
	}

	@Override
	public void remove(T t) {
		list.remove(t);
	}

	@Override
	public Iterator<T> createIterator() {
		return new ConcreteIterator<>(list);
	}
}

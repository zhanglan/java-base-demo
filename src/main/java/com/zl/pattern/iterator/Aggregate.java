package com.zl.pattern.iterator;

/**
 * @author zhang_lan@inspur.com
 * @description
 * @date 2020/4/23
 */
public interface Aggregate<T> {

	void add(T t);

	void remove(T t);

	Iterator<T> createIterator();

}

package com.zl.pattern.iterator;

/**
 * @author zhang_lan@inspur.com
 * @description
 * @date 2020/4/23
 */
public interface Iterator<T> {

	T first();

	T next();

	boolean hasNext();

	T currentItem();

}

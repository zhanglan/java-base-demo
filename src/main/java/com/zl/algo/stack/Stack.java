package com.zl.algo.stack;

/**
 * @author zhang_lan@inspur.com
 * @description
 * @date 2020/6/19
 */
public interface Stack<E> {

	E push(E e);

	E pop();

	boolean isEmpty();

}

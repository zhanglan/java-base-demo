package com.zl.pattern.observer;

/**
 * @author zhang_lan@inspur.com
 * @description
 * @date 2020/3/20
 */
public interface ISubject {

	void registerObserver(String name, IObserver observer);

	void unregisterObserver(String name);

	void notify(String message);

}

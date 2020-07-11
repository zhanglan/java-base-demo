package com.zl.pattern.observer;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author zhang_lan@inspur.com
 * @description
 * @date 2020/3/20
 */
public class Subject implements ISubject {

	private ConcurrentHashMap<String, IObserver> observers = new ConcurrentHashMap<String, IObserver>();

	@Override
	public void registerObserver(String name, IObserver observer) {
		observers.put(name, observer);
	}

	@Override
	public void unregisterObserver(String name) {
		observers.keySet().removeIf(key -> name.equals(key));
	}

	@Override
	public void notify(String message) {
		System.out.println("Subject notify: " + message);
		for (String name: observers.keySet()) {
			observers.get(name).receive(message);
		}
	}

}

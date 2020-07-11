package com.zl.pattern.observer;

/**
 * @author zhang_lan@inspur.com
 * @description
 * @date 2020/3/20
 */
public class ObserverC implements IObserver {

	@Override
	public void receive(String message) {
		System.out.println("ObserverC receive: " + message);
	}

}

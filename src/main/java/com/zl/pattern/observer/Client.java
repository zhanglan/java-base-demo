package com.zl.pattern.observer;

/**
 * @author zhang_lan@inspur.com
 * @description
 * @date 2020/3/20
 */
public class Client {

	public static void main(String[] args) {
		ISubject subject = new Subject();
		subject.registerObserver("A", new ObserverA());
		subject.registerObserver("B", new ObserverB());
		subject.registerObserver("C", new ObserverC());
		subject.notify("subject 第一次发出通知...");

		subject.unregisterObserver("B");
		subject.notify("subject 第二次发出通知...");
	}

}

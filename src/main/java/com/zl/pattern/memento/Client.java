package com.zl.pattern.memento;

/**
 * @author zhang_lan@inspur.com
 * @description
 * @date 2020/4/22
 */
public class Client {

	public static void main(String[] args) {

		Originator originator = new Originator();
		originator.setState("0000");
		System.out.println(String.format("原发器的状态：%s", originator.getState()));

		Caretaker caretaker = new Caretaker();
		caretaker.setMemento(originator.createMemento());

		originator.setState("1111");
		System.out.println(String.format("原发器的状态：%s", originator.getState()));

		originator.recoverFromMemento(caretaker.getMemento());
		System.out.println(String.format("原发器的状态：%s", originator.getState()));

	}

}

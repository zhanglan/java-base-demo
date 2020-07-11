package com.zl.pattern.decorator;

/**
 * @author zhang_lan@inspur.com
 * @description
 * @date 2020/3/2
 */
public class Client {

	public static void main(String[] args) {
		Person person = new Person();
		ConcreteDecoratorA a = new ConcreteDecoratorA(person);
		ConcreteDecoratorB b = new ConcreteDecoratorB(a);
		b.show();
	}

}

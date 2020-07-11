package com.zl.pattern.bridge;

/**
 * @author zhang_lan@inspur.com
 * @description
 * @date 2020/7/10
 */
public class Client {

	public static void main(String[] args) {
		Abstraction ab = new RefinedAbstraction();

		ab.setImplementor(new ConcreteImplementorA());
		ab.operation();

		ab.setImplementor(new ConcreteImplementorB());
		ab.operation();
	}

}

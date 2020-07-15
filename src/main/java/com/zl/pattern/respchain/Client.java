package com.zl.pattern.respchain;

/**
 * @author zhanglan
 * @description
 * @date 2020-07-15
 */
public class Client {

	public static void main(String[] args) {
		System.out.println("=========");
		AbstractHandler handler1 = new HandlerA();
		AbstractHandler handler2 = new HandlerB();
		AbstractHandler handler3 = new HandlerC();
		handler1.setNextHandler(handler2);
		handler2.setNextHandler(handler3);
		handler1.handle(new Object());

		System.out.println("=========");
		handler1.setNextHandler(handler3);
		handler3.setNextHandler(handler2);
		handler2.setNextHandler(null);
		handler1.handle(new Object());

	}

}

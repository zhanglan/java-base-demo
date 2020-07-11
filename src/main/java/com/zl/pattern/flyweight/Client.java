package com.zl.pattern.flyweight;

/**
 * @author zhang_lan@inspur.com
 * @description
 * @date 2020/7/10
 */
public class Client {

	public static void main(String[] args) {
		ILoginer loginer1 = LoginerFactory.getLoginer("0001");
		ILoginer loginer2 = LoginerFactory.getLoginer("0002");
		ILoginer loginer3 = LoginerFactory.getLoginer("0002");

		loginer1.login(new User("张三", "123456"));
		loginer2.login(new User("李四", "123456"));
		loginer3.login(new User("王五", "123456"));

		System.out.println("享元池大小：" + LoginerFactory.getSize());
	}

}

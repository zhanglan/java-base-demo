package com.zl.pattern.facade;

/**
 * @author zhang_lan@inspur.com
 * @description
 * @date 2020/7/10
 */
public class Client {

	public static void main(String[] args) {
		Facade facade = new Facade();
		facade.methodOne();
		facade.methodTwo();
	}

}

package com.zl.pattern.proxy;

/**
 * @author zhang_lan@inspur.com
 * @description
 * @date 2020/3/3
 */
public class RealSubject implements Subject {

	@Override
	public void request() {
		System.out.println("RealSubject request...");
	}

}

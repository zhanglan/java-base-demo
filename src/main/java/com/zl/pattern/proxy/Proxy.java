package com.zl.pattern.proxy;

/**
 * @author zhang_lan@inspur.com
 * @description
 * @date 2020/3/3
 */
public class Proxy implements Subject {
	private Subject target;

	public Proxy(Subject target) {
		this.target = target;
	}

	@Override
	public void request() {
		before();
		target.request();
		after();
	}

	private void before() {
		System.out.println("before...");
	}

	private void after() {
		System.out.println("after...");
	}

}

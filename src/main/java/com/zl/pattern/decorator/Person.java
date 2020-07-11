package com.zl.pattern.decorator;

/**
 * @author zhang_lan@inspur.com
 * @description
 * @date 2020/3/2
 */
public class Person implements Component {
	@Override
	public void show() {
		System.out.println("A person...");
	}
}

package com.zl.pattern.factory.bean;

/**
 * @author zhang_lan@inspur.com
 * @description
 * @date 2020/2/25
 */
public class Teacher implements IPerson {
	@Override
	public void eat() {
		System.out.println("a teacher eat");
	}
}

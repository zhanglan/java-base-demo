package com.zl.pattern.bridge;

/**
 * @author zhang_lan@inspur.com
 * @description
 * @date 2020/7/10
 */
public class ConcreteImplementorB implements Implementor {

	@Override
	public void operation() {
		System.out.println("B实现进行操作...");
	}

}

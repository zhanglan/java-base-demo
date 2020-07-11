package com.zl.pattern.bridge;

/**
 * @author zhang_lan@inspur.com
 * @description
 * @date 2020/7/10
 */
public class ConcreteImplementorA implements Implementor {

	@Override
	public void operation() {
		System.out.println("A实现进行操作...");
	}

}

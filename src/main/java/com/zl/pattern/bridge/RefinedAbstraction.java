package com.zl.pattern.bridge;

/**
 * @author zhang_lan@inspur.com
 * @description
 * @date 2020/7/10
 */
public class RefinedAbstraction extends Abstraction {

	@Override
	public void operation() {
		this.implementor.operation();
	}

}

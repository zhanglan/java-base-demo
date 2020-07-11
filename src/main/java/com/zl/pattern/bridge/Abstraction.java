package com.zl.pattern.bridge;

/**
 * @author zhang_lan@inspur.com
 * @description
 * @date 2020/7/10
 */
public abstract class Abstraction {

	protected Implementor implementor;

	public void setImplementor(Implementor implementor) {
		this.implementor = implementor;
	}

	public abstract void operation();

}

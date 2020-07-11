package com.zl.pattern.decorator;

/**
 * @author zhang_lan@inspur.com
 * @description
 * @date 2020/3/2
 */
public abstract class Decorator implements Component {
	protected Component component;

	public Decorator(Component component) {
		this.component = component;
	}

}

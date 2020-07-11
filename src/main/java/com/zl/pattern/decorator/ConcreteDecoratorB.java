package com.zl.pattern.decorator;

/**
 * @author zhang_lan@inspur.com
 * @description
 * @date 2020/3/2
 */
public class ConcreteDecoratorB extends Decorator {
	public ConcreteDecoratorB(Component component) {
		super(component);
	}

	@Override
	public void show() {
		this.component.show();
		System.out.println("with B...");
	}

}

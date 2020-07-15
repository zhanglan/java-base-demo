package com.zl.pattern.visitor;

/**
 * @author zhanglan
 * @description
 * @date 2020-07-15
 */
public class ElementB implements IElement {
	@Override
	public void accept(IVisitor visitor) {
		visitor.visit(this);
	}

	public void optionB() {
		System.out.println("执行操作B...");
	}

}

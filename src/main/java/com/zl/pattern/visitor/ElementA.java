package com.zl.pattern.visitor;

/**
 * @author zhanglan
 * @description
 * @date 2020-07-15
 */
public class ElementA implements IElement {

	@Override
	public void accept(IVisitor visitor) {
		visitor.visit(this);
	}

	public void optionA() {
		System.out.println("执行操作A...");
	}

}

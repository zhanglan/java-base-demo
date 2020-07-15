package com.zl.pattern.visitor;

/**
 * @author zhanglan
 * @description
 * @date 2020-07-15
 */
public class VisitorTwo implements IVisitor {
	@Override
	public void visit(ElementA element) {
		System.out.print("VisitorTwo");
		element.optionA();
	}

	@Override
	public void visit(ElementB element) {
		System.out.print("VisitorTwo");
		element.optionB();
	}

}

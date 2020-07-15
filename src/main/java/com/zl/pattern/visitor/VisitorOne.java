package com.zl.pattern.visitor;

/**
 * @author zhanglan
 * @description
 * @date 2020-07-15
 */
public class VisitorOne implements IVisitor {

	@Override
	public void visit(ElementA element) {
		System.out.print("VisitorOne");
		element.optionA();
	}

	@Override
	public void visit(ElementB element) {
		System.out.print("VisitorOne");
		element.optionB();
	}

}

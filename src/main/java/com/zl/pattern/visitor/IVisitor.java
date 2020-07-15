package com.zl.pattern.visitor;

/**
 * @author zhanglan
 * @description
 * @date 2020-07-15
 */
public interface IVisitor {

	void visit(ElementA element);

	void visit(ElementB element);

}

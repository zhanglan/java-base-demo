package com.zl.pattern.visitor;

/**
 * @author zhanglan
 * @description
 * @date 2020-07-15
 */
public interface IElement {

	void accept(IVisitor visitor);

}

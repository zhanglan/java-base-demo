package com.zl.pattern.visitor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhanglan
 * @description
 * @date 2020-07-15
 */
public class ObjectStructure {

	private List<IElement> elements = new ArrayList<IElement>();

	public void action(IVisitor visitor) {
		elements.forEach(element -> {
			element.accept(visitor);
		});
	}

	public void addElement(IElement element) {
		elements.add(element);
	}

}

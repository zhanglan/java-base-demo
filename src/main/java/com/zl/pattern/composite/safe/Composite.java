package com.zl.pattern.composite.safe;


import java.util.ArrayList;
import java.util.List;

/**
 * @author zhang_lan@inspur.com
 * @description
 * @date 2020/4/22
 */
public class Composite implements Component {

	private List<Component> childComponents = new ArrayList<Component>();

	private String name;

	public Composite(String name) {
		this.name = name;
	}

	public void addChild(Component child) {
		childComponents.add(child);
	}

	public void removeChild(int id) {
		childComponents.remove(id);
	}

	public List<Component> listChild() {
		return childComponents;
	}

	@Override
	public void printStruct() {
		System.out.println("树枝节点====>" + this.name);
		for (Component component: childComponents) {
			component.printStruct();
		}
	}

}

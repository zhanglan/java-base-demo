package com.zl.pattern.composite.transparent;

/**
 * @author zhang_lan@inspur.com
 * @description
 * @date 2020/4/22
 */
public class Leaf extends Component {

	private String name;

	public Leaf(String name) {
		this.name = name;
	}

	@Override
	public void printStruct() {
		System.out.println("叶子节点====>" + name);
	}

}

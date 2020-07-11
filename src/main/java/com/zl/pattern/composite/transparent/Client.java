package com.zl.pattern.composite.transparent;

/**
 * @author zhang_lan@inspur.com
 * @description
 * @date 2020/4/22
 */
public class Client {

	public static void main(String[] args) {
		Component root = new Composite("服装");
		Component c1 = new Composite("男装");
		Component c2 = new Composite("女装");

		Component leaf1 = new Leaf("男士T恤");
		Component leaf2 = new Leaf("男士夹克");
		Component leaf3 = new Leaf("长裙");
		Component leaf4 = new Leaf("短裙");

		root.addChild(c1);
		root.addChild(c2);
		c1.addChild(leaf1);
		c1.addChild(leaf2);
		c2.addChild(leaf3);
		c2.addChild(leaf4);

		root.printStruct();
	}

}

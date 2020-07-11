package com.zl.pattern.composite.safe;



/**
 * @author zhang_lan@inspur.com
 * @description
 * @date 2020/4/22
 */
public class Client {

	public static void main(String[] args) {
		Composite root = new Composite("服装");
		Composite c1 = new Composite("男装");
		Composite c2 = new Composite("女装");

		Leaf leaf1 = new Leaf("男士T恤");
		Leaf leaf2 = new Leaf("男士夹克");
		Leaf leaf3 = new Leaf("长裙");
		Leaf leaf4 = new Leaf("短裙");

		root.addChild(c1);
		root.addChild(c2);
		c1.addChild(leaf1);
		c1.addChild(leaf2);
		c2.addChild(leaf3);
		c2.addChild(leaf4);

		root.printStruct();
	}

}

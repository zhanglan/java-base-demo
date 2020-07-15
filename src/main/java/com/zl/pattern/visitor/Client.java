package com.zl.pattern.visitor;

/**
 * @author zhanglan
 * @description
 * @date 2020-07-15
 */
public class Client {

	public static void main(String[] args) {
		IElement elementA = new ElementA();
		IElement elementB = new ElementB();
		ObjectStructure os = new ObjectStructure();
		os.addElement(elementA);
		os.addElement(elementB);

		os.action(new VisitorOne());
		os.action(new VisitorTwo());
	}

}

package com.zl.pattern.prototype;

/**
 * @author zhang_lan@inspur.com
 * @description
 * @date 2020/3/3
 */
public class Client {
	public static void main(String[] args) {
		ShapeFactory factory = new ShapeFactory();
		Shape shape1 = factory.getShape("1");
		shape1.draw();
		Shape shape2 = factory.getShape("2");
		shape2.draw();
		Shape shape3 = factory.getShape("3");
		shape3.draw();
	}
}

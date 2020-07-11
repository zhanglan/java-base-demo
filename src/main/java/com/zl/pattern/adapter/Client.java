package com.zl.pattern.adapter;

/**
 * @author zhang_lan@inspur.com
 * @description
 * @date 2020/4/20
 */
public class Client {

	public static void main(String[] args) {
		Target target1 = new ObjectAdapter(new Adaptee());
		target1.output5v();
		Target target2 = new ClassAdapter();
		target2.output5v();
	}

}

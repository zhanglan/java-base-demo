package com.zl.pattern.adapter;

/**
 * @author zhang_lan@inspur.com
 * @description
 * @date 2020/4/20
 */
public class ObjectAdapter implements Target {

	private Adaptee adaptee;

	public ObjectAdapter(Adaptee adaptee) {
		this.adaptee = adaptee;
	}

	@Override
	public int output5v() {
		int i = adaptee.output220v();
		System.out.println(String.format("输入电压：%dv ====> 输出电压：%dv", i, 5));
		return 5;
	}

}

package com.zl.pattern.composite.transparent;

import java.util.List;

/**
 * @author zhang_lan@inspur.com
 * @description
 * @date 2020/4/22
 */
public abstract class Component {

	public abstract void printStruct();

	public void addChild(Component child) {
		throw new UnsupportedOperationException("不支持该方法");
	}

	public void removeChild(int id) {
		throw new UnsupportedOperationException("不支持该方法");
	}

	public List<Component> listChild() {
		throw new UnsupportedOperationException("不支持该方法");
	}

}

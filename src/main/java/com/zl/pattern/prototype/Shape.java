package com.zl.pattern.prototype;

import lombok.Data;

/**
 * @author zhang_lan@inspur.com
 * @description
 * @date 2020/3/3
 */

public abstract class Shape implements Cloneable {

	abstract void draw();

	@Override
	public Shape clone() {
		try {
			return (Shape) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return null;
	}
}

package com.zl.pattern.prototype;

import lombok.Data;

/**
 * @author zhang_lan@inspur.com
 * @description
 * @date 2020/3/3
 */
@Data
public class ConcretePrototype implements Cloneable {

	private String value;

	@Override
	public ConcretePrototype clone() {
		try {
			return (ConcretePrototype) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return null;
	}

}

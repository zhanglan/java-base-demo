package com.zl.bean;

import lombok.Data;

/**
 * @author zhang_lan@inspur.com
 * @description
 * @date 2020/2/22
 */
@Data
public class Person {
	private String name;

	private String sex;

	public Person() {
	}

	public Person(String name, String sex) {
		setName(name);
		setSex(sex);
	}
}

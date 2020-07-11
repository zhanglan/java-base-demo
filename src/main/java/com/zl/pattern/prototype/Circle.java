package com.zl.pattern.prototype;

import lombok.Data;

/**
 * @author zhang_lan@inspur.com
 * @description
 * @date 2020/3/3
 */
public class Circle extends Shape {
	@Override
	void draw() {
		System.out.println("画个圆...");
	}
}

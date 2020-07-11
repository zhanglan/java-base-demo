package com.zl.pattern.build;

import lombok.Data;

/**
 * @author zhang_lan@inspur.com
 * @description
 * @date 2020/3/13
 */
@Data
public class Product {
	private String productName;

	private String part1;

	private String part2;

	private String part3;

	private String part4;

	Product(String productName, String part1, String part2, String part3, String part4) {
		this.productName = productName;
		this.part1 = part1;
		this.part2 = part2;
		this.part3 = part3;
		this.part4 = part4;
	}

	public String toString() {
		return "{productName = " + productName +
				", part1 = " + part1 +
				", part2 = " + part2 +
				", part3 = " + part3 +
				", part4 = " + part4 + "}";
	}
}

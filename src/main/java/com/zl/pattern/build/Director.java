package com.zl.pattern.build;

/**
 * @author zhang_lan@inspur.com
 * @description
 * @date 2020/3/13
 */
public class Director {
	private ProductBuilder builder;

	public Director(ProductBuilder builder) {
		this.builder = builder;
	}

	public Product createProduct(String productName, String part1, String part2, String part3, String part4) {
		return builder.buildProductName(productName)
				.buildPart1(part1)
				.buildPart2(part2)
				.buildPart3(part3)
				.buildPart4(part4)
				.build();
	}

}

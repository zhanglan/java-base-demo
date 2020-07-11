package com.zl.pattern.build;

/**
 * @author zhang_lan@inspur.com
 * @description
 * @date 2020/3/13
 */
public class DefaultProductBuilder implements ProductBuilder {

	private String productName;

	private String part1;

	private String part2;

	private String part3;

	private String part4;

	@Override
	public ProductBuilder buildProductName(String productName) {
		this.productName = productName;
		return this;
	}

	@Override
	public ProductBuilder buildPart1(String part1) {
		this.part1 = part1;
		return this;
	}

	@Override
	public ProductBuilder buildPart2(String part2) {
		this.part2 = part2;
		return this;
	}

	@Override
	public ProductBuilder buildPart3(String part3) {
		this.part3 = part3;
		return this;
	}

	@Override
	public ProductBuilder buildPart4(String part4) {
		this.part4 = part4;
		return this;
	}

	@Override
	public Product build() {
		return new Product(productName, part1, part2, part3, part4);
	}
}

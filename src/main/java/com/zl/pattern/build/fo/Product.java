package com.zl.pattern.build.fo;

/**
 * @author zhang_lan@inspur.com
 * @description
 * @date 2020/3/13
 */
public class Product {
	private final String productName;

	private final String part1;

	private final String part2;

	private final String part3;

	private final String part4;

	private Product(String productName, String part1, String part2, String part3, String part4) {
		this.productName = productName;
		this.part1 = part1;
		this.part2 = part2;
		this.part3 = part3;
		this.part4 = part4;
	}

	static class Builder {
		private String productName;

		private String part1;

		private String part2;

		private String part3;

		private String part4;

		public Builder buildProductName(String productName) {
			this.productName = productName;
			return this;
		}

		public Builder buildPart1(String part1) {
			this.part1 = part1;
			return this;
		}

		public Builder buildPart2(String part2) {
			this.part2 = part2;
			return this;
		}

		public Builder buildPart3(String part3) {
			this.part3 = part3;
			return this;
		}

		public Builder buildPart4(String part4) {
			this.part4 = part4;
			return this;
		}

		public Product build() {
			return new Product(productName, part1, part2, part3, part4);
		}
	}

	public String toString() {
		return "{productName = " + productName +
				", part1 = " + part1 +
				", part2 = " + part2 +
				", part3 = " + part3 +
				", part4 = " + part4 + "}";
	}
}

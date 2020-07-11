package com.zl.pattern.build.fo;

/**
 * @author zhang_lan@inspur.com
 * @description
 * @date 2020/3/13
 */
public class Client {
	public static void main(String[] args) {
		Product.Builder builder = new Product.Builder();
		Product product = builder.buildProductName("productB")
				.buildPart1("B-part1")
				.buildPart2("B-part2")
				.buildPart3("B-part3")
				.buildPart4("B-part4")
				.build();
		System.out.println(product);
	}
}

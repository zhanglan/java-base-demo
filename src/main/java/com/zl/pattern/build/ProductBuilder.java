package com.zl.pattern.build;

/**
 * @author zhang_lan@inspur.com
 * @description
 * @date 2020/3/13
 */
public interface ProductBuilder {

	ProductBuilder buildProductName(String productName);

	ProductBuilder buildPart1(String part1);

	ProductBuilder buildPart2(String part2);

	ProductBuilder buildPart3(String part3);

	ProductBuilder buildPart4(String part4);

	Product build();

}

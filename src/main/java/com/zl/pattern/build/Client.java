package com.zl.pattern.build;

/**
 * @author zhang_lan@inspur.com
 * @description
 * @date 2020/3/13
 */
public class Client {
	public static void main(String[] args) {
		Director director = new Director(new DefaultProductBuilder());
		Product product = director.createProduct("productA", "A-part1", "A-part2", "A-part3" ,"A-part4");
		System.out.println(product);
	}
}

package com.zl.pattern.template;

/**
 * @author zhang_lan@inspur.com
 * @description
 * @date 2020/3/6
 */
public class Client {
	public static void main(String[] args) {
		AbstractTemplateClass a = new SubClassA();
		a.operation();
		AbstractTemplateClass b = new SubClassB();
		b.operation();
	}
}

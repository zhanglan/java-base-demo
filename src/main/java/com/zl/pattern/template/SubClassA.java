package com.zl.pattern.template;

/**
 * @author zhang_lan@inspur.com
 * @description
 * @date 2020/3/6
 */
public class SubClassA extends AbstractTemplateClass {
	@Override
	protected void invokeThirdStep() {
		System.out.println("SubClassA invoke third step...");
	}
}

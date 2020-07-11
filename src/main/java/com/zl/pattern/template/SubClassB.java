package com.zl.pattern.template;

/**
 * @author zhang_lan@inspur.com
 * @description
 * @date 2020/3/6
 */
public class SubClassB extends AbstractTemplateClass {
	@Override
	protected void invokeThirdStep() {
		System.out.println("SubClassB invoke third step...");
	}
}

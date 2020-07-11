package com.zl.pattern.template;

/**
 * @author zhang_lan@inspur.com
 * @description
 * @date 2020/3/6
 */
public abstract class AbstractTemplateClass {

	public void operation() {
		System.out.println("first step...");
		System.out.println("second step...");
		invokeThirdStep();
		System.out.println("fouth step...");
	}

	protected abstract void invokeThirdStep();

}

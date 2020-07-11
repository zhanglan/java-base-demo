package com.zl.pattern.strategy;

/**
 * @author zhang_lan@inspur.com
 * @description
 * @date 2020/2/27
 */
public class StepByStepMove implements Moveable {
	@Override
	public void move() {
		System.out.println("一步一步地移动...");
	}
}

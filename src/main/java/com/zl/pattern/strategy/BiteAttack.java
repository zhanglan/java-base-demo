package com.zl.pattern.strategy;

/**
 * @author zhang_lan@inspur.com
 * @description
 * @date 2020/2/27
 */
public class BiteAttack implements Attackable {
	@Override
	public void attack() {
		System.out.println("咬...");
	}
}

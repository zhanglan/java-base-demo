package com.zl.pattern.strategy;

/**
 * @author zhang_lan@inspur.com
 * @description
 * @date 2020/2/27
 */
public class KickAttack implements Attackable {
	@Override
	public void attack() {
		System.out.println("踢...");
	}
}

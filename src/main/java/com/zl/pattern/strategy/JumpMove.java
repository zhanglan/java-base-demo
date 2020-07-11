package com.zl.pattern.strategy;

/**
 * @author zhang_lan@inspur.com
 * @description
 * @date 2020/2/27
 */
public class JumpMove implements Moveable {
	@Override
	public void move() {
		System.out.println("跳着移动...");
	}
}

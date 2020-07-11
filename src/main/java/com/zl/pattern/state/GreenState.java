package com.zl.pattern.state;

/**
 * @author zhang_lan@inspur.com
 * @description
 * @date 2020/4/17
 */
public class GreenState implements State {
	@Override
	public void handle() {
		System.out.println("绿灯状态，可以通行！");
	}
}

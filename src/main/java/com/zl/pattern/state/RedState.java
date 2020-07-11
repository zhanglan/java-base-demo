package com.zl.pattern.state;

/**
 * @author zhang_lan@inspur.com
 * @description
 * @date 2020/4/17
 */
public class RedState implements State {

	@Override
	public void handle() {
		System.out.println("红灯状态，请勿通行！");
	}

}

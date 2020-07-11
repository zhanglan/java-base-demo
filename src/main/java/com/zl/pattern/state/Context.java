package com.zl.pattern.state;

/**
 * @author zhang_lan@inspur.com
 * @description
 * @date 2020/4/17
 */
public class Context {

	private State state;

	public void setState(State state) {
		System.out.println("状态改变");
		this.state = state;
		this.state.handle();
	}

}

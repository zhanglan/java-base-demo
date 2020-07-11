package com.zl.pattern.state;

/**
 * @author zhang_lan@inspur.com
 * @description
 * @date 2020/4/17
 */
public class YellowState implements State {

	@Override
	public void handle() {
		System.out.println("黄灯状态，请等待！");
	}

}

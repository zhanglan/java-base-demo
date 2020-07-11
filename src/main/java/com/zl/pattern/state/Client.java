package com.zl.pattern.state;

/**
 * @author zhang_lan@inspur.com
 * @description
 * @date 2020/4/17
 */
public class Client {

	public static void main(String[] args) {
		Context context = new Context();
		context.setState(new GreenState());
		context.setState(new YellowState());
		context.setState(new RedState());
	}

}

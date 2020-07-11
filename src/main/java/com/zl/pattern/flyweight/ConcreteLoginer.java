package com.zl.pattern.flyweight;

/**
 * @author zhang_lan@inspur.com
 * @description
 * @date 2020/7/10
 */
public class ConcreteLoginer implements ILoginer {

	private String token = "";

	public ConcreteLoginer(String token) {
		this.token = token;
	}

	@Override
	public void login(User user) {
		System.out.println("登录令牌：" + token + "，用户名：" + user.getUserName() + "，用户密码：" + user.getPassword());
	}
}

package com.zl.pattern.flyweight;

import lombok.Data;

/**
 * @author zhang_lan@inspur.com
 * @description
 * @date 2020/7/10
 */
@Data
public class User {
	private String userName;

	private String password;

	public User(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}

}

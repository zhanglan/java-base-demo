package com.zl.pattern.singleton;

/**
 * @author zhang_lan@inspur.com
 * @description
 * @date 2020/2/24
 */
public class HungrySingleton {
	/**
	 * instance作为静态变量只会在类初始化时被赋值一次
	 * 类初始化只有在真正使用该类时才会被触发
	 */
	private static HungrySingleton instance = new HungrySingleton();

	private HungrySingleton(){

	}

	public static HungrySingleton getInstance() {
		return instance;
	}

}

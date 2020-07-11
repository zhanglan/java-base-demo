package com.zl.pattern.singleton;

/**
 * @author zhang_lan@inspur.com
 * @description
 * @date 2020/2/24
 */
public class LazySingleton {
	// 使用volatile关键字进制指令重排，优化了双重检查锁
	private static volatile LazySingleton instance;

	/**
	 * 使用private防止单例被外部通过new创建
	 */
	private LazySingleton() {

	}

	public static LazySingleton getInstance() {
		// 使用双重检查锁解决了线程安全问题
		if (instance == null) {
			synchronized (LazySingleton.class) {
				if (instance == null) {
					instance = new LazySingleton();
				}
			}
		}
		return instance;
	}
}

package com.zl.pattern.singleton;

import java.io.ObjectStreamException;
import java.io.Serializable;

/**
 * @author zhang_lan@inspur.com
 * @description
 * @date 2020/2/24
 */
public class InnerClassSingleton implements Serializable {

	private static final long serialVersionUID = 1l;

	private InnerClassSingleton() {
		// 增加这个判断可以防止通过反射来创建多个单例实例
		if (InnerClassHolder.instance != null) {
			throw new RuntimeException("单例不允许多个实例");
		}
	}

	/**
	 * 只有第一次调用该方法时，才会触发InnerClassHolder类的初始化，继而静态变量instance被赋值
	 * @return
	 */
	public static InnerClassSingleton getInstance() {
		return InnerClassHolder.instance;
	}

	private static class InnerClassHolder {
		private static InnerClassSingleton instance = new InnerClassSingleton();
	}

	// 添加该方法，防止通过反序列化来创建多个单例实例
	Object readResolve() throws ObjectStreamException {
		return InnerClassHolder.instance;
	}

}

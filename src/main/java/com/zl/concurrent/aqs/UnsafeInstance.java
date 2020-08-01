package com.zl.concurrent.aqs;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @author zhanglan
 * @description
 * @date 2020-07-31
 */
public class UnsafeInstance {
	private static volatile Unsafe instance;

	public static Unsafe getInstance() {
		if (instance == null) {
			synchronized (UnsafeInstance.class) {
				if (instance == null) {
					try {
						Field field = Unsafe.class.getDeclaredField("theUnsafe");
						field.setAccessible(true);
						instance = (Unsafe) field.get(null);
					} catch (NoSuchFieldException e) {
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					}
				}
			}
		}
		return instance;
	}
}

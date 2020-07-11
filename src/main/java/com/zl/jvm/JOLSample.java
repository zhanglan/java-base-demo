package com.zl.jvm;

import org.openjdk.jol.info.ClassLayout;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author zhang_lan@inspur.com
 * @description
 * @date 2020/7/2
 */
public class JOLSample {

	public static void main(String[] args) {
		ClassLayout objectLayout = ClassLayout.parseInstance(new Object());
		System.out.println(objectLayout.toPrintable());

		ClassLayout arrayLayout = ClassLayout.parseInstance(new int[]{});
		System.out.println(arrayLayout.toPrintable());

		ClassLayout aLayout = ClassLayout.parseInstance(new A());
		System.out.println(aLayout.toPrintable());
	}

	private static class A {
		private byte id;
		private short a;
		private int b;
		private long c;
		private String name;
		ThreadPoolExecutor t;
//		private String properties;
	}

}



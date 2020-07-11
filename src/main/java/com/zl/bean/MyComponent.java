package com.zl.bean;

import org.springframework.stereotype.Component;

/**
 * @author zhang_lan@inspur.com
 * @description
 * @date 2020/2/22
 */
@Component
public class MyComponent {

	public void myMethod() {
		System.out.println("这是自定组件MyComponent的myMethod方法");
	}

}

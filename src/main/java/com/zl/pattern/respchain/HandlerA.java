package com.zl.pattern.respchain;

/**
 * @author zhanglan
 * @description
 * @date 2020-07-15
 */
public class HandlerA extends AbstractHandler {

	@Override
	public boolean doHandle(Object request) {
		System.out.println("HandlerA对请求进行了处理，后续处理者将继续处理");
		return false;
	}

}

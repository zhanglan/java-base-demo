package com.zl.pattern.respchain;

/**
 * @author zhanglan
 * @description
 * @date 2020-07-15
 */
public class HandlerC extends AbstractHandler {

	@Override
	public boolean doHandle(Object request) {
		System.out.println("HandlerC对请求进行了处理，后续处理者将不再继续处理");
		return true;
	}

}

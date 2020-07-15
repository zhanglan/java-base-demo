package com.zl.pattern.respchain;

/**
 * @author zhanglan
 * @description
 * @date 2020-7-15
 */
public abstract class AbstractHandler {

	private AbstractHandler nextHandler;

	public void setNextHandler(AbstractHandler nextHandler) {
		this.nextHandler = nextHandler;
	}

	public void handle(Object request) {
		if (!doHandle(request)) {
			fireNextHandler(request);
		}
	}

	public abstract boolean doHandle(Object request);

	private void fireNextHandler(Object request) {
		if (nextHandler != null) {
			nextHandler.handle(request);
		}
	}

}

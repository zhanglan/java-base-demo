package com.zl.pattern.mediator;

/**
 * @author zhanglan
 * @description
 * @date 2020-07-15
 */
public abstract class AbstractColleague {

	protected IMediator mediator;

	public AbstractColleague(IMediator mediator) {
		this.mediator = mediator;
		mediator.join(this);
	}

	public abstract void send(String message);

	public abstract void notifyMsg(String message);

}

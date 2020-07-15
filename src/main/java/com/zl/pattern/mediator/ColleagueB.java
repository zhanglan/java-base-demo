package com.zl.pattern.mediator;

/**
 * @author zhanglan
 * @description
 * @date 2020-07-15
 */
public class ColleagueB extends AbstractColleague {

	public ColleagueB(IMediator mediator) {
		super(mediator);
	}

	@Override
	public void send(String message) {
		mediator.send(message, this);
	}

	@Override
	public void notifyMsg(String message) {
		System.out.println("ColleagueB收到了信息：" + message);
	}

}

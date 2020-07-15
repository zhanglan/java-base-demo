package com.zl.pattern.mediator;

/**
 * @author zhanglan
 * @description
 * @date 2020-07-15
 */
public class ColleagueA extends AbstractColleague {

	public ColleagueA(IMediator mediator) {
		super(mediator);
	}

	@Override
	public void send(String message) {
		mediator.send(message, this);
	}

	@Override
	public void notifyMsg(String message) {
		System.out.println("ColleagueA收到了信息：" + message);
	}

}

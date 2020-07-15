package com.zl.pattern.mediator;

/**
 * @author zhanglan
 * @description
 * @date 2020-07-15
 */
public class ColleagueC extends AbstractColleague {

	public ColleagueC(IMediator mediator) {
		super(mediator);
	}

	@Override
	public void send(String message) {
		mediator.send(message, this);
	}

	@Override
	public void notifyMsg(String message) {
		System.out.println("ColleagueC收到了信息：" + message);
	}

}

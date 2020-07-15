package com.zl.pattern.mediator;

/**
 * @author zhanglan
 * @description
 * @date 2020-07-15
 */
public class Client {

	public static void main(String[] args) {
		IMediator mediator = new Mediator();
		AbstractColleague colleagueA = new ColleagueA(mediator);
		AbstractColleague colleagueB = new ColleagueB(mediator);
		AbstractColleague colleagueC = new ColleagueC(mediator);

		colleagueA.send("A说：您好");
		colleagueB.send("B说：您好");
		colleagueC.send("C说：您好");
	}

}

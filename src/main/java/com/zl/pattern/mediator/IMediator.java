package com.zl.pattern.mediator;

/**
 * @author zhanglan
 * @description
 * @date 2020-07-15
 */
public interface IMediator {

	void join(AbstractColleague colleague);

	void send(String message, AbstractColleague colleague);

}

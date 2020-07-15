package com.zl.pattern.mediator;

import java.util.*;

/**
 * @author zhanglan
 * @description
 * @date 2020-07-15
 */
public class Mediator implements IMediator {

	private Set<AbstractColleague> colleagues = new HashSet<AbstractColleague>();

	@Override
	public void join(AbstractColleague colleague) {
		if (! colleagues.contains(colleague)) {
			colleagues.add(colleague);
		}
	}

	@Override
	public void send(String message, AbstractColleague colleague) {
		Iterator<AbstractColleague> it = colleagues.iterator();
		while (it.hasNext()) {
			AbstractColleague ac = it.next();
			if (ac != colleague) {
				ac.notifyMsg(message);
			}
		}
	}

}

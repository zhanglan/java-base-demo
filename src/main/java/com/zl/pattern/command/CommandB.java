package com.zl.pattern.command;

/**
 * @author zhanglan
 * @description
 * @date 2020-07-15
 */
public class CommandB implements ICommand {

	Receiver receiver = new Receiver();

	@Override
	public void execute() {
		receiver.actionB();
	}

}

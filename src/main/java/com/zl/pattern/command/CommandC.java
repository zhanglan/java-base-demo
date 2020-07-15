package com.zl.pattern.command;

/**
 * @author zhanglan
 * @description
 * @date 2020-07-15
 */
public class CommandC implements ICommand {

	Receiver receiver = new Receiver();

	@Override
	public void execute() {
		receiver.actionC();
	}

}

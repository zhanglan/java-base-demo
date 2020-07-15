package com.zl.pattern.command;

/**
 * @author zhanglan
 * @description
 * @date 2020-07-15
 */
public class Client {

	public static void main(String[] args) {
		Invoker invoker = new Invoker();
		ICommand commandA = new CommandA();
		ICommand commandB = new CommandB();
		ICommand commandC = new CommandC();

		System.out.println("=========");
		invoker.addCommand(commandA);
		invoker.addCommand(commandB);
		invoker.addCommand(commandC);
		invoker.notifyCommands();

		System.out.println("=========");
		invoker.removeCommand(commandB);
		invoker.notifyCommands();
	}

}

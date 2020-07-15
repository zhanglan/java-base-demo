package com.zl.pattern.command;

import java.util.LinkedList;
import java.util.List;

/**
 * @author zhanglan
 * @description
 * @date 2020-07-15
 */
public class Invoker {

	private List<ICommand> commands = new LinkedList<ICommand>();

	public void addCommand(ICommand command) {
		commands.add(command);
	}

	public void removeCommand(ICommand command) {
		commands.remove(command);
	}

	public void notifyCommands() {
		commands.forEach(command -> {
			command.execute();
		});
	}

}

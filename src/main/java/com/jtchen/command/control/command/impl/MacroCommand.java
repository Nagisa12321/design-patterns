package com.jtchen.command.control.command.impl;

import com.jtchen.command.control.command.AbstractCommand;
import com.jtchen.command.control.command.Command;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/3/18 10:36
 */
public class MacroCommand extends AbstractCommand {
	// 宏命令: 用命令数组存储一大堆命令
	// 若调用execute() 方法, 全部执行
	// 若调用undo() 方法, 全部撤销

	private final Command[] commands;

	public MacroCommand(Command[] commands) {
		this.commands = commands;
	}

	@Override
	public void execute() {
		for (Command command : commands)
			command.execute();
	}

	@Override
	public void undo() {
		for (Command command : commands)
			command.undo();
	}
}

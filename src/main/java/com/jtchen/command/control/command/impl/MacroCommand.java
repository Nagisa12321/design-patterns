package com.jtchen.command.control.command.impl;

import com.jtchen.command.control.command.AbstractCommand;
import com.jtchen.command.control.command.Command;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/3/18 10:36
 */
public class MacroCommand extends AbstractCommand {
	// ������: ����������洢һ�������
	// ������execute() ����, ȫ��ִ��
	// ������undo() ����, ȫ������

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

package com.jtchen.command.control.command.impl;


import com.jtchen.command.control.beans.CeilingFan;
import com.jtchen.command.control.command.AbstractCommand;

public class CeilingFanOnCommand extends AbstractCommand {
	CeilingFan ceilingFan;

	public CeilingFanOnCommand(CeilingFan ceilingFan) {
		this.ceilingFan = ceilingFan;
	}
	public void execute() {
		ceilingFan.high();
	}

	@Override
	public void undo() {
		ceilingFan.off();
	}
}

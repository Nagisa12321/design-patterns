package com.jtchen.command.control.command.impl;


import com.jtchen.command.control.beans.CeilingFan;
import com.jtchen.command.control.command.AbstractCommand;

public class CeilingFanOffCommand extends AbstractCommand {
	CeilingFan ceilingFan;

	public CeilingFanOffCommand(CeilingFan ceilingFan) {
		this.ceilingFan = ceilingFan;
	}

	public void execute() {
		ceilingFan.off();
	}

	@Override
	public void undo() {
		ceilingFan.high();
	}
}

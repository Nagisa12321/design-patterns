package com.jtchen.command.control.command.impl;

import com.jtchen.command.control.beans.Hottub;
import com.jtchen.command.control.command.AbstractCommand;


public class HottubOffCommand extends AbstractCommand {
	Hottub hottub;

	public HottubOffCommand(Hottub hottub) {
		this.hottub = hottub;
	}

	public void execute() {
		hottub.cool();
		hottub.off();
	}

	@Override
	public void undo() {
		hottub.on();
		hottub.heat();
	}
}

package com.jtchen.command.control.command.impl;

import com.jtchen.command.control.beans.Hottub;
import com.jtchen.command.control.command.AbstractCommand;


public class HottubOnCommand extends AbstractCommand {
	Hottub hottub;

	public HottubOnCommand(Hottub hottub) {
		this.hottub = hottub;
	}

	public void execute() {
		hottub.on();
		hottub.heat();
		hottub.bubblesOn();
	}

	@Override
	public void undo() {
		hottub.cool();
		hottub.off();
	}
}

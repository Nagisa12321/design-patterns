package com.jtchen.command.control.command.impl;

import com.jtchen.command.control.beans.GarageDoor;
import com.jtchen.command.control.command.AbstractCommand;

public class GarageDoorUpCommand extends AbstractCommand {
	GarageDoor garageDoor;

	public GarageDoorUpCommand(GarageDoor garageDoor) {
		this.garageDoor = garageDoor;
	}

	public void execute() {
		garageDoor.up();
	}

	@Override
	public void undo() {
		garageDoor.down();
	}
}

package com.jtchen.command.control.command.impl;


import com.jtchen.command.control.beans.GarageDoor;
import com.jtchen.command.control.command.AbstractCommand;

public class GarageDoorDownCommand extends AbstractCommand {
	GarageDoor garageDoor;

	public GarageDoorDownCommand(GarageDoor garageDoor) {
		this.garageDoor = garageDoor;
	}

	public void execute() {
		garageDoor.down();
	}

	@Override
	public void undo() {
		garageDoor.up();
	}
}

package com.jtchen.command.control.command.impl;


import com.jtchen.command.control.beans.Light;
import com.jtchen.command.control.command.AbstractCommand;

public class LivingroomLightOnCommand extends AbstractCommand {
	Light light;

	public LivingroomLightOnCommand(Light light) {
		this.light = light;
	}

	public void execute() {
		light.on();
	}

	@Override
	public void undo() {
		light.off();
	}
}

package com.jtchen.command.control.command.impl;


import com.jtchen.command.control.beans.Light;
import com.jtchen.command.control.command.AbstractCommand;

public class LivingroomLightOffCommand extends AbstractCommand {
	Light light;

	public LivingroomLightOffCommand(Light light) {
		this.light = light;
	}

	public void execute() {
		light.off();
	}

	@Override
	public void undo() {
		light.on();
	}
}

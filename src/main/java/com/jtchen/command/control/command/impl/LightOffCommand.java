package com.jtchen.command.control.command.impl;


import com.jtchen.command.control.beans.Light;
import com.jtchen.command.control.command.AbstractCommand;


public class LightOffCommand extends AbstractCommand {
	Light light;
 
	public LightOffCommand(Light light) {
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

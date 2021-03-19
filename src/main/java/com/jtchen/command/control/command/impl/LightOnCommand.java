package com.jtchen.command.control.command.impl;

import com.jtchen.command.control.beans.Light;
import com.jtchen.command.control.command.AbstractCommand;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/3/17 10:54
 */
public class LightOnCommand extends AbstractCommand {

	private final Light light;

	public LightOnCommand(Light light) {
		this.light = light;
	}

	@Override
	public void execute() {
		light.on();
	}

	@Override
	public void undo() {
		light.off();
	}
}

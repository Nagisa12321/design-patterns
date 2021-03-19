package com.jtchen.command.control.command.impl;

import com.jtchen.command.control.beans.Stereo;
import com.jtchen.command.control.command.AbstractCommand;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/3/17 11:50
 */
public class StereoOnWithCDCommand extends AbstractCommand {

	private Stereo stereo;

	public StereoOnWithCDCommand(Stereo stereo) {
		this.stereo = stereo;
	}

	@Override
	public void execute() {
		stereo.on();
		stereo.setCD();
		stereo.setVolume(11);
	}

	@Override
	public void undo() {
		stereo.off();
	}
}

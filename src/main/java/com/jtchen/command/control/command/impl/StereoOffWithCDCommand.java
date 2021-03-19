package com.jtchen.command.control.command.impl;

import com.jtchen.command.control.beans.Stereo;
import com.jtchen.command.control.command.AbstractCommand;


/**
 * @author jtchen
 * @version 1.0
 * @date 2021/3/17 11:50
 */
public class StereoOffWithCDCommand extends AbstractCommand {

	private Stereo stereo;

	public StereoOffWithCDCommand(Stereo stereo) {
		this.stereo = stereo;
	}

	@Override
	public void execute() {
		stereo.off();
	}

	@Override
	public void undo() {
		stereo.on();
		stereo.setCD();
		stereo.setVolume(11);
	}
}

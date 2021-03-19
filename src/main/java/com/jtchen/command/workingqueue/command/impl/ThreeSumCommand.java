package com.jtchen.command.workingqueue.command.impl;

import com.jtchen.command.workingqueue.command.Command;
import com.jtchen.command.workingqueue.working.ThreeSum;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/3/18 11:14
 */
public class ThreeSumCommand implements Command {

	private final String name;
	private final ThreeSum threeSum;

	public ThreeSumCommand(int n) {
		name = n + " ints of three sum";
		threeSum = new ThreeSum(n);
	}

	@Override
	public void execute() {
		System.out.println('[' + Thread.currentThread().getName() + ']' + name);
		threeSum.calculate();
	}
}

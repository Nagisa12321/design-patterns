package com.jtchen.command.workingqueue.command.impl;

import com.jtchen.command.workingqueue.command.Command;
import com.jtchen.command.workingqueue.working.TwoSum;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/3/18 11:14
 */
public class TwoSumCommand implements Command {
	private final String name;
	private final TwoSum twoSum;

	public TwoSumCommand(int n) {
		name = n + " ints of two sum";
		twoSum = new TwoSum(n);
	}

	@Override
	public void execute() {
		System.out.println('[' + Thread.currentThread().getName() + ']' + name);
		twoSum.calculate();
	}
}

package com.jtchen.strategy.ducks.impl;

import com.jtchen.strategy.ducks.QuackBehavior;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/3/8 14:44
 */
public class DuckCall implements QuackBehavior {
	@Override
	public void quack() {
		System.out.println("Duck simulation tutorial");
	}
}

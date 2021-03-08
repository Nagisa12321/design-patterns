package com.jtchen.strategy.ducks.impl.quack;

import com.jtchen.strategy.ducks.QuackBehavior;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/3/8 14:08
 */
public class Quack implements QuackBehavior {
	@Override
	public void quack() {
		System.out.println("quack!");
	}
}

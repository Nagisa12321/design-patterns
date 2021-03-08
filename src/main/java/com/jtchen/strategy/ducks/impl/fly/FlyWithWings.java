package com.jtchen.strategy.ducks.impl.fly;

import com.jtchen.strategy.ducks.FlyBehavior;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/3/8 13:42
 */
public class FlyWithWings implements FlyBehavior {
	@Override
	public void fly() {
		System.out.println("I am flying~");
	}
}

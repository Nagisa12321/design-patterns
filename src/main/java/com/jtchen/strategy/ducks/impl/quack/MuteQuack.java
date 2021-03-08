package com.jtchen.strategy.ducks.impl.quack;

import com.jtchen.strategy.ducks.QuackBehavior;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/3/8 14:00
 */
public class MuteQuack implements QuackBehavior {
	@Override
	public void quack() {
		// 名为呱呱叫, 其实不出声
		System.out.println("...");
	}
}

package com.jtchen.strategy.ducks.impl;

import com.jtchen.strategy.ducks.Duck;
import com.jtchen.strategy.ducks.impl.quack.MuteQuack;
import com.jtchen.strategy.ducks.impl.fly.FlyNoWay;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/3/8 13:57
 */
public class MallardDuck extends Duck {
	public MallardDuck() {
		quackBehavior = new MuteQuack();
		flyBehavior = new FlyNoWay();
	}

	@Override
	public void display() {
		System.out.println("I am a real mallard duck");
	}
}

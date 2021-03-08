package com.jtchen.strategy.ducks.impl;

import com.jtchen.strategy.ducks.Duck;
import org.junit.Before;
import org.junit.Test;


public class MallardDuckTest {
	private Duck duck = null;

	@Before
	public void setUp() throws Exception {
		duck = new MallardDuck();
	}

	@Test
	public void performQuack() {
		duck.performQuack();
	}

	@Test
	public void performFly() {
		duck.performFly();
	}

	@Test
	public void swim() {
		duck.swim();
	}

	@Test
	public void display() {
		duck.display();
	}

	@Test
	public void testSetBehaviors() {
		duck.performFly();

		// 运行时设置鸭子的飞行行为
		duck.setFlyBehavior(() -> {
			System.out.println("I am flying with rocket!!!");
		});

		duck.performFly();
	}
}
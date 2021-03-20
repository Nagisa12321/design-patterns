package com.jtchen.adapter.duck;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/3/19 10:28
 */
public class MallardDuck implements Duck{
	@Override
	public void quack() {
		System.out.println("quack");
	}

	@Override
	public void fly() {
		System.out.println("I am flying~");
	}
}

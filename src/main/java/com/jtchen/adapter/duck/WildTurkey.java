package com.jtchen.adapter.duck;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/3/19 10:29
 */
public class WildTurkey implements Turkey{
	@Override
	public void gobble() {
		System.out.println("gobble, gobble");
	}

	@Override
	public void fly() {
		System.out.println("I am flying a short distance");
	}
}

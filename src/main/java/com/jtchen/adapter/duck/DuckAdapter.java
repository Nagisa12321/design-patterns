package com.jtchen.adapter.duck;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/3/19 10:50
 */
public class DuckAdapter implements Turkey {

	private final Duck duck;
	private int n;

	public DuckAdapter(Duck duck) {
		this.duck = duck;
		n = 0;
	}

	@Override
	public void gobble() {
		duck.quack();
	}

	// 让鸭子每五次飞一次
	@Override
	public void fly() {
		if (n == 4) {
			duck.fly();
			n = 0;
		} else n++;
	}
}

package com.jtchen.strategy.ducks.impl.fly;

import com.jtchen.strategy.ducks.FlyBehavior;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/3/8 13:43
 */
/*
用类代表一个行为, 感觉似乎有点奇怪, 类不应该是某种东西?

答: 在OO系统中, 是的类代表的东西一般都是既有状态又有方法
	只是在本例中, 恰巧"东西"只是个"行为"
 */
public class FlyNoWay implements FlyBehavior {
	@Override
	public void fly() {
		System.out.println("I can't fly");
	}
}

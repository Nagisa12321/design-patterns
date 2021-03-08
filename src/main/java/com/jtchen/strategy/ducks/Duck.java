package com.jtchen.strategy.ducks;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/3/7 20:59
 */
public abstract class Duck {
	protected FlyBehavior flyBehavior;
	protected QuackBehavior quackBehavior;

	public void performQuack() {
		// 每只鸭子都会实现QuackBehavior的接口对象
		// 而不是亲自实现鸭子呱呱叫行为
		quackBehavior.quack();
	}

	public void performFly() {
		// 同上
		flyBehavior.fly();
	}

	public void swim() {
		// 亲自实现鸭子的游泳行为
		System.out.println("I am swimming~");
	}

	// 可以在运行时动态设定鸭子的行为
	public void setFlyBehavior(FlyBehavior flyBehavior) {
		this.flyBehavior = flyBehavior;
	}

	public void setQuackBehavior(QuackBehavior quackBehavior) {
		this.quackBehavior = quackBehavior;
	}

	public abstract void display();
	// 外观
}


	/*
		当涉及维护时, 为了复用目的而选择继承
		结局不完美
		并非所有的鸭子都会飞
		public void fly() {

		}

		public void quack() {

		}

	 */

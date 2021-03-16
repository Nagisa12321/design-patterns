package com.jtchen.singleton.example;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/3/16 10:40
 */
public class Singleton {
	// 利用一个静态变量来记录Singleton唯一的实例
	private static Singleton uniqueInstance;
	// 把构造器声明为私有的, 只有Singleton之中才能使用自己的私有构造器
	private Singleton() {}
	// getInstance用于实例化对象, 并且返回这个对象
	public static Singleton getInstance() {
		// 延迟实例化: 我们不需要这个累的时候, 它永远不会产生
		// [lazy instantiaze]
		if (uniqueInstance == null)
			uniqueInstance = new Singleton();
		return uniqueInstance;
	}

	public void doSomething() {
		System.out.println("我已经被实例化");
	}
}

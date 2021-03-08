package com.jtchen.observer.weather;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/3/8 16:31
 */
public interface Subject {
	// 这是主题接口, 对象使用此接口注册为观察者, 或者把自己从观察者中删除

	// 注册一个观察者
	void registerObserver(Observer o);

	// 删除一个观察者
	void removeObserver(Observer o);

	// 通知所有注册的观察者
	void notifyObserver();

	/*
	怎么体现一对多关系？

	- 利用观察者模式, 主题是具有状态的对象, 并且可以控制这些状态, 也就是说,
		有“一个”具有状态的主题, 另一方面, 观察者使用这些状态, 尽管这些状态
		不属于它们, 有许多的观察者, 依赖主题来通知它们状态何时发生改变, 这就
		产生了一个主题对应多个观察者的效果
	 */
}

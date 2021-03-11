package com.jtchen.factory.pizzafm;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/3/11 10:47
 */
public abstract class PizzaStore {

	public Pizza orderPizza(String type) {
		Pizza pizza;

		// new操作符换成工厂的create方法, 这里不再使用具体实例化
		pizza = createPizza(type);

		pizza.prepare();
		pizza.bake();
		pizza.cut();
		pizza.box();

		return pizza;
	}

	// 把工厂对象重新移动到这个方法中, 不过是抽象的
	// 加盟的pizza店应该继承PizzaStore类并且实现自己的create方法
	public abstract Pizza createPizza(String type);
}

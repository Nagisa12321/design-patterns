package com.jtchen.factory.pizzaaf.factory.pizza;

import com.jtchen.factory.pizzaaf.pizza.Pizza;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/3/11 10:47
 */

/*
这是抽象创建这类, 它定义了一个抽象工厂方法, 让子类实现此方法制造产品

创建者通常会包含依赖子类抽象产品的代码, 而这些抽象产品由子类制造。
创建者不需要知道到底是哪种具体的产品。

实现了所有操作产品的方法, 但是不实现工厂方法

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

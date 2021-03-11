package com.jtchen.factory.pizzas;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/3/11 10:47
 */
public class PizzaStore {
	private SimplePizzaFactory factory;

	public PizzaStore(SimplePizzaFactory factory) {
		this.factory = factory;
	}

	public Pizza orderPizza(String type) {
		Pizza pizza;

		// new操作符换成工厂的create方法, 这里不再使用具体实例化
		pizza = factory.createPizza(type);

		pizza.prepare();
		pizza.bake();
		pizza.cut();
		pizza.box();

		return pizza;
	}
}

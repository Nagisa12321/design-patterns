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

		// new���������ɹ�����create����, ���ﲻ��ʹ�þ���ʵ����
		pizza = factory.createPizza(type);

		pizza.prepare();
		pizza.bake();
		pizza.cut();
		pizza.box();

		return pizza;
	}
}

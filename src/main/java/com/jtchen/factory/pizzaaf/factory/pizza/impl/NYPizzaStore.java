package com.jtchen.factory.pizzaaf.factory.pizza.impl;

import com.jtchen.factory.pizzaaf.factory.pizza.PizzaStore;
import com.jtchen.factory.pizzaaf.pizza.Pizza;
import com.jtchen.factory.pizzaaf.pizza.impl.NYStyleCheesePizza;
import com.jtchen.factory.pizzaaf.pizza.impl.NYStyleClamPizza;
import com.jtchen.factory.pizzaaf.pizza.impl.NYStylePepperoniPizza;
import com.jtchen.factory.pizzaaf.pizza.impl.NYStyleVeggiePizza;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/3/11 12:05
 */

/*


�ܹ�������Ʒ�������ǳ�Ϊ���崴����

��Ϊÿ�����˵궼���Լ���PizzaStore����, ���Կ��Դ����Լ���ζ��Pizza
 */
public class NYPizzaStore extends PizzaStore {
	@Override
	public Pizza createPizza(String type) {
		switch (type) {
			case "cheese":
				return new NYStyleCheesePizza();
			case "veggie":
				return new NYStyleVeggiePizza();
			case "clam":
				return new NYStyleClamPizza();
			case "pepperoni":
				return new NYStylePepperoniPizza();
			default:
				return null;
		}
	}
}

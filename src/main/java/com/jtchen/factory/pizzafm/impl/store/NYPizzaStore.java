package com.jtchen.factory.pizzafm.impl.store;

import com.jtchen.factory.pizzafm.Pizza;
import com.jtchen.factory.pizzafm.PizzaStore;
import com.jtchen.factory.pizzafm.impl.pizza.NYStyleCheesePizza;
import com.jtchen.factory.pizzafm.impl.pizza.NYStyleClamPizza;
import com.jtchen.factory.pizzafm.impl.pizza.NYStylePepperoniPizza;
import com.jtchen.factory.pizzafm.impl.pizza.NYStyleVeggiePizza;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/3/11 12:05
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

package com.jtchen.factory.pizzaaf.factory.pizza.impl;

import com.jtchen.factory.pizzaaf.factory.pizza.PizzaStore;
import com.jtchen.factory.pizzaaf.pizza.Pizza;
import com.jtchen.factory.pizzaaf.pizza.impl.ChicagoStyleCheesePizza;
import com.jtchen.factory.pizzaaf.pizza.impl.ChicagoStyleClamPizza;
import com.jtchen.factory.pizzaaf.pizza.impl.ChicagoStylePepperoniPizza;
import com.jtchen.factory.pizzaaf.pizza.impl.ChicagoStyleVeggiePizza;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/3/11 12:08
 */
public class ChicagoPizzaStore extends PizzaStore {
	@Override
	public Pizza createPizza(String type) {
		switch (type) {
			case "cheese":
				return new ChicagoStyleCheesePizza();
			case "veggie":
				return new ChicagoStyleVeggiePizza();
			case "clam":
				return new ChicagoStyleClamPizza();
			case "pepperoni":
				return new ChicagoStylePepperoniPizza();
			default:
				return null;
		}
	}
}

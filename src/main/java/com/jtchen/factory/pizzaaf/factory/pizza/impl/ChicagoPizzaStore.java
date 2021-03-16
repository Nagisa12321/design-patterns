package com.jtchen.factory.pizzaaf.factory.pizza.impl;

import com.jtchen.factory.pizzaaf.factory.metrial.PizzaIngredientFactory;
import com.jtchen.factory.pizzaaf.factory.metrial.impl.ChicagoPizzaIngredientFactory;
import com.jtchen.factory.pizzaaf.factory.pizza.PizzaStore;
import com.jtchen.factory.pizzaaf.pizza.Pizza;
import com.jtchen.factory.pizzaaf.pizza.impl.CheesePizza;
import com.jtchen.factory.pizzaaf.pizza.impl.ClamPizza;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/3/11 12:08
 */
public class ChicagoPizzaStore extends PizzaStore {
	@Override
	public Pizza createPizza(String type) {
		PizzaIngredientFactory factory = new ChicagoPizzaIngredientFactory();


		switch (type) {
			case "cheese":
				return new CheesePizza(factory);

			case "clam":
				return new ClamPizza(factory);

			default:
				return null;
		}
	}
}

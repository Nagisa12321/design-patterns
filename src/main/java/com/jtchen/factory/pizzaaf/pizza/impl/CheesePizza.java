package com.jtchen.factory.pizzaaf.pizza.impl;

import com.jtchen.factory.pizzaaf.factory.metrial.PizzaIngredientFactory;
import com.jtchen.factory.pizzaaf.pizza.Pizza;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/3/15 14:49
 */
public class CheesePizza extends Pizza {

	private final PizzaIngredientFactory factory;

	public CheesePizza(PizzaIngredientFactory factory) {
		this.factory = factory;
	}

	@Override
	public void prepare() {
		System.out.println("prepareing " + name);
		dough = factory.createDough();
		sauce = factory.createSauce();
		cheese = factory.createCheese();
	}
}

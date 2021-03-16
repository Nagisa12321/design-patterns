package com.jtchen.factory.pizzaaf.pizza.impl;

import com.jtchen.factory.pizzaaf.factory.metrial.PizzaIngredientFactory;
import com.jtchen.factory.pizzaaf.pizza.Pizza;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/3/15 14:54
 */
public class ClamPizza extends Pizza {
	private final PizzaIngredientFactory factory;

	public ClamPizza(PizzaIngredientFactory factory) {
		this.factory = factory;
	}

	@Override
	public void prepare() {
		System.out.println("prepareing " + name);
		dough = factory.createDough();
		sauce = factory.createSauce();
		cheese = factory.createCheese();
		clams = factory.createClam();
	}
}

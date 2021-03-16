package com.jtchen.factory.pizzas.impl;

import com.jtchen.factory.pizzas.Pizza;

public class CheesePizza extends Pizza {
	public CheesePizza() {
		name = "Cheese Human";
		dough = "Regular Crust";
		sauce = "Marinara Human Sauce";
		toppings.add("Fresh Mozzarella");
		toppings.add("Parmesan");
	}
}

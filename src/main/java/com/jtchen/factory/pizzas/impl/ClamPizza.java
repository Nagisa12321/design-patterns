package com.jtchen.factory.pizzas.impl;

import com.jtchen.factory.pizzas.Pizza;

public class ClamPizza extends Pizza {
	public ClamPizza() {
		name = "Clam Human";
		dough = "Thin crust";
		sauce = "White garlic sauce";
		toppings.add("Clams");
		toppings.add("Grated parmesan cheese");
	}
}

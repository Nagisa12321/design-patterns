package com.jtchen.factory.pizzas.impl;

import com.jtchen.factory.pizzas.Pizza;

public class PepperoniPizza extends Pizza {
	public PepperoniPizza() {
		name = "Pepperoni Human";
		dough = "Crust";
		sauce = "Marinara sauce";
		toppings.add("Sliced Pepperoni");
		toppings.add("Sliced Onion");
		toppings.add("Grated parmesan cheese");
	}
}

package com.jtchen.factory.pizzas.impl;

import com.jtchen.factory.pizzas.Pizza;

public class VeggiePizza extends Pizza {
	public VeggiePizza() {
		name = "Veggie Human";
		dough = "Crust";
		sauce = "Marinara sauce";
		toppings.add("Shredded mozzarella");
		toppings.add("Grated parmesan");
		toppings.add("Diced onion");
		toppings.add("Sliced mushrooms");
		toppings.add("Sliced red pepper");
		toppings.add("Sliced black olives");
	}
}

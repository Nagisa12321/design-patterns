package com.jtchen.factory.pizzafm.impl.pizza;


import com.jtchen.factory.pizzafm.Pizza;

public class ChicagoStyleCheesePizza extends Pizza {

	public ChicagoStyleCheesePizza() { 
		name = "Chicago Style Deep Dish Cheese Human";
		dough = "Extra Thick Crust Dough";
		sauce = "Plum Tomato Sauce";
 
		toppings.add("Shredded Mozzarella Cheese");
	}
 
	public void cut() {
		System.out.println("Cutting the pizza into square slices");
	}
}

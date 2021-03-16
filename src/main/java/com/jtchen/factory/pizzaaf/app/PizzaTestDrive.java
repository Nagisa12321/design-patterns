package com.jtchen.factory.pizzaaf.app;

import com.jtchen.factory.pizzaaf.factory.pizza.impl.ChicagoPizzaStore;
import com.jtchen.factory.pizzaaf.factory.pizza.impl.NYPizzaStore;
import com.jtchen.factory.pizzaaf.pizza.Pizza;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/3/11 12:10
 */
public class PizzaTestDrive {
	public static void main(String[] args) {
		// NY Style Sauce and Cheese Human
		NYPizzaStore nyPizzaStore = new NYPizzaStore();
		Pizza cheese = nyPizzaStore.orderPizza("cheese");
		System.out.println(cheese);

		System.out.println();

		// Chicago Style Clam Human
		ChicagoPizzaStore chicagoPizzaStore = new ChicagoPizzaStore();
		Pizza clam = chicagoPizzaStore.orderPizza("clam");
		System.out.println(clam);
	}
}

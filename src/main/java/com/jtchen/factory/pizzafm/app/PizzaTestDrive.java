package com.jtchen.factory.pizzafm.app;

import com.jtchen.factory.pizzafm.Pizza;
import com.jtchen.factory.pizzafm.impl.store.ChicagoPizzaStore;
import com.jtchen.factory.pizzafm.impl.store.NYPizzaStore;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/3/11 12:10
 */
public class PizzaTestDrive {
	public static void main(String[] args) {
		// NY Style Sauce and Cheese Pizza
		NYPizzaStore nyPizzaStore = new NYPizzaStore();
		Pizza cheese = nyPizzaStore.orderPizza("cheese");
		System.out.println(cheese);

		System.out.println();

		// Chicago Style Clam Pizza
		ChicagoPizzaStore chicagoPizzaStore = new ChicagoPizzaStore();
		Pizza clam = chicagoPizzaStore.orderPizza("clam");
		System.out.println(clam);
	}
}

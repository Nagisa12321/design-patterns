package com.jtchen.factory.pizzafm.impl.store;

import com.jtchen.factory.pizzafm.Pizza;
import com.jtchen.factory.pizzafm.PizzaStore;
import com.jtchen.factory.pizzafm.impl.pizza.*;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/3/11 12:08
 */
public class ChicagoPizzaStore extends PizzaStore {
	@Override
	public Pizza createPizza(String type) {
		switch (type) {
			case "cheese":
				return new ChicagoStyleCheesePizza();
			case "veggie":
				return new ChicagoStyleVeggiePizza();
			case "clam":
				return new ChicagoStyleClamPizza();
			case "pepperoni":
				return new ChicagoStylePepperoniPizza();
			default:
				return null;
		}
	}
}

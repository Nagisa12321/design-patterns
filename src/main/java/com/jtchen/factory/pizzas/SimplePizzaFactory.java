package com.jtchen.factory.pizzas;

import com.jtchen.factory.pizzas.impl.CheesePizza;
import com.jtchen.factory.pizzas.impl.ClamPizza;
import com.jtchen.factory.pizzas.impl.PepperoniPizza;
import com.jtchen.factory.pizzas.impl.VeggiePizza;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/3/11 10:38
 */
public class SimplePizzaFactory {
	// 通常声明为静态
	public Pizza createPizza(String type) {
		Pizza pizza = null;

		switch (type) {
			case "cheese":
				pizza = new CheesePizza();
				break;
			case "pepperoni":
				pizza = new PepperoniPizza();
				break;
			case "clam":
				pizza = new ClamPizza();
				break;
			case "veggie":
				pizza = new VeggiePizza();
				break;
		}

		return pizza;
	}
}

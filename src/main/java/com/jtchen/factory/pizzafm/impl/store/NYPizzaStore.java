package com.jtchen.factory.pizzafm.impl.store;

import com.jtchen.factory.pizzafm.Pizza;
import com.jtchen.factory.pizzafm.PizzaStore;
import com.jtchen.factory.pizzafm.impl.pizza.NYStyleCheesePizza;
import com.jtchen.factory.pizzafm.impl.pizza.NYStyleClamPizza;
import com.jtchen.factory.pizzafm.impl.pizza.NYStylePepperoniPizza;
import com.jtchen.factory.pizzafm.impl.pizza.NYStyleVeggiePizza;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/3/11 12:05
 */

/*


能够产生产品的类我们称为具体创建者

因为每个加盟店都有自己的PizzaStore子类, 所以可以创造自己风味的Pizza
 */
public class NYPizzaStore extends PizzaStore {
	@Override
	public Pizza createPizza(String type) {
		switch (type) {
			case "cheese":
				return new NYStyleCheesePizza();
			case "veggie":
				return new NYStyleVeggiePizza();
			case "clam":
				return new NYStyleClamPizza();
			case "pepperoni":
				return new NYStylePepperoniPizza();
			default:
				return null;
		}
	}
}

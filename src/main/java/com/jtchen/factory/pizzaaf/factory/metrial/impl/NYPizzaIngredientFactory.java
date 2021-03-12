package com.jtchen.factory.pizzaaf.factory.metrial.impl;

import com.jtchen.factory.pizzaaf.factory.metrial.PizzaIngredientFactory;
import com.jtchen.factory.pizzaaf.material.*;
import com.jtchen.factory.pizzaaf.material.impl.*;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/3/12 12:29
 */
public class NYPizzaIngredientFactory implements PizzaIngredientFactory {
	@Override
	public Dough createDough() {
		return new ThinCrustDough();
	}

	@Override
	public Cheese createCheese() {
		return new ReggianoCheese();
	}

	@Override
	public Sauce createSauce() {
		return new MarinaraSauce();
	}

	@Override
	public Veggies[] createVeggies() {
		return new Veggies[]{new Garlic(), new Onion(), new Mushroom(), new RedPepper()};
	}

	@Override
	public Pepperoni createPepperoni() {
		return new SlicedPepperoni();
	}

	@Override
	public Clams createClam() {
		return new FreshClams();
	}
}

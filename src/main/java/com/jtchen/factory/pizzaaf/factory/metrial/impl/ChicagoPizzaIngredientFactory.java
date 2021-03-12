package com.jtchen.factory.pizzaaf.factory.metrial.impl;

import com.jtchen.factory.pizzaaf.factory.metrial.PizzaIngredientFactory;
import com.jtchen.factory.pizzaaf.material.*;
import com.jtchen.factory.pizzaaf.material.impl.*;

public class ChicagoPizzaIngredientFactory
		implements PizzaIngredientFactory {

	public Dough createDough() {
		return new ThickCrustDough();
	}

	public Sauce createSauce() {
		return new PlumTomatoSauce();
	}

	public Cheese createCheese() {
		return new MozzarellaCheese();
	}

	public Veggies[] createVeggies() {
		return new Veggies[]{new BlackOlives(),
				new Spinach(),
				new Eggplant()};
	}

	public Pepperoni createPepperoni() {
		return new SlicedPepperoni();
	}

	public Clams createClam() {
		return new FrozenClams();
	}
}

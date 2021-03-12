package com.jtchen.factory.pizzaaf.factory.metrial;

import com.jtchen.factory.pizzaaf.material.*;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/3/12 12:21
 */
public interface PizzaIngredientFactory {

	Dough createDough();

	Cheese createCheese();

	Sauce createSauce();

	Veggies[] createVeggies();

	Pepperoni createPepperoni();

	Clams createClam();


}

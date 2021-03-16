package com.jtchen.factory.pizzaaf.pizza;

import com.jtchen.factory.pizzaaf.material.*;

import java.util.ArrayList;
import java.util.List;

public abstract class Pizza {
	// 每个pizza都持有一组准备时会用到的材料
	protected String name;
	protected Dough dough;
	protected Sauce sauce;
	protected Veggies[] veggies;
	protected Cheese cheese;
	protected Pepperoni pepperoni;
	protected Clams clams;


	// 把prepare方法声明为抽象, 在这个方法我们需要收集所需的原料, 而这些原料来自原料工厂
	// 只需让后续特定pizza类中引入特定工厂代劳即可
	public abstract void prepare();

	protected List<String> toppings = new ArrayList<>();

	public String getName() {
		return name;
	}

	public void bake() {
		System.out.println("Baking " + name);
	}

	public void cut() {
		System.out.println("Cutting " + name);
	}

	public void box() {
		System.out.println("Boxing " + name);
	}

	public String toString() {
		// code to display pizza name and ingredients
		StringBuilder display = new StringBuilder();
		display.append("---- ").append(name).append(" ----\n");
		display.append(dough).append("\n");
		display.append(sauce).append("\n");
		for (String topping : toppings) {
			display.append(topping).append("\n");
		}
		return display.toString();
	}
}


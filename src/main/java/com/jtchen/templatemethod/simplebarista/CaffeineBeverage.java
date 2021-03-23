package com.jtchen.templatemethod.simplebarista;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/3/20 11:35
 */
public abstract class CaffeineBeverage {

	// 现在用的是同一个方法来处理茶和咖啡
	// prepareRecipe被声明为final
	// 因为我们不希望子类取去覆盖这个方法
	public final void prepareRecipe() {
		// 在这个模板中, 算法中的每一个步骤都被一些方法代替了
		boilWater(); // 某些方法是由这个类处理的.....
		brew(); // ..... 某些方法是由子类处理的
		pourInCup();
		if (customersWantsCondiments()) addCondiments();


	}

	public abstract void brew();

	public abstract void addCondiments();

	public final void boilWater() {
		System.out.println("Boiling water");
	}

	public final void pourInCup() {
		System.out.println("Pouring in cup");
	}

	// 钩子方法, 可以由子类自行实现
	public boolean customersWantsCondiments() {
		return true;
	}

	public static void main(String[] args) {
		System.out.println("make coffee.....");
		CaffeineBeverage coffee = new Coffee();
		coffee.prepareRecipe();
		System.out.println("\nmake tea.....");
		CaffeineBeverage tea = new Tea();
		tea.prepareRecipe();
	}
}

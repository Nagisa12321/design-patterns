package com.jtchen.templatemethod.simplebarista;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/3/20 11:15
 */
public class Coffee extends CaffeineBeverage {


	@Override
	public void brew() {
		System.out.println("Dripping Coffee through filter");
	}

	@Override
	public void addCondiments() {
		System.out.println("Adding Sugar and milk");

	}
}

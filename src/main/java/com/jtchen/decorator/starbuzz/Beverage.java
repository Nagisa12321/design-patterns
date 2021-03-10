package com.jtchen.decorator.starbuzz;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/3/10 10:28
 */
public abstract class Beverage {

	private Size size;

	public Size getSize() {
		return size;
	}

	public void setSize(Size size) {
		this.size = size;
	}

	protected String description = "Unknown Beverage";

	public String getDescription() {
		return description;
	}

	public abstract double cost();
}

package com.jtchen.decorator.starbuzz.condimentImpl;

import com.jtchen.decorator.starbuzz.Beverage;
import com.jtchen.decorator.starbuzz.CondimentDecorator;
import com.jtchen.decorator.starbuzz.Size;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/3/10 11:47
 */
public class Mocha extends CondimentDecorator {

	private final Beverage beverage;

	public Mocha(Beverage beverage) {
		this.beverage = beverage;
	}

	@Override
	public double cost() {
		double cost;
		if (getSize() == Size.tall)
			cost = .10;
		else if (getSize() == Size.grande)
			cost = .15;
		else cost = .20;

		// 饮料价钱加上mocha的价钱
		return beverage.cost() + cost;
	}

	@Override
	public String getDescription() {
		return beverage.getDescription() + ", Mocha";
	}
}

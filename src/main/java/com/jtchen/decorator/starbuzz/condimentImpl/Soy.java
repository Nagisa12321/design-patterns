package com.jtchen.decorator.starbuzz.condimentImpl;

import com.jtchen.decorator.starbuzz.Beverage;
import com.jtchen.decorator.starbuzz.CondimentDecorator;
import com.jtchen.decorator.starbuzz.Size;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/3/10 11:48
 */
public class Soy extends CondimentDecorator {

	private final Beverage beverage;

	public Soy(Beverage beverage) {
		this.beverage = beverage;
	}

	@Override
	public double cost() {
		double cost;
		if (getSize() == Size.tall)
			cost = .15;
		else if (getSize() == Size.grande)
			cost = .20;
		else cost = .25;

		// ���ϼ�Ǯ����mocha�ļ�Ǯ
		return beverage.cost() + cost;	}

	@Override
	public String getDescription() {
		return beverage.getDescription() + ", Soy";
	}
}

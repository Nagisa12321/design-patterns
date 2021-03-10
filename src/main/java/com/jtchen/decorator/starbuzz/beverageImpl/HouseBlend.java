package com.jtchen.decorator.starbuzz.beverageImpl;

import com.jtchen.decorator.starbuzz.Beverage;
import com.jtchen.decorator.starbuzz.Size;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/3/10 11:45
 */
public class HouseBlend extends Beverage {


	public HouseBlend(Size size) {
		setSize(size);
		description = size + " House Blend Coffee";
	}

	@Override
	public double cost() {
		return .89;
	}
}

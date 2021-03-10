package com.jtchen.decorator.starbuzz.app;

import com.jtchen.decorator.starbuzz.Beverage;
import com.jtchen.decorator.starbuzz.Size;
import com.jtchen.decorator.starbuzz.beverageImpl.Espresso;
import com.jtchen.decorator.starbuzz.beverageImpl.HouseBlend;
import com.jtchen.decorator.starbuzz.condimentImpl.Mocha;
import com.jtchen.decorator.starbuzz.condimentImpl.Soy;
import com.jtchen.decorator.starbuzz.condimentImpl.Whip;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/3/10 11:52
 */
public class StarbuzzCoffee {
	public static void main(String[] args) {

		// 订一杯Espresso, 不许调料, 打印它的描述和价钱
		Beverage beverage = new Espresso(Size.tall);
		System.out.println(beverage.getDescription() + " $" + beverage.cost());

		Beverage beverage1 = new HouseBlend(Size.grande);
		beverage1 = new Soy(beverage1);
		beverage1 = new Mocha(beverage1);
		beverage1 = new Mocha(beverage1);
		beverage1 = new Whip(beverage1);
		System.out.println(beverage1.getDescription() + " $" + beverage1.cost());

	}
}

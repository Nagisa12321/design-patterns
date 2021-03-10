package com.jtchen.decorator.starbuzz.beverageImpl;

import com.jtchen.decorator.starbuzz.Beverage;
import com.jtchen.decorator.starbuzz.Size;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/3/10 11:42
 */
public class Espresso extends Beverage {

	public Espresso(Size size) {
		setSize(size);
		// 构造器中添加对饮料的描述
		description = size + " Espresso";
	}

	@Override
	public double cost() {
		return 1.99;
		// 最后需要计算Espresso的价钱, 现在先不用管调料的价钱
		// 直接返回1.99即可
	}
}

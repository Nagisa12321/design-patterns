package com.jtchen.decorator.starbuzz;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/3/10 11:39
 */
public abstract class CondimentDecorator extends Beverage {
	// 所有的调料装饰者必须重新实现getDescription()
	public abstract String getDescription();
}

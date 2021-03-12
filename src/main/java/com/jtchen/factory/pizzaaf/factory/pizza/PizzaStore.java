package com.jtchen.factory.pizzaaf.factory.pizza;

import com.jtchen.factory.pizzaaf.pizza.Pizza;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/3/11 10:47
 */

/*
���ǳ��󴴽�����, ��������һ�����󹤳�����, ������ʵ�ִ˷��������Ʒ

������ͨ�������������������Ʒ�Ĵ���, ����Щ�����Ʒ���������졣
�����߲���Ҫ֪�����������־���Ĳ�Ʒ��

ʵ�������в�����Ʒ�ķ���, ���ǲ�ʵ�ֹ�������

 */
public abstract class PizzaStore {

	public Pizza orderPizza(String type) {
		Pizza pizza;

		// new���������ɹ�����create����, ���ﲻ��ʹ�þ���ʵ����
		pizza = createPizza(type);

		pizza.prepare();
		pizza.bake();
		pizza.cut();
		pizza.box();

		return pizza;
	}

	// �ѹ������������ƶ������������, �����ǳ����
	// ���˵�pizza��Ӧ�ü̳�PizzaStore�ಢ��ʵ���Լ���create����
	public abstract Pizza createPizza(String type);
}

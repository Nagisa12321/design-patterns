package com.jtchen.factory.pizzafm;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/3/11 10:47
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

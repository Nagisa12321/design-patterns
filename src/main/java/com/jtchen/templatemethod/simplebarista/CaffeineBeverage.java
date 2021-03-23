package com.jtchen.templatemethod.simplebarista;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/3/20 11:35
 */
public abstract class CaffeineBeverage {

	// �����õ���ͬһ�������������Ϳ���
	// prepareRecipe������Ϊfinal
	// ��Ϊ���ǲ�ϣ������ȡȥ�����������
	public final void prepareRecipe() {
		// �����ģ����, �㷨�е�ÿһ�����趼��һЩ����������
		boilWater(); // ĳЩ������������ദ���.....
		brew(); // ..... ĳЩ�����������ദ���
		pourInCup();
		if (customersWantsCondiments()) addCondiments();


	}

	public abstract void brew();

	public abstract void addCondiments();

	public final void boilWater() {
		System.out.println("Boiling water");
	}

	public final void pourInCup() {
		System.out.println("Pouring in cup");
	}

	// ���ӷ���, ��������������ʵ��
	public boolean customersWantsCondiments() {
		return true;
	}

	public static void main(String[] args) {
		System.out.println("make coffee.....");
		CaffeineBeverage coffee = new Coffee();
		coffee.prepareRecipe();
		System.out.println("\nmake tea.....");
		CaffeineBeverage tea = new Tea();
		tea.prepareRecipe();
	}
}

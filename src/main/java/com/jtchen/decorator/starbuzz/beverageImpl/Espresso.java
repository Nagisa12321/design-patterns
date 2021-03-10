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
		// ����������Ӷ����ϵ�����
		description = size + " Espresso";
	}

	@Override
	public double cost() {
		return 1.99;
		// �����Ҫ����Espresso�ļ�Ǯ, �����Ȳ��ùܵ��ϵļ�Ǯ
		// ֱ�ӷ���1.99����
	}
}

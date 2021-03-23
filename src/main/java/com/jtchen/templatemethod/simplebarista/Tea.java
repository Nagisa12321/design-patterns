package com.jtchen.templatemethod.simplebarista;

import java.util.Scanner;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/3/20 11:18
 */
public class Tea extends CaffeineBeverage {

	@Override
	public void brew() {
		System.out.println("Steeping the tea");

	}

	@Override
	public void addCondiments() {
		System.out.println("Adding Lemon");
	}

	@Override
	public boolean customersWantsCondiments() {
		String answer = getCustomersInput();

		return answer.equals("yes");
	}

	private String getCustomersInput() {
		System.out.println("Do you want Condiments?");
		Scanner scanner = new Scanner(System.in);

		return scanner.next();
	}
}

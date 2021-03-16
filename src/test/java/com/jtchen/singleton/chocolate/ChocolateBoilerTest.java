package com.jtchen.singleton.chocolate;

import static org.junit.Assert.*;

public class ChocolateBoilerTest {

	public static void main(String[] args) {

		Runnable r = () -> {
			ChocolateBoiler instance = ChocolateBoiler.getInstance();
			System.out.println(instance);
		};

		Thread t1 = new Thread(r);
		Thread t2 = new Thread(r);

		t1.start();
		t2.start();
		/*
		尝试了几下, 居然会拿到两个不同的对象
		com.jtchen.singleton.chocolate.ChocolateBoiler@4b7ed410
		com.jtchen.singleton.chocolate.ChocolateBoiler@4d858e
		 */
	}
}
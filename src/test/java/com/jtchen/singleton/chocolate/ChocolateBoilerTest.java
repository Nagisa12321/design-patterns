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
		�����˼���, ��Ȼ���õ�������ͬ�Ķ���
		com.jtchen.singleton.chocolate.ChocolateBoiler@4b7ed410
		com.jtchen.singleton.chocolate.ChocolateBoiler@4d858e
		 */
	}
}
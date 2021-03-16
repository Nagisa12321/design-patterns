package com.jtchen.singleton.example;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/3/16 10:42
 */
public class Customer {
	public static void main(String[] args) {
		Singleton singleton = Singleton.getInstance();
		singleton.doSomething();

	}
}

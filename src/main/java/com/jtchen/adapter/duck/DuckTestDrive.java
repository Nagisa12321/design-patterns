package com.jtchen.adapter.duck;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/3/19 10:38
 */
public class DuckTestDrive {

	public static void main(String[] args) {
		MallardDuck mallardDuck = new MallardDuck();

		WildTurkey turkey = new WildTurkey();
		Duck adapter = new TurkeyAdapter(turkey);

		System.out.println("the turkey says....");
		turkey.gobble();
		turkey.fly();

		System.out.println("\nthe duck says....");
		testDuck(mallardDuck);

		// testDuck() ����������֪��, ����һֻ��װ��Ѽ�ӵĻ�
		System.out.println("\nthe duck says....");
		testDuck(adapter);

	}

	private static void testDuck(Duck duck) {
		duck.quack();
		duck.fly();
	}


}

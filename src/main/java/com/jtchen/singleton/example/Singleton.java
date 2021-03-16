package com.jtchen.singleton.example;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/3/16 10:40
 */
public class Singleton {
	// ����һ����̬��������¼SingletonΨһ��ʵ��
	private static Singleton uniqueInstance;
	// �ѹ���������Ϊ˽�е�, ֻ��Singleton֮�в���ʹ���Լ���˽�й�����
	private Singleton() {}
	// getInstance����ʵ��������, ���ҷ����������
	public static Singleton getInstance() {
		// �ӳ�ʵ����: ���ǲ���Ҫ����۵�ʱ��, ����Զ�������
		// [lazy instantiaze]
		if (uniqueInstance == null)
			uniqueInstance = new Singleton();
		return uniqueInstance;
	}

	public void doSomething() {
		System.out.println("���Ѿ���ʵ����");
	}
}

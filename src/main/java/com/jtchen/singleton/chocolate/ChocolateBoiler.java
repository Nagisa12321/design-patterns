package com.jtchen.singleton.chocolate;

import com.jtchen.singleton.example.Singleton;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/3/16 10:52
 */
public class ChocolateBoiler {
	// volatile�ؼ���ȷ��, ��chocolateBoiler����ʼ����ChocolateBoiler����ʱ
	// ����߳���ȷ�Ĵ���chocolateBoiler����
	private static volatile ChocolateBoiler chocolateBoiler;
	private boolean empty;
	private boolean boiled;

	private ChocolateBoiler() {
		empty = true;
		boiled = true;
	}

	public static synchronized ChocolateBoiler getInstance() {
		// ���ʵ��, ���������, �����ͬ������
		if (chocolateBoiler == null) {
			// ����Ӧ������м���
			synchronized (Singleton.class) {
				// ��������֮��, �ټ��һ��, �����ȻΪnull, ���Ŵ���ʵ��
				if (chocolateBoiler == null) {
					chocolateBoiler = new ChocolateBoiler();
				}
			}
		}
		return chocolateBoiler;
	}

	public void fill() {
		if (isEmpty()) {
			empty = false;
			boiled = false;
		}
	}

	public void drain() {
		if (!isEmpty() && isBoiled()) {
			empty = true;
		}
	}

	public void boil() {
		if (!isEmpty() && isBoiled()) {
			boiled = true;
		}
	}

	public boolean isEmpty() {
		return empty;
	}

	public boolean isBoiled() {
		return boiled;
	}


}

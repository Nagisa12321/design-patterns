package com.jtchen.singleton.chocolate;

import com.jtchen.singleton.example.Singleton;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/3/16 10:52
 */
public class ChocolateBoiler {
	// volatile关键字确保, 当chocolateBoiler被初始化成ChocolateBoiler对象时
	// 多个线程正确的处理chocolateBoiler变量
	private static volatile ChocolateBoiler chocolateBoiler;
	private boolean empty;
	private boolean boiled;

	private ChocolateBoiler() {
		empty = true;
		boiled = true;
	}

	public static synchronized ChocolateBoiler getInstance() {
		// 检查实例, 如果不存在, 则进入同步区域
		if (chocolateBoiler == null) {
			// 对相应的类进行加锁
			synchronized (Singleton.class) {
				// 进入区块之后, 再检查一次, 如果仍然为null, 方才创建实例
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

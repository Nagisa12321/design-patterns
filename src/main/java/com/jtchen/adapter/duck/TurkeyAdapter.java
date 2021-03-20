package com.jtchen.adapter.duck;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/3/19 10:30
 */
// 首先你得事项想要转换成的类型接口
// 这就是你的客户期望看到的接口
public class TurkeyAdapter implements Duck {

	private final Turkey turkey;

	// 接着, 需要取得要适配的对象引用
	// 这里我们用构造器取得这个引用
	public TurkeyAdapter(Turkey turkey) {
		this.turkey = turkey;
	}

	// 现在我们需要实现接口中的所有方法
	@Override
	public void quack() {
		turkey.gobble();
	}

	// 火鸡飞5次 = 鸭子飞一次
	@Override
	public void fly() {
		for (int i = 0; i < 5; i++) {
			turkey.fly();
		}
	}
}

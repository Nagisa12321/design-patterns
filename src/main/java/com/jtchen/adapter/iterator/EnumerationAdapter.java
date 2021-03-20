package com.jtchen.adapter.iterator;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.function.Consumer;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/3/19 11:11
 */
// 因为我们将枚举类适配成迭代器, 适配器就必须要实现迭代器接口
// 适配器必须看起来像一个迭代器
public class EnumerationAdapter<E> implements Iterator<E> {

	private Enumeration<E> enumeration;

	// hasNext() 方法委托给 enumeration 的 hasMoreElements() 方法
	@Override
	public boolean hasNext() {
		return enumeration.hasMoreElements();
	}

	// 同理委托
	@Override
	public E next() {
		return enumeration.nextElement();
	}

	@Override
	public void remove() {

	}

	// 我们不能支持迭代器的remove()方法 , 因此必须放弃,
	// 在这里我们的做法是抛出一个异常
	@Override
	public void forEachRemaining(Consumer<? super E> action) {

	}
}

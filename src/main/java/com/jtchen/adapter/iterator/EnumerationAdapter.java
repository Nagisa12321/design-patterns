package com.jtchen.adapter.iterator;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.function.Consumer;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/3/19 11:11
 */
// ��Ϊ���ǽ�ö��������ɵ�����, �������ͱ���Ҫʵ�ֵ������ӿ�
// ���������뿴������һ��������
public class EnumerationAdapter<E> implements Iterator<E> {

	private Enumeration<E> enumeration;

	// hasNext() ����ί�и� enumeration �� hasMoreElements() ����
	@Override
	public boolean hasNext() {
		return enumeration.hasMoreElements();
	}

	// ͬ��ί��
	@Override
	public E next() {
		return enumeration.nextElement();
	}

	@Override
	public void remove() {

	}

	// ���ǲ���֧�ֵ�������remove()���� , ��˱������,
	// ���������ǵ��������׳�һ���쳣
	@Override
	public void forEachRemaining(Consumer<? super E> action) {

	}
}

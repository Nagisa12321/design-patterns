package com.jtchen.adapter.iterator;

import java.util.Enumeration;
import java.util.Iterator;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/3/19 11:28
 */
public class IteratorAdapter<E> implements Enumeration<E> {

	private final Iterator<E> iterator;

	public IteratorAdapter(Iterator<E> iterator) {
		this.iterator = iterator;
	}

	@Override
	public boolean hasMoreElements() {
		return iterator.hasNext();
	}

	@Override
	public E nextElement() {
		return iterator.next();
	}
}

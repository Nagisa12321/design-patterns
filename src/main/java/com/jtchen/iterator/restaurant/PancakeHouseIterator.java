package com.jtchen.iterator.restaurant;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/3/23 10:52
 */
public class PancakeHouseIterator implements Iterator<MenuItem> {

	private final ArrayList<MenuItem> list;
	private int idx;

	public PancakeHouseIterator(ArrayList<MenuItem> list) {
		this.idx = 0;
		this.list = list;
	}

	@Override
	public boolean hasNext() {
		return idx != list.size();
	}

	@Override
	public MenuItem next() {
		return list.get(idx++);
	}
}

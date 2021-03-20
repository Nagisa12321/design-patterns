package com.jtchen.adapter.iterator;

import java.util.ArrayList;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/3/19 11:29
 */
public class ArrayListAdapterTest {
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();

		for (int i = 0; i < 5; i++) {
			list.add(i);
		}

		IteratorAdapter<Integer> adapter = new IteratorAdapter<>(list.iterator());

		while (adapter.hasMoreElements()) System.out.println(adapter.nextElement());
	}
}

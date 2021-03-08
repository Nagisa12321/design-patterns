package com.jtchen.strategy.ducks.impl;

import org.junit.Test;

public class DuckCallTest {

	@Test
	public void quack() {
		DuckCall duckCall = new DuckCall();
		duckCall.quack();
	}
}
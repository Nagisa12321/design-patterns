package com.jtchen.observer.weather.impl.disaplay;

import com.jtchen.observer.weather.DisplayElement;
import com.jtchen.observer.weather.Observer;
import com.jtchen.observer.weather.Subject;
import com.jtchen.observer.weather.beans.State;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/3/8 18:34
 */
public class ChineseDisplay implements Observer, DisplayElement {
	private State state;
	/*
	之后我们可能需要取消注册, 如果已经有对subject的引用会比较方便
	 */
	private final Subject weatherData;

	public ChineseDisplay(Subject subject) {
		this.weatherData = subject;
		weatherData.registerObserver(this);
	}

	@Override
	public void display() {
		System.out.println("[ChineseDisplay] --> 温度: " +
				state.getTemperature() +
				", 湿度: " + state.getHumidity() +
				", 气压: " + state.getPressure());
	}


	@Override
	public void update(State state) {
		this.state = state;
		// ...
		display();
	}
}

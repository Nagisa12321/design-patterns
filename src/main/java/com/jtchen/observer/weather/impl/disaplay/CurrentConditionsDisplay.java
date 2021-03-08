package com.jtchen.observer.weather.impl.disaplay;

import com.jtchen.observer.weather.DisplayElement;
import com.jtchen.observer.weather.Observer;
import com.jtchen.observer.weather.Subject;
import com.jtchen.observer.weather.beans.State;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/3/8 18:21
 */
public class CurrentConditionsDisplay implements Observer, DisplayElement {
	private State state;
	private final Subject weatherData;

	public CurrentConditionsDisplay(Subject subject) {
		this.weatherData = subject;
		weatherData.registerObserver(this);
	}

	@Override
	public void display() {
		System.out.println("[CurrentConditionsDisplay] --> temperature: "
				+ state.getTemperature() + ", humidity: " + state.getHumidity());
	}

	@Override
	public void update(State state) {
		this.state = state;

		display();
	}
}

package com.jtchen.observer.weatherobservable.impl.disaplay;

import com.jtchen.observer.weatherobservable.DisplayElement;
import com.jtchen.observer.weatherobservable.beans.State;

import java.util.Observable;
import java.util.Observer;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/3/8 18:21
 */
public class CurrentConditionsDisplay implements Observer, DisplayElement {
	private State state;
	private final Observable weatherData;

	public CurrentConditionsDisplay(Observable subject) {
		this.weatherData = subject;
		weatherData.addObserver(this);
	}

	@Override
	public void display() {
		System.out.println("[CurrentConditionsDisplay] --> temperature: "
				+ state.getTemperature() + ", humidity: " + state.getHumidity());
	}


	@Override
	public void update(Observable o, Object arg) {
		this.state = (State) arg;
		display();
	}
}

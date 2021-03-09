package com.jtchen.observer.weatherobservable.impl.disaplay;

import com.jtchen.observer.weatherobservable.DisplayElement;
import com.jtchen.observer.weatherobservable.beans.State;
import com.jtchen.observer.weatherobservable.impl.WeatherData;

import java.util.Observable;
import java.util.Observer;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/3/9 11:38
 */
public class ForecastDisplay implements Observer, DisplayElement {

	private Observable observable;
	private String currentPressure;
	private String lastPressure;


	public ForecastDisplay(Observable observable) {
		this.observable = observable;
		observable.addObserver(this);
	}

	@Override
	public void display() {
		// 这里显示代码
	}

	@Override
	public void update(Observable o, Object arg) {
		WeatherData weatherData = (WeatherData) o;
		if (observable instanceof WeatherData) {
			State state = weatherData.getState();

			lastPressure = currentPressure;
			currentPressure = state.getPressure();

			display();
		}
	}
}

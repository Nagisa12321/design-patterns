package com.jtchen.observer.weatherObservable.impl.disaplay;

import com.jtchen.observer.weatherObservable.DisplayElement;
import com.jtchen.observer.weatherObservable.beans.State;

import java.util.Observable;
import java.util.Observer;

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
	private final Observable weatherData;

	public ChineseDisplay(Observable subject) {
		this.weatherData = subject;
		weatherData.addObserver(this);
	}

	@Override
	public void display() {
		System.out.println("[ChineseDisplay] --> 温度: " +
				state.getTemperature() +
				", 湿度: " + state.getHumidity() +
				", 气压: " + state.getPressure());
	}



	@Override
	public void update(Observable o, Object arg) {
		this.state = (State) arg;
		display();
	}
}

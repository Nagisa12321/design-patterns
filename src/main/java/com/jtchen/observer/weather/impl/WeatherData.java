package com.jtchen.observer.weather.impl;

import com.jtchen.observer.weather.Observer;
import com.jtchen.observer.weather.Subject;
import com.jtchen.observer.weather.beans.State;

import java.util.HashSet;
import java.util.Set;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/3/8 18:06
 */
public class WeatherData implements Subject {

	private final Set<Observer> obsList;

	private final State state;

	public WeatherData() {
		obsList = new HashSet<>();
		state = new State();
	}

	@Override
	public void registerObserver(Observer o) {
		obsList.add(o);
	}

	@Override
	public void removeObserver(Observer o) {
		obsList.remove(o);
	}

	@Override
	public void notifyObserver() {
		// 通知每个对象
		for (Observer o : obsList) {
			o.update(state);
		}
	}

	/*
		一旦气象数据更新, 该方法会被调用
	 */
	public void measurementsChanged() {
		// 通知每个对象
		notifyObserver();
	}

	public void setMeasurements(State state) {
		this.state.setHumidity(state.getHumidity());
		this.state.setPressure(state.getPressure());
		this.state.setTemperature(state.getTemperature());

		measurementsChanged();
	}
}

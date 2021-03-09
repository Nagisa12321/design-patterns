package com.jtchen.observer.weatherobservable.impl;

import com.jtchen.observer.weatherobservable.beans.State;

import java.util.Observable;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/3/8 18:06
 */
public class WeatherData extends Observable {

	private State state;

	public WeatherData() {
		state = new State();
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	/*
		一旦气象数据更新, 该方法会被调用
	 */
	public void measurementsChanged() {
		setChanged();
		// 通知每个对象
		notifyObservers(state);
	}

	public void setMeasurements(State state) {
		this.state.setHumidity(state.getHumidity());
		this.state.setPressure(state.getPressure());
		this.state.setTemperature(state.getTemperature());

		measurementsChanged();
	}
}

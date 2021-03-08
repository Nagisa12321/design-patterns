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
	֮�����ǿ�����Ҫȡ��ע��, ����Ѿ��ж�subject�����û�ȽϷ���
	 */
	private final Subject weatherData;

	public ChineseDisplay(Subject subject) {
		this.weatherData = subject;
		weatherData.registerObserver(this);
	}

	@Override
	public void display() {
		System.out.println("[ChineseDisplay] --> �¶�: " +
				state.getTemperature() +
				", ʪ��: " + state.getHumidity() +
				", ��ѹ: " + state.getPressure());
	}


	@Override
	public void update(State state) {
		this.state = state;
		// ...
		display();
	}
}

package com.jtchen.observer.weatherObservable.app;

import com.jtchen.observer.weatherObservable.beans.State;
import com.jtchen.observer.weatherObservable.impl.WeatherData;
import com.jtchen.observer.weatherObservable.impl.disaplay.ChineseDisplay;
import com.jtchen.observer.weatherObservable.impl.disaplay.CurrentConditionsDisplay;
import com.jtchen.observer.weatherObservable.utils.WeatherGetter;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/3/8 18:37
 */
public class WeatherStation {
	public static void main(String[] args) {
		WeatherData weatherData = new WeatherData();
		new CurrentConditionsDisplay(weatherData);
		new ChineseDisplay(weatherData);

		Runnable r1 = () -> {
			while (true) {
				long start = System.currentTimeMillis();
				try {
					Thread.sleep((int) (1000 * Math.random()));
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				State state = WeatherGetter.get();
				long end = System.currentTimeMillis();

				System.out.println();
				System.out.println("ʱ�� " + (end - start) + " ms, ����̨�и���");

				if (state != null)
					weatherData.setMeasurements(state);

			}
		};

		new Thread(r1).start();
	}
}

package com.jtchen.observer.weatherobservable.app;

import com.jtchen.observer.weatherobservable.beans.State;
import com.jtchen.observer.weatherobservable.impl.WeatherData;
import com.jtchen.observer.weatherobservable.impl.disaplay.ChineseDisplay;
import com.jtchen.observer.weatherobservable.impl.disaplay.CurrentConditionsDisplay;
import com.jtchen.observer.weatherobservable.utils.WeatherGetter;

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
				System.out.println("时隔 " + (end - start) + " ms, 气象台有更新");

				if (state != null)
					weatherData.setMeasurements(state);

			}
		};

		new Thread(r1).start();
	}
}

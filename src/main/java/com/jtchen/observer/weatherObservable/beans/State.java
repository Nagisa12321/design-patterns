package com.jtchen.observer.weatherObservable.beans;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/3/8 18:56
 */
public class State {
	private String temperature;
	private String humidity;
	private String pressure;

	public State() {
	}

	public State(String temperature, String humidity, String pressure) {
		this.temperature = temperature;
		this.humidity = humidity;
		this.pressure = pressure;
	}

	public String getTemperature() {
		return temperature;
	}

	public String getHumidity() {
		return humidity;
	}

	public String getPressure() {
		return pressure;
	}

	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}

	public void setHumidity(String humidity) {
		this.humidity = humidity;
	}

	public void setPressure(String pressure) {
		this.pressure = pressure;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("State{");
		sb.append("temperature=").append(temperature);
		sb.append(", humidity=").append(humidity);
		sb.append(", pressure=").append(pressure);
		sb.append('}');
		return sb.toString();
	}
}

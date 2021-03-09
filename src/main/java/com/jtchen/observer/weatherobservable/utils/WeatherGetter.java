package com.jtchen.observer.weatherobservable.utils;

import com.jtchen.observer.weatherobservable.beans.State;

/**
 * 获取成都天气
 * @author jtchen
 * @version 1.0
 * @date 2021/3/8 19:18
 */
public class WeatherGetter {
	public static State get() {
		/*CloseableHttpClient client = HttpClients.createDefault();

		HttpUriRequest request = RequestBuilder
				.create(HttpGet.METHOD_NAME)
				.addHeader("Connection", "keep-alive")
				.addHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/88.0.4324.96 Safari/537.36 Edg/88.0.705.53")
				.addHeader("charset", "UTF-8")
				.setUri("http://wthrcdn.etouch.cn/weather_mini?city=成都")
				.build();
		CloseableHttpResponse response = client.execute(request);
		HttpEntity entity = response.getEntity();

		JSONObject object = JSON.parseObject(EntityUtils.toString(entity, StandardCharsets.UTF_8));

		JSONObject today = (JSONObject) object.getJSONObject("data").getJSONArray("forecast").get(0);

		String temp = today.getString("low");
		String humidity = today.getString("fengli");
		String pressure = today.getString("fengxiang");*/

		String temp = "today.getString();";
		String humidity = "today.getString(fengli)";
		String pressure = "today.getString()";

		return new State(temp, humidity, pressure);
	}
}

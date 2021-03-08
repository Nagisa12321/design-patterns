package com.jtchen.observer.weather.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jtchen.observer.weather.beans.State;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * 获取成都天气
 * @author jtchen
 * @version 1.0
 * @date 2021/3/8 19:18
 */
public class WeatherGetter {
	public static State get() {
		try {
			CloseableHttpClient client = HttpClients.createDefault();

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
			String pressure = today.getString("fengxiang");

			return new State(temp, humidity, pressure);
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
}

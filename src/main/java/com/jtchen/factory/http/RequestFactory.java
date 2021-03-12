package com.jtchen.factory.http;

import com.alibaba.fastjson.JSONObject;
import com.jtchen.factory.http.beans.Pair;
import org.apache.http.NameValuePair;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;

import java.util.Map;
import java.util.Set;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/3/12 11:42
 */
public abstract class RequestFactory {
	public HttpUriRequest getRequestBuilder(String url, JSONObject data) {
		RequestBuilder request = createRequestBuilder();
		request.addHeader("Referer", "https://www.bilibili.com/")
				.addHeader("Connection", "keep-alive")
				.addHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/88.0.4324.96 Safari/537.36 Edg/88.0.705.53")
				.addParameters(getPairList(data))
				.setUri(url);

		return request.build();
	}

	public abstract RequestBuilder createRequestBuilder();

	public NameValuePair[] getPairList(JSONObject pJson) {
		Pair[] pairs = new Pair[pJson.size()];
		int idx = 0;

		Set<Map.Entry<String, Object>> entries = pJson.entrySet();
		for (Map.Entry<String, Object> entry :
				entries)
			pairs[idx++] = new Pair(entry.getKey(), val2String(entry.getValue()));
		return pairs;
	}

	public String val2String(Object val) {
		return val == null ? "" : (String) val;
	}
}

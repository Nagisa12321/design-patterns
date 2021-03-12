package com.jtchen.factory.http.impl;

import com.jtchen.factory.http.RequestFactory;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/3/12 11:48
 */
public class PostRequestFactory extends RequestFactory {
	@Override
	public RequestBuilder createRequestBuilder() {
		RequestBuilder requestBuilder = RequestBuilder.create(HttpPost.METHOD_NAME);

		requestBuilder.addHeader("accept", "application/json, text/plain, */*")
				.addHeader("Content-Type", "application/x-www-form-urlencoded")
				.addHeader("charset", "UTF-8");

		return requestBuilder;
	}
}

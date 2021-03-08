package com.jtchen.observer.weather;

import com.jtchen.observer.weather.beans.State;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/3/8 17:24
 */
public interface Observer {
	// 在被通知之后更新条目
	void update(State state);
}
